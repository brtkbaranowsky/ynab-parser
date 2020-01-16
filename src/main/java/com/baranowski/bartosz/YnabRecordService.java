package com.baranowski.bartosz;

import com.baranowski.bartosz.ynab.ConfigConstants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.regex.Pattern.quote;

public class YnabRecordService {

    List<YnabRecord> parseRecords(List<RowRecord> rowRecords, Config config) {
        final List<Integer> configList = parseConfig(config);
        return rowRecords.stream().map(record -> parseSingleRecord(record, configList)).collect(Collectors.toList());
    }

    private List<Integer> parseConfig(Config config) {
        Integer indexOfDate = config.indexMap.get(ConfigConstants.DATE_COLUMN_NAME);
        Integer indexOfPayee = config.indexMap.get(ConfigConstants.PAYEE_COLUMN_NAME);
        Integer indexOfTitle = config.indexMap.get(ConfigConstants.TITLE_COLUMN_NAME);
        Integer indexOfAmount = config.indexMap.get(ConfigConstants.AMOUNT_COLUMN_NAME);
        Integer indexOfBlockage = config.indexMap.get(ConfigConstants.BLOCKAGE_COLUMN_NAME);
        return Arrays.asList(indexOfDate, indexOfPayee, indexOfTitle, indexOfAmount, indexOfBlockage);
    }

    private YnabRecord parseSingleRecord(RowRecord record, List<Integer> configList) {

        // Zabezpieczyc gety 
        // Dodac Enuma do indexow z configu


        String date = record.getField(configList.get(0)).get().replaceAll(quote(";"), "");
        String payee = "";
        String memo = record.getField(configList.get(1)).get().replaceAll(quote(";"), "").replaceAll(quote("\""), "").replaceAll(quote(","), " ");
        String additionalMemo = record.getField(configList.get(1)).get().replaceAll(quote(";"), "").replaceAll(quote("\""), "").replaceAll(quote(","), " ");
        memo = memo.concat(" - ").concat(additionalMemo);
        String inflow = record.getField(configList.get(3)).get().replaceAll(quote(";"), "");
        inflow = !inflow.isBlank()
                ? record.getField(configList.get(3)).get().replaceAll(quote(";"), "").replaceAll(quote(","), ".")
                : record.getField(configList.get(4)).get().replaceAll(quote(";"), "").replaceAll(quote("\""), ".");
        return new YnabRecord(date, payee, memo, inflow);
    }
}
