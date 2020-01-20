package com.baranowski.bartosz;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Config {
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
