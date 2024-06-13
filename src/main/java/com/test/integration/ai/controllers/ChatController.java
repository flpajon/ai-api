package com.test.integration.ai.controllers;

import com.test.integration.ai.controllers.dtos.responses.GetActivityResponse;
import com.test.integration.ai.services.AiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/chat")
public class ChatController {

  private AiService aiService;

  public ChatController(AiService aiService) {
    this.aiService = aiService;
  }

  @GetMapping("/activity")
  public ResponseEntity<GetActivityResponse> getActivity(
      @RequestParam(name = "about") String about) {
    return ResponseEntity.ok(GetActivityResponse.from(aiService.getActivity(about)));
  }
}
