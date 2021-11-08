package com.example.demo.service;

import com.example.demo.config.QuestionProperties;
import com.example.demo.controller.QuestionRequest;
import com.example.demo.dao.QuestionEntity;
import com.example.demo.dao.QuestionsRepository;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
  @NonNull
  private final QuestionsRepository repository;
  @NonNull
  private final QuestionProperties properties;
  @Value("${question.name-length}")
  private int nameLength;

  public List<QuestionEntity> getAll() {
    return Streamable.of(repository.findAll()).toList();
  }

  public QuestionEntity getByName(String name) {
    return repository.findByName(name).orElseThrow(() -> new RuntimeException());
  }

  public void create(QuestionRequest request) {
    repository.save(QuestionEntity.builder().name(request.getName()).build());
  }
}
