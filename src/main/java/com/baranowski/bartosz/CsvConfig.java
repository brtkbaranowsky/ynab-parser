package com.baranowski.bartosz;

public class CsvConfig {
    private String csvPath;
    private String encoding;
    private int leadingRows;
    private int tailingRows;

    public CsvConfig(String csvPath, String encoding, int leadingRows, int tailingRows) {
        this.csvPath = csvPath;
        this.encoding = encoding;
        this.leadingRows = leadingRows;
        this.tailingRows = tailingRows;
    }

    public String getCsvPath() {
        return csvPath;
    }

    public String getEncoding() {
        return encoding;
    }

    public int getLeadingRows() {
        return leadingRows;
    }

    public int getTailingRows() {
        return tailingRows;
    }
}
