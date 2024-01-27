package com.guphone.bo.back.app.repository

import com.guphone.bo.back.app.entity.Code
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CodeRepository : JpaRepository<Code, Long> {}