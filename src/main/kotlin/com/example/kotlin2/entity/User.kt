package com.guphone.bo.back.app.entity


import com.guphone.bo.back.app.constants.CommonConstants
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime


@Entity
class User(
        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        var userNo: Long? = null,

        @Column( nullable = false )
        var id: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var password: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var nickname: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var name: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var gender: String = CommonConstants.EMTY,

        @Column
        var phone: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var address1: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var address2: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var address3: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var zipcode: String = CommonConstants.EMTY,

        @Column
        var spare1: String = CommonConstants.EMTY,

        @Column
        var spare2: String = CommonConstants.EMTY,

        @Column
        var spare3: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var quitYn: String = CommonConstants.NO,

        @Column
        var quitDtm: LocalDateTime? = null,

        @Column( nullable = false )
        var authYn: String = CommonConstants.NO,

        @Column
        var authDtm: LocalDateTime? = null,

        @Column( nullable = false )
        var createDtm: LocalDateTime? = null,

        @Column( nullable = false )
        var createId: String? = null,

        @Column
        var modDtm: LocalDateTime = LocalDateTime.now(),

        @Column
        var modId: String? = null,

        @Column
        var delDtm: LocalDateTime? = null,

        @Column
        var delId: String? = null,
)