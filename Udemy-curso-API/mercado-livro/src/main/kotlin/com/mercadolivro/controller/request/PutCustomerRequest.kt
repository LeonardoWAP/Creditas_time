package com.mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCustomerRequest (

    @field: NotEmpty (message = "nome deve ser informado")
    var name: String,

    @field:Email(message = "E-mail deve ser valido")
    var email : String
)