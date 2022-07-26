package com.mercadolivro.controller.request

import com.mercadolivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest (
    @field:NotBlank (message = "nome deve ser informado")
    var name: String,

    @field:Email(message = "E-mail deve ser valido")
    @EmailAvailable
    var email : String,

    @field:NotEmpty(message = "Senha deve ser informada")
    var password: String
){

}