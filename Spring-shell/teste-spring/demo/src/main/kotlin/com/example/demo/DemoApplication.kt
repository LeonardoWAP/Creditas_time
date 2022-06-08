package com.example.demo;

@ShellComponent
class MyCommands {
	@ShellM("Add two integers together.")
	fun add(a: Int, b: Int): Int {
		return a + b
	}
}





