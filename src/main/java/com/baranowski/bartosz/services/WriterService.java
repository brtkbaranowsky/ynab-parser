package com.baranowski.bartosz.services;

import com.baranowski.bartosz.domain.CsvConfig;
import com.baranowski.bartosz.domain.YnabRecord;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.baranowski.bartosz.ynab.YnabCostants.YNAB_HEADER;

public class WriterService {

  private static String prepareRow(YnabRecord ynabRecord) {
    String date = ynabRecord.getDate();
    String payee = ynabRecord.getPayee();
    String memo = ynabRecord.getMemo();
    String inflow = ynabRecord.getInflow();
    return String.format("%s,%s,%s,%s\n", date, payee, memo, inflow);
  }

  public void writeToFile(List<YnabRecord> ynabRecords, CsvConfig csvConfig) {
    final String outputFilePath =
        csvConfig.getOutputDirectory()
            + csvConfig.getFilePrefix()
            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            + ".csv";

    try (FileWriter fileWriter = new FileWriter(outputFilePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

      writeToCsv(YNAB_HEADER + "\n", bufferedWriter);
      ynabRecords.stream()
          .map(WriterService::prepareRow)
          .forEach(x -> writeToCsv(x, bufferedWriter));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeToCsv(String row, BufferedWriter writer) {
    try {
      writer.write(row);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
