package com.baranowski.bartosz.ynab;

public final class YnabCostants {
    public static final String DATE_COLUMN_NAME = "Date";
    public static final String PAYEE_COLUMN_NAME = "Payee";
    public static final String MEMO_COLUMN_NAME = "Memo";
    public static final String AMOUNT_COLUMN_NAME = "Amount";
    public static final String SEPARATOR = ",";
    public static final String YNAB_HEADER = DATE_COLUMN_NAME + SEPARATOR + PAYEE_COLUMN_NAME + SEPARATOR + MEMO_COLUMN_NAME + SEPARATOR + AMOUNT_COLUMN_NAME;

    private YnabCostants() {
    }

}
