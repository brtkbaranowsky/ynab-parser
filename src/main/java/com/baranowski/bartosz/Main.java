package com.baranowski.bartosz;

import com.baranowski.bartosz.domain.CsvConfig;
import com.baranowski.bartosz.domain.YnabRecord;
import com.baranowski.bartosz.parser.CsvVisitor;
import com.baranowski.bartosz.parser.YnabGrammarLexer;
import com.baranowski.bartosz.parser.YnabGrammarParser;
import com.baranowski.bartosz.services.ConfigService;
import com.baranowski.bartosz.services.CsvService;
import com.baranowski.bartosz.services.WriterService;
import com.baranowski.bartosz.services.YnabRecordService;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    final String configFilePath = "ynabParserConfig.ini";

    CsvVisitor csvVisitor = new CsvVisitor();
    CsvService csvService = new CsvService();
    ConfigService configService = new ConfigService();
    YnabRecordService ynabRecordService = new YnabRecordService();
    WriterService writerService = new WriterService();

    CsvConfig csvConfig = configService.readCsvConfigurationFile(configFilePath);
    String filesContent = csvService.prepareCsvForParser(csvConfig);
    YnabGrammarLexer ynabGrammarLexer = new YnabGrammarLexer(CharStreams.fromString(filesContent));
    YnabGrammarParser ynabGrammarParser =
        new YnabGrammarParser(new CommonTokenStream(ynabGrammarLexer));
    csvVisitor.visitFile(ynabGrammarParser.file());

    final List<YnabRecord> ynabRecords =
        ynabRecordService.parseRecords(csvVisitor.getRows(), csvConfig);

    writerService.writeToFile(ynabRecords, csvConfig);
  }
}
