package com.example.androidkotlinhigherorderfuncs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstPerson = Person("abozar", 33, "Developer")
        val secondPerson = Person("mohsen", 30, "Full Stack Developer")

        val olderPerson = if (firstPerson.age >= secondPerson.age) firstPerson else secondPerson
        olderPerson.printPerson()

        // we can do the same things like above lines with higher order function but without define a variable "olderPerson"  we can use run function
        run {
            if (firstPerson.age >= secondPerson.age) firstPerson else secondPerson
        }.printPerson()

        // "with" function is useful when we want to modified on object and return what you want
        // we can use "with" function with extension function like below which called "println"
        with(firstPerson) {
            this.age += 1
            "Age is now $age"
        }.println()

        // in this function firstPerson is the receiver of the run function
        // this run function is as same as the above with function
        // it is recommended to use this function instead of use with
        firstPerson.run {
            this.age += 1
            "Age is now $age"
        }.println()

        // unlike run and with the "let" is best an argument and not receiver and receiver is "this"
        // as you can see in let argument "it" is person unlike the run and with "this" is person so in an argument we can rename "it"
        // when we rename the "it" to something like "modifiedPerson" it is access operator and should place in {} when we want to print it values
        firstPerson.let { modifiedPerson ->
            modifiedPerson.age += 1
            "Age is now ${modifiedPerson.age}"
        }.println()

        // apply is a standard higher order function
        // it has receiver of "this" and return also "this" which is the modified object
        // *** unlike "with" , "run" and "let" you can not return some string from here , it always return the same object on which you call "apply"
        // "apply" is used when we want to initialize an object and you can not put all of the arguments in the constructor because for example the constructor doesn't accept all the of the arguments which you want to supply
        // to avoid repeating two times "secondPerson" we can use apply like below
        secondPerson.age += 1
        secondPerson.job = "hot-dog seller"

        secondPerson.apply {
            age += 1
            job = "hot-dog seller"
        }.printPerson()

        // sometimes you want to use something like apply but you want to have a parameter which you can rename for example instead of a receiver
        // in this case we can use "also" higher order function
        secondPerson.also {
            it.age += 1
            it.job = "YouTuber"
        }.printPerson()


    }
}
