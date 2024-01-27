package com.guphone.bo.back.app.service


import com.guphone.bo.back.app.dto.GuphoneDTO
import org.springframework.stereotype.Service


@Service
class GuphoneService {
    fun saveMember( guphoneDTO: GuphoneDTO ) {
        println( guphoneDTO )
    }
}