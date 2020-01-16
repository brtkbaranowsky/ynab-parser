package com.baranowski.bartosz;

public class YnabRecord {
    String date;
    String payee;
    String memo;
    String inflow;

    public YnabRecord(String date, String payee, String memo, String inflow) {
        this.date = date;
        this.payee = payee;
        this.memo = memo;
        this.inflow = inflow;
    }

    public String getDate() {
        return date;
    }

    public String getPayee() {
        return payee;
    }

    public String getMemo() {
        return memo;
    }

    public String getInflow() {
        return inflow;
    }

    @Override
    public String toString() {
        return "YnabRecord{" +
                "date='" + date + '\'' +
                ", payee='" + payee + '\'' +
                ", memo='" + memo + '\'' +
                ", inflow='" + inflow + '\'' +
                "\n}";
    }
}
