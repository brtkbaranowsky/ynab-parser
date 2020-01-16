package com.baranowski.bartosz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RowRecord {
    List<String> fields;

    public RowRecord() {
        this.fields = new ArrayList<>();
    }

    public void add(String row) {
        fields.add(row);
    }

    public List<String> getFields() {
        return fields;
    }

    public Optional<String> getField(int indexOf) {
        return Optional.ofNullable(this.fields.get(indexOf));
    }

    @Override
    public String toString() {
        return "RowRecord{" +
                "fields=" + fields +
                '}';
    }
}
