package com.creditas.kotlinshell.shell

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomConfig {

    @Bean
    fun saldo(): Int{
        return 123
    }
}