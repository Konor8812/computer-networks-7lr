package com.illia.service;

import com.illia.generator.ArticleGenerator;
import com.illia.model.entity.Article;
import com.illia.storage.Holder;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RequestProcessor {
  final Holder holder;
  final ArticleGenerator articleGenerator;

  public List<Article> getAllArticles(){
    return holder.getAllArticles();
  }

  public Article getArticle(String id){
    return holder.getArticle(id);
  }

  public Article saveArticle(Article article){
    return holder.saveArticle(article);
  }

  public Article saveRandomArticle(){
    return holder.saveArticle(articleGenerator.generateArticle());
  }
}
