package com.baranowski.bartosz.parser;

import com.baranowski.bartosz.domain.RowRecord;

import java.util.ArrayList;
import java.util.List;

import static com.baranowski.bartosz.parser.YnabGrammarParser.*;

@SuppressWarnings("rawtypes")
public class CsvVisitor extends YnabGrammarBaseVisitor {

  private List<RowRecord> rows;

  @Override
  public Object visitFile(FileContext ctx) {
    rows = new ArrayList<>();
    return super.visitFile(ctx);
  }

  @Override
  public Object visitRow(RowContext ctx) {
    RowRecord rowRecord = new RowRecord();
    for (int i = 0; i < ctx.getChildCount(); i++) {
      rowRecord.add(ctx.getChild(i).getText());
    }
    rows.add(rowRecord);
    return super.visitRow(ctx);
  }

  public Object visitField(FieldContext ctx) {
    return super.visitField(ctx);
  }

  public List<RowRecord> getRows() {
    return rows;
  }
}
