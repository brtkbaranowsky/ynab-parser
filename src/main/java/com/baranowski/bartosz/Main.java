package com.baranowski.bartosz;

import com.baranowski.bartosz.parser.IngVisitor;
import com.baranowski.bartosz.parser.YnabGrammarLexer;
import com.baranowski.bartosz.parser.YnabGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.baranowski.bartosz.ynab.YnabCostants.YNAB_HEADER;

public class Main {

    public static void main(String[] args) throws IOException {
        final String ynabHeader = YNAB_HEADER;
        final String configFilePath = "ynabParserConfig.ini";
        final String outputFileName = "Ynab_csv_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm")) + ".csv";
        IngVisitor ingVisitor = new IngVisitor();
        CsvService csvService = new CsvService();
        ConfigService configService = new ConfigService();
        Config csvConfig = configService.readConfigurationFile(configFilePath);
        YnabRecordService ynabRecordService = new YnabRecordService();

        List<String> filesContent = csvService.prepareCsvForParser(csvConfig);

        String filesContentString = String.join("", filesContent);
        YnabGrammarLexer ynabGrammarLexer = new YnabGrammarLexer(CharStreams.fromString(filesContentString));
        YnabGrammarParser ynabGrammarParser = new YnabGrammarParser(new CommonTokenStream(ynabGrammarLexer));
        ingVisitor.visitFile(ynabGrammarParser.file());

        final List<YnabRecord> ynabRecords = ynabRecordService.parseRecords(ingVisitor.getRows(), csvConfig);
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
