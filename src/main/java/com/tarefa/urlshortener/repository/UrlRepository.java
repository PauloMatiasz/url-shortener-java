package com.tarefa.urlshortener.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tarefa.urlshortener.entities.UrlEntity;

public interface UrlRepository extends MongoRepository<UrlEntity, String> {
  
}