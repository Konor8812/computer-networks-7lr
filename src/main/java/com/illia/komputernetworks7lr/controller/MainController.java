package com.illia.komputernetworks7lr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.illia.komputernetworks7lr.model.entity.Article;
import com.illia.komputernetworks7lr.service.RequestProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class MainController {

  private final RequestProcessor requestProcessor;
  private final ObjectMapper objectMapper;

  @GetMapping("articles")
  public ResponseEntity<String> getAllArticles() throws JsonProcessingException {
    var articles = requestProcessor.getAllArticles();
    return ResponseEntity.ok(
        objectMapper.writeValueAsString(articles));
  }

  @GetMapping("articles/{id}")
  public ResponseEntity<String> getAllArticles(@PathVariable String id)
      throws JsonProcessingException {
    var article = requestProcessor.getArticle(id);
    return ResponseEntity.ok(
        objectMapper.writeValueAsString(article));
  }

  @PostMapping("articles")
  public ResponseEntity<String> createArticle(@RequestBody Article article)
      throws JsonProcessingException {
    var savedArticle = requestProcessor.saveArticle(article);
    return ResponseEntity.ok(
        objectMapper.writeValueAsString(savedArticle));
  }

  @PostMapping("articles/random")
  public ResponseEntity<String> createRandomArticle()
      throws JsonProcessingException {
    var savedArticle = requestProcessor.saveRandomArticle();
    return ResponseEntity.ok(
        objectMapper.writeValueAsString(savedArticle));
  }

}
