package com.baranowski.bartosz.services;

import com.baranowski.bartosz.domain.Config;
import com.baranowski.bartosz.domain.RowRecord;
import com.baranowski.bartosz.domain.YnabRecord;
import com.baranowski.bartosz.exceptions.EmptyDateException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.regex.Pattern.quote;

public class YnabRecordService {

    public List<YnabRecord> parseRecords(List<RowRecord> rowRecords, Config config) {
        return rowRecords.stream().map(record -> parseSingleRecord(record, config)).collect(Collectors.toList());
    }


    private YnabRecord parseSingleRecord(RowRecord record, Config config) {

        Optional<String> date = record.getField(config.getDataColumnIndex());
        String payee = "";
        Optional<String> memo = record.getField(config.getPayeeColumnIndex());
        Optional<String> additionalMemo = record.getField(config.getTitleColumnIndex());
        if (memo.isPresent() && additionalMemo.isPresent()) {
            memo = Optional.of(memo.get().concat(" - ").concat(additionalMemo.get()));
        }


        Optional<String> inflow = record.getField(config.getAmountColumnIndex());
        inflow = cleanAmount(inflow.get());
        inflow = inflow.get().isBlank()
                ? record.getField(config.getBlockageColumnIndex())
                : record.getField(config.getAmountColumnIndex());

        date = cleanDate(date.get());
        memo = cleanMemo(memo.get());
        inflow = cleanAmount(inflow.get());

        return new YnabRecord(date.get(), payee, memo.get(), inflow.get());
    }

    private Optional<String> cleanDate(String date) {
        if (date.isEmpty()) {
            throw new EmptyDateException("Date cannot be empty!");
        }
        return Optional.of(date.replaceAll(quote(";"), ""));
    }

    private Optional<String> cleanAmount(String amount) {
        return Optional.of(amount.replaceAll(quote(";"), ""));
    }

    private Optional<String> cleanMemo(String memo) {
        return Optional.of(memo.replaceAll(quote(";"), "")
                .replaceAll(quote("\""), "")
                .replaceAll(quote(","), " "));
    }
}
