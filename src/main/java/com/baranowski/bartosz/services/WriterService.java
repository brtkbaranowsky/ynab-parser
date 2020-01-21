package com.baranowski.bartosz.services;

import com.baranowski.bartosz.domain.YnabRecord;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.baranowski.bartosz.ynab.YnabCostants.YNAB_HEADER;

public class WriterService {

    public void writeToFile(List<YnabRecord> ynabRecords, String outputFileName) {
        try (FileWriter fileWriter = new FileWriter(outputFileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            final String ynabHeader = YNAB_HEADER;

            bufferedWriter.write(ynabHeader + "\n");

            for (int i = 1; i < ynabRecords.size(); i++) {
                final YnabRecord ynabRecord = ynabRecords.get(i);
                String row = prepareRow(ynabRecord);
                bufferedWriter.write(row);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String prepareRow(YnabRecord ynabRecord) {
        String date = ynabRecord.getDate();
        String payee = ynabRecord.getPayee();
        String memo = ynabRecord.getMemo();
        String inflow = ynabRecord.getInflow();
        return String.format("%s,%s,%s,%s\n", date, payee, memo, inflow);
    }
}
