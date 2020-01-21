package com.baranowski.bartosz.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CsvConfig {
  private String inputDirectory;
  private String outputDirectory;
  private String filePrefix;

  private String csvPath;
  private String encoding;
  private int leadingRows;
  private int tailingRows;

  private int dataColumnIndex;
  private int payeeColumnIndex;
  private int titleColumnIndex;
  private int amountColumnIndex;
  private int blockageColumnIndex;
}
