package com.baranowski.bartosz.services;

import com.baranowski.bartosz.domain.CsvConfig;
import com.baranowski.bartosz.exceptions.InvalidFieldException;
import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ConfigService {
  public CsvConfig readCsvConfigurationFile(String configurationFilePath) {
    Configurations configurations = new Configurations();
    try {
      INIConfiguration ynabConfig = configurations.ini(configurationFilePath);
      return CsvConfig.builder()
          .csvPath(ynabConfig.getString("csv_name_format").trim())
          .encoding(ynabConfig.getString("csv_encoding_charset").trim())
          .leadingRows(ynabConfig.getInt("leading_rows"))
          .tailingRows(ynabConfig.getInt("tailing_rows"))
          .dataColumnIndex(ynabConfig.getInt("date_column_index"))
          .payeeColumnIndex(ynabConfig.getInt("payee_column_index"))
          .titleColumnIndex(ynabConfig.getInt("title_column_index"))
          .amountColumnIndex(ynabConfig.getInt("amount_column_index"))
          .blockageColumnIndex(ynabConfig.getInt("blockage_column_index"))
          .filePrefix(ynabConfig.getString("file_prefix"))
          .inputDirectory(ynabConfig.getString("input_directory"))
          .outputDirectory(ynabConfig.getString("output_directory"))
          .build();
    } catch (ConfigurationException e) {
      throw new InvalidFieldException("Invalid field!");
    }
  }
}
