package com.example.demo.controller;

import com.example.demo.service.QuestionService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions/")
@AllArgsConstructor
public class QuestionsController {
  private final QuestionService questionService;

  @GetMapping()
  public List<QuestionResponse> getQuestions() {
    return questionService.getAll().stream().map(questionEntity -> new QuestionResponse(questionEntity.getKryId(), questionEntity.getName()))
        .collect(Collectors.toList());
  }

  @PostMapping()
  public void createQuestion(@RequestBody QuestionRequest questionRequest) {

  }

  @PutMapping("/:id")
  public void updateQuestion(@RequestBody QuestionRequest questionRequest, @PathVariable("id") String id) {

  }

  @GetMapping("name/:name")
  public QuestionResponse getQuestionByName(@PathVariable("name") String name) {
    val entity = questionService.getByName(name);
    return new QuestionResponse(entity.getKryId(), entity.getName());
  }
}
