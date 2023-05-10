package com.illia.komputernetworks7lr.model.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Article {

  String id;
  String title;
  String body;

}
