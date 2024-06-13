package com.test.integration.ai.services;

import com.test.integration.ai.models.Activity;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class AiServiceImpl implements AiService {

  private ChatClient chatClient;

  public AiServiceImpl(ChatClient chatClient) {
    this.chatClient = chatClient;
  }

  @Override
  public Activity getActivity(String about) {
    var outputParser = new BeanOutputParser<>(Activity.class);

    String userMessageSpanish =
        """
            A partir de informacion real, genera una actividad acerca de {about} que contenga una pregunta y cuatro posibles respuestas para esa pregunta. Solo una puede ser verdadera y la respuesta debe ser en español.
            {format}
            """;

    PromptTemplate promptTemplate = new PromptTemplate(userMessageSpanish,
        Map.of("about", about, "format", outputParser.getFormat()));
    Prompt prompt = promptTemplate.create();
    Generation generation = chatClient.call(prompt).getResult();
    log.info("Repuesta generada");
    return outputParser.parse(generation.getOutput().getContent());
  }
}
