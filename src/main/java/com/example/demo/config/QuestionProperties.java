package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("question")
@Configuration
@Data
public class QuestionProperties {
  private int nameLength;
}
