package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


data class PostBookRequest(
        @field:NotBlank(message = "nome deve ser informado")
        var name : String,

        @field:NotNull (message = "preço deve ser informado")
        var price : BigDecimal,

        @JsonAlias("customer_id")
        var customerId : Int
)
