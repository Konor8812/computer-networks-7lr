package com.illia.storage;


import com.illia.model.entity.Article;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
@Component
public class Holder {
  private final Map<String, Article> savedEntities = new HashMap<>();
  public List<Article> getAllArticles(){
    return new ArrayList<>(savedEntities.values());
  }
  public Article getArticle(String id){
    return savedEntities.get(id);
  }
  public Article saveArticle(Article article){
    savedEntities.put(article.getId(), article);
    return savedEntities.get(article.getId());
  }

}
