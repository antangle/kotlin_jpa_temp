package com.guphone.bo.back.app.entity


import com.guphone.bo.back.app.constants.CommonConstants
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDateTime


@Entity
class Device(
        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        var deviceNo: Long? = null,

        @Column( nullable = false )
        var maker: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var deviceName: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var model: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var status: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var releaseDtm: LocalDateTime? = null,

        @Column
        var spare1: String = CommonConstants.EMTY,

        @Column
        var spare2: String = CommonConstants.EMTY,

        @Column
        var spare3: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var createDtm: LocalDateTime? = null,

        @Column( nullable = false )
        var createId: String? = null,

        @Column
        var modDtm: LocalDateTime = LocalDateTime.now(),

        @Column
        var modId: String? = null,
) {
}