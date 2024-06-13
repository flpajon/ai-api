package com.test.integration.ai.services;

import com.test.integration.ai.models.Activity;

public interface AiService {
  Activity getActivity(String about);
}
