package com.guphone.bo.back.app.service

import com.guphone.bo.back.app.dto.GuphoneDTO
import com.guphone.bo.back.app.dto.codeDTO
import com.guphone.bo.back.app.repository.CodeRepository
import org.springframework.stereotype.Service

@Service
class CodeService(
    private val codeRepository: CodeRepository
) {

    fun saveCode(codeDTO: codeDTO) {
        codeRepository.save(codeDTO.code)
    }
    fun findCode(code: codeDTO) {
        codeRepository.findAll()
    }
}