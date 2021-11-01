package com.example.demo.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_questions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionEntity {
  @Id
  String kryId;
  String name;
}
