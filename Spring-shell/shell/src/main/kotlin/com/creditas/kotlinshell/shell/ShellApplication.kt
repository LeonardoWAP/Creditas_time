package com.creditas.kotlinshell.shell

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ShellApplication

fun main(args: Array<String>) {
	runApplication<ShellApplication>(*args)
}
