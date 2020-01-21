package com.baranowski.bartosz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class YnabRecord {
  String date;
  String payee;
  String memo;
  String inflow;
}
