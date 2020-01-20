package com.baranowski.bartosz;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvService {

    public List<String> prepareCsvForParser(String csvPath, int leadingRows, int tailingRows) {
        final String encoding = "ISO-8859-2";
        List<String> filesContent = readCsvFromPath(csvPath, encoding);
        filesContent = cutLeadingAndTailingRows(filesContent, leadingRows, tailingRows);
        return filesContent.stream().map(x -> x.concat("\n")).collect(Collectors.toList());
    }

    private List<String> readCsvFromPath(String csvPath, String encoding) {
        Path filePath = Paths.get(csvPath);
        try {
            return Files.readAllLines(filePath, Charset.forName(encoding));
        } catch (IOException e) {
            throw new NoCsvFileException(String.format("Correct csv file not found on path %s", path));
        }
    }

    private List<String> cutLeadingAndTailingRows(List<String> filesContent, int leadingRows, int tailingRows) {
        return filesContent.subList(leadingRows, filesContent.size() - tailingRows);
    }
}
