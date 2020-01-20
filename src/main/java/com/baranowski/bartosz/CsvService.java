package com.baranowski.bartosz;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvService {

    public List<String> prepareCsvForParser(Config csvConfig) {
        List<String> filesContent = readCsvFromPath(csvConfig.getCsvPath(), csvConfig.getEncoding());
        filesContent = cutLeadingAndTailingRows(filesContent, csvConfig);
        return filesContent.stream().map(x -> x.concat("\n")).collect(Collectors.toList());
    }

    private List<String> readCsvFromPath(String csvPath, String encoding) {
        Path filePath = Paths.get(csvPath);
        try {
            return Files.readAllLines(filePath, Charset.forName(encoding));
        } catch (IOException e) {
            throw new NoCsvFileException(String.format("Correct csv file not found on path %s", csvPath));
        }
    }

    private List<String> cutLeadingAndTailingRows(List<String> filesContent, Config csvConfig) {
        int leadingRows = csvConfig.getLeadingRows();
        int tailingRows = csvConfig.getTailingRows();
        return filesContent.subList(leadingRows, filesContent.size() - tailingRows);
    }
}
