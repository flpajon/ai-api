package com.test.integration.ai.models;

import java.util.List;
import lombok.Data;

@Data
public class Activity {

  private String activityQuestion;
  private List<Option> activityOptions;
}
