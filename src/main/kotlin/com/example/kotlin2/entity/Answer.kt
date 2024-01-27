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
class Answer(
        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        var answerNo: Long? = null,

        @Column( nullable = false )
        var title: String = CommonConstants.NO,

        @Column( nullable = false )
        var content: String = CommonConstants.NO,

        @Column( nullable = false )
        var type: String = CommonConstants.NO,

        @Column( nullable = false )
        var ansDtm: LocalDateTime? = null,

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

        @ManyToOne
        @JoinColumn( name = "askNo" )
        var askNo: Ask,
) {
}