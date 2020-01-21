package com.baranowski.bartosz.services;

import com.baranowski.bartosz.domain.CsvConfig;
import com.baranowski.bartosz.exceptions.NoCsvFileException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CsvService {

  public String prepareCsvForParser(CsvConfig csvConfig) {

    Pattern pattern = Pattern.compile(csvConfig.getCsvPath());
    final List<String> validCsvList =
        readFileList(csvConfig.getInputDirectory()).stream()
            .filter(x -> pattern.matcher(x).matches())
            .map(x -> csvConfig.getInputDirectory().concat(x))
            .collect(Collectors.toList());

    String csvRows = "";
    for (String csvPath : validCsvList) {
      List<String> filesContent = readCsvFromPath(csvPath, csvConfig.getEncoding());
      filesContent = cutLeadingAndTailingRows(filesContent, csvConfig);
      csvRows = csvRows.concat(String.join("\n", filesContent));
    }
    System.out.println(csvRows);
    return csvRows;
  }

  private List<String> readCsvFromPath(String csvPath, String encoding) {
    Path filePath = Paths.get(csvPath);
    try {
      return Files.readAllLines(filePath, Charset.forName(encoding));
    } catch (IOException e) {
      throw new NoCsvFileException(String.format("Correct csv file not found on path %s", csvPath));
    }
  }

  private List<String> cutLeadingAndTailingRows(List<String> filesContent, CsvConfig csvConfig) {
    int leadingRows = csvConfig.getLeadingRows();
    int tailingRows = csvConfig.getTailingRows();
    return filesContent.subList(leadingRows, filesContent.size() - tailingRows);
  }

  private List<String> readFileList(String directory) {
    return Arrays.asList(Objects.requireNonNull(new File(directory).list()));
  }
}
