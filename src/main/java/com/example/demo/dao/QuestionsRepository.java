package com.example.demo.dao;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends CrudRepository<QuestionEntity, String> {
  Optional<QuestionEntity> findByName(String name);
}
