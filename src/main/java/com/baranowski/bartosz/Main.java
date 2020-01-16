package com.baranowski.bartosz;

import com.baranowski.bartosz.parser.IngVisitor;
import com.baranowski.bartosz.parser.YnabGrammarLexer;
import com.baranowski.bartosz.parser.YnabGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.baranowski.bartosz.ynab.YnabCostants.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final String ynabHeader = DATE_COLUMN_NAME + SEPARATOR + PAYEE_COLUMN_NAME + SEPARATOR + MEMO_COLUMN_NAME + SEPARATOR + AMOUNT_COLUMN_NAME;

        final String outputFileName = "Ynab_csv_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ".csv";
        final int dateIndex = 0;
        final int memoInfo = 3;
        final int additionalMemoInfo = 6;
        final int inflowIndex = 8;
        final int outflowIndex = 8;
        final int blockageIndex = 10;
        final String payee = "";


        String date = "";
        String memo = "";
        String inflow = "";
        String outflow = "";
        float ammount;

        String dateTransactionKeyword = "\"Data transakcji\"";
        String file = "sample.csv";
        Path filePath = Paths.get(file);

        String filesContent = Files.readAllLines(filePath, Charset.forName("ISO-8859-2")).stream().collect(Collectors.joining("\n"));
        //magic number
        filesContent = filesContent.substring(filesContent.indexOf(dateTransactionKeyword), filesContent.lastIndexOf(";;;;;;") + 6);
        System.out.println(filesContent);
        YnabGrammarLexer ynabGrammarLexer = new YnabGrammarLexer(CharStreams.fromString(filesContent));
        YnabGrammarParser ynabGrammarParser = new YnabGrammarParser(new CommonTokenStream(ynabGrammarLexer));
        IngVisitor ingVisitor = new IngVisitor();
        ingVisitor.visitFile(ynabGrammarParser.file());

        YnabRecordService ynabRecordService = new YnabRecordService();
        Map<String, Integer> configMap = new HashMap<>();
        configMap.put("DATE_INDEX", 0);
        configMap.put("PAYEE_INDEX", 2);
        configMap.put("TITLE_INDEX", 3);
        configMap.put("AMOUNT_INDEX", 8);
        configMap.put("BLOCKAGE_INDEX", 10);
        Config config = new Config(configMap);

        final List<YnabRecord> ynabRecords = ynabRecordService.parseRecords(ingVisitor.getRows(), config);
        System.out.println(ynabRecords);
        try (FileWriter fileWriter = new FileWriter(outputFileName); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(ynabHeader + "\n");

            for (int i = 1; i < ynabRecords.size(); i++) {
                final YnabRecord ynabRecord = ynabRecords.get(i);
                String row = prepareRow(ynabRecord);
                bufferedWriter.write(row);
            }

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
