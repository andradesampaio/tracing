package br.org.apiservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiServiceApplication

fun main(args: Array<String>) {
	runApplication<ApiServiceApplication>(*args)
}
