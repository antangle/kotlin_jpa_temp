package com.guphone.bo.back.app.entity


import com.guphone.bo.back.app.constants.CommonConstants
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import java.time.LocalDateTime


@Entity
class File(
        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        var fileNo: Long? = null,

        @Column( nullable = false )
        var type: String = CommonConstants.NO,

        @Column( nullable = false )
        var seqNo: Long,

        @Column( nullable = false )
        var name: String = CommonConstants.NO,

        @Column( nullable = false )
        var path: String = CommonConstants.NO,

        @Column( nullable = false )
        var uuidName: String = CommonConstants.NO,

        @Column( nullable = false )
        var mainYn: String = CommonConstants.NO,

        @Column( nullable = false )
        var sortSeq: Integer,

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