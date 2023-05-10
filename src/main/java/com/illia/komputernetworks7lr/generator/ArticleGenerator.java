package com.illia.komputernetworks7lr.generator;


import com.illia.komputernetworks7lr.model.entity.Article;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class ArticleGenerator {
  private final Random random = new Random();
  public Article generateArticle(){
    var seed = random.nextInt();
    if(seed < 0) {
      seed *= -1;
    }
    return Article.builder()
        .id("Generated id " + random.nextInt(seed))
        .title("Generated article " + random.nextInt(seed))
        .body("Generated body " + random.nextInt())
        .build();
  }
}
