package com.mauapps.dasusapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DasusappApplication

fun main (args: Array<String>) {
	runApplication<DasusappApplication>(*args)
}