package com.guphone.bo.back.app.entity


import com.guphone.bo.back.app.constants.CommonConstants
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime


@Entity
@Table(name = "st_std_cd")
class Code(
        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        var cdNo: Long? = null,

        @Column( nullable = false )
        var grpCd: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var cd: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var cdNm: String = CommonConstants.EMTY,

        @Column
        var cdDesc: String = CommonConstants.EMTY,

        @Column( nullable = false )
        var useYn: String = CommonConstants.YES,

        @Column
        var sortSeq: Int,

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