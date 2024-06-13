package com.test.integration.ai.controllers.dtos.responses;


import com.test.integration.ai.models.Activity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetActivityResponse {

  private Activity activity;

  public static GetActivityResponse from(Activity activity) {
    return builder().activity(activity).build();
  }
}
