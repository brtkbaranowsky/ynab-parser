package com.baranowski.bartosz.domain;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class RowRecord {
  List<String> fields;

  public RowRecord() {
    this.fields = new ArrayList<>();
  }

  public void add(String row) {
    fields.add(row);
  }

  public String getField(int indexOf) {
    return this.fields.get(indexOf);
  }
}
