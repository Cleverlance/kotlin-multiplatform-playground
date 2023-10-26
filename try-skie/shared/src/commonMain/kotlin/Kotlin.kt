@file:OptIn(ExperimentalObjCName::class, ExperimentalObjCRefinement::class)

import co.touchlab.skie.configuration.annotations.DefaultArgumentInterop
import kotlin.experimental.ExperimentalObjCName
import kotlin.experimental.ExperimentalObjCRefinement

@ObjCName("voidFunction")
fun unitFunction() {
}

@HiddenFromObjC
fun kotlinOnlyFunction() {
}

fun nothingFunction(): Nothing {
    throw Exception()
}

@Throws(Exception::class)
fun throwsFunction(): Nothing {
    throw Exception()
}

@DefaultArgumentInterop.Enabled
fun intFunction(a: Int, b: Int? = null): Long {
    return 0
}

fun listFunction(): List<String> {
    return emptyList()
}

fun mutableListFunction(): MutableList<String> {
    return mutableListOf()
}

val readOnlyProperty: String = ""
var readWriteProperty: String = ""

class Class

object Object

enum class City { London, Paris, NewYork }

data class User(val firstName: String, val lastName: String)
data class UltraUser(val firstName: String, val lastName: String)
data class SuperUser(val firstName: String, val lastName: String) {

    @DefaultArgumentInterop.Enabled
    fun doCopy(first: String = firstName, last: String = lastName): SuperUser {
        return copy(firstName = first, lastName = last)
    }
}

sealed interface Animal {
    data class Dog(val lives: Boolean) : Animal
    data object Dinosaur : Animal
}

interface Interface<T> {
    fun get(): T
}

class ImplementationOfInterface : Interface<String> {
    override fun get(): String = "Hello from Interface"
}

abstract class AbstractClass<T> {
    abstract fun get(): T
}

class ImplementationOfAbstractClass : AbstractClass<String>() {
    override fun get(): String = "Hello from Abstract Class"
}

suspend fun doSomethingAsync(input: String): Int {
    return 0
}