package com.baranowski.bartosz.services;

import com.baranowski.bartosz.domain.CsvConfig;
import com.baranowski.bartosz.domain.RowRecord;
import com.baranowski.bartosz.domain.YnabRecord;
import com.baranowski.bartosz.exceptions.EmptyDateException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.regex.Pattern.quote;



public class YnabRecordService {

  public List<YnabRecord> parseRecords(List<RowRecord> rowRecords, CsvConfig csvConfig) {
    return rowRecords.stream()
        .map(record -> parseSingleRecord(record, csvConfig))
        .collect(Collectors.toList());
  }

  private YnabRecord parseSingleRecord(RowRecord record, CsvConfig csvConfig) {
    String date = record.getField(csvConfig.getDataColumnIndex());
    String payee = "";
    String memo = record.getField(csvConfig.getPayeeColumnIndex());
    String additionalMemo = record.getField(csvConfig.getTitleColumnIndex());
    memo = memo.concat(" - ").concat(additionalMemo);

    String inflow = record.getField(csvConfig.getAmountColumnIndex());
    inflow = cleanInflow(inflow);
    inflow = inflow.isBlank()
            ? record.getField(csvConfig.getBlockageColumnIndex())
            : record.getField(csvConfig.getAmountColumnIndex());

    return new YnabRecord(cleanDate(date), payee, cleanMemo(memo), cleanInflow(inflow));
  }

  private String cleanDate(String date) {
    if (date.isBlank()) {
      throw new EmptyDateException("Date cannot be empty!");
    }
    return date.replaceAll(quote(";"), "");
  }

  private String cleanInflow(String amount) {
    return amount.replaceAll(quote(";"), "");
  }

  private String cleanMemo(String memo) {
    return memo.replaceAll(quote(";"), "").replaceAll(quote("\""), "").replaceAll(quote(","), " ");
  }
}
