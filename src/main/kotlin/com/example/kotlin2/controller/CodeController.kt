package com.guphone.bo.back.app.controller

import com.guphone.bo.back.app.dto.GuphoneDTO
import com.guphone.bo.back.app.dto.codeDTO
import com.guphone.bo.back.app.service.CodeService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class CodeController (
    private val codeService: CodeService
){
    @PostMapping("/api/member")
    fun saveMember( @RequestBody codeDTO: codeDTO) :String {
        codeService.saveCode( codeDTO )
        return GuphoneController.SUCCESS
    }
}