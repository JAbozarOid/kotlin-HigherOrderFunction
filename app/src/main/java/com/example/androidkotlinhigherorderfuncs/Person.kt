package com.example.androidkotlinhigherorderfuncs

data class Person(var name: String, var age: Int, var job: String) {

    // we use this function when we want to use some higher order function like "run" in specific use or "apply" and "also"
    fun printPerson() = println(this.toString())
}

// extension function is used when we want to use some higher order function like "with" or "let" and run in some specific conditions
fun String.println() = println(this)