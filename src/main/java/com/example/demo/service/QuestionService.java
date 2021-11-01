package com.example.demo.service;

import com.example.demo.dao.QuestionEntity;
import com.example.demo.dao.QuestionsRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionService {
  private final QuestionsRepository repository;

  public List<QuestionEntity> getAll() {
    return Streamable.of(repository.findAll()).toList();
  }

  public QuestionEntity getByName(String name) {
    return repository.findByName(name).orElseThrow(() -> new RuntimeException());
  }
}
