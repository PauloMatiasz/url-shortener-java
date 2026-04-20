package com.tarefa.urlshortener.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tarefa.urlshortener.controller.dto.ShortenUrlRequest;
import com.tarefa.urlshortener.controller.dto.ShortenUrlResponse;
import com.tarefa.urlshortener.entities.UrlEntity;
import com.tarefa.urlshortener.repository.UrlRepository;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api") 
public class UrlController {

    private final UrlRepository urlRepository;

    public UrlController(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @PostMapping("/shorten-url")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(
            @RequestBody ShortenUrlRequest request,
            HttpServletRequest servletRequest) {

        if (request == null || request.url() == null || request.url().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (urlRepository.existsById(id));

        UrlEntity entity = new UrlEntity();
        entity.setId(id);
        entity.setFullUrl(request.url());
        entity.setExpiresAt(LocalDateTime.now().plusDays(1));

        urlRepository.save(entity);

        String baseUrl = servletRequest.getRequestURL().toString()
                .replace("/shorten-url", "");

        String redirectUrl = baseUrl + "/" + id;

        return ResponseEntity.ok(new ShortenUrlResponse(redirectUrl));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirect(@PathVariable String id) {

        var url = urlRepository.findById(id);

        if (url.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.get().getFullUrl()));

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }
}