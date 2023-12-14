package com.example.kotlin2.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@Entity
class Article(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var title: String,
    var headline: String,
    var content: String,
    var addedAt: LocalDateTime = LocalDateTime.now(),
)