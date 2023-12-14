package com.example.kotlin2.controller


import com.example.kotlin2.entity.Article
import com.example.kotlin2.repositories.ArticleRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController(
    private val articleRepository: ArticleRepository
) {

    @GetMapping("/test")
    fun listStocks(): List<Article> {
        return articleRepository.findAll();
    }
}
