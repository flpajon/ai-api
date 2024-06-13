package com.test.integration.ai.models;

import lombok.Data;

@Data
public class Option {

  private String optionName;
  private Boolean optionIsCorrect;
  private Integer optionOrder;
}
