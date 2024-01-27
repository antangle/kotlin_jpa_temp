package com.guphone.bo.back.app.controller

import com.guphone.bo.back.app.dto.GuphoneDTO
import com.guphone.bo.back.app.service.GuphoneService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
@RequiredArgsConstructor
class GuphoneController (
        private val guphoneService: GuphoneService
) {


    companion object {
        const val SUCCESS = "SUCCESS"
    }


    @PostMapping("/api/member")
    fun saveMember( @RequestBody guphoneDTO: GuphoneDTO ) :String {
        guphoneService.saveMember( guphoneDTO )
        return SUCCESS
    }
}