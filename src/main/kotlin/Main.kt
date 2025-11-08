/**
 * A simple Kotlin console application demonstrating key language features.
 */

// Data class - demonstrates concise class declarations with automatic equals, hashCode, toString
data class Person(val name: String, val age: Int, val email: String?)

// Sealed class - demonstrates exhaustive when expressions
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

// Extension function - adds functionality to existing classes without inheritance
fun String.isPalindrome(): Boolean {
    val cleaned = this.lowercase().filter { it.isLetterOrDigit() }
    return cleaned == cleaned.reversed()
}

// Higher-order function - functions that take other functions as parameters
fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

fun main() {
    println("=== Welcome to Learn Kotlin ===\n")

    // 1. String Templates
    println("1. String Templates:")
    val language = "Kotlin"
    val version = 2.0
    println("   Learning $language version $version")
    println("   Expression in template: ${2 + 2} = 4\n")

    // 2. Null Safety
    println("2. Null Safety:")
    val person1 = Person("Alice", 30, "alice@example.com")
    val person2 = Person("Bob", 25, null)
    
    // Safe call operator (?.)
    println("   ${person1.name}'s email: ${person1.email}")
    println("   ${person2.name}'s email: ${person2.email ?: "Not provided"}")  // Elvis operator
    println()

    // 3. Data Classes
    println("3. Data Classes:")
    println("   Person 1: $person1")
    val person3 = person1.copy(age = 31)  // Copy with modification
    println("   Person 3 (copied from Person 1): $person3")
    println("   Are they equal? ${person1 == person3}")
    println()

    // 4. Smart Casts
    println("4. Smart Casts:")
    fun printLength(obj: Any) {
        if (obj is String) {
            // obj is automatically cast to String in this block
            println("   String length: ${obj.length}")
        } else {
            println("   Not a string")
        }
    }
    printLength("Hello Kotlin")
    printLength(42)
    println()

    // 5. When Expression (like switch but better)
    println("5. When Expression:")
    fun describe(obj: Any): String = when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long number"
        !is String -> "Not a string"
        else -> "Unknown"
    }
    println("   describe(1): ${describe(1)}")
    println("   describe('Hello'): ${describe("Hello")}")
    println("   describe(100L): ${describe(100L)}")
    println()

    // 6. Higher-Order Functions and Lambdas
    println("6. Higher-Order Functions and Lambdas:")
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenNumbers = numbers.filter { it % 2 == 0 }
    val squared = evenNumbers.map { it * it }
    println("   Original: $numbers")
    println("   Even numbers: $evenNumbers")
    println("   Squared: $squared")
    
    // Custom higher-order function
    val greaterThanFive = numbers.customFilter { it > 5 }
    println("   Greater than 5 (custom filter): $greaterThanFive")
    println()

    // 7. Extension Functions
    println("7. Extension Functions:")
    val word1 = "racecar"
    val word2 = "hello"
    println("   Is '$word1' a palindrome? ${word1.isPalindrome()}")
    println("   Is '$word2' a palindrome? ${word2.isPalindrome()}")
    println()

    // 8. Sealed Classes and Exhaustive When
    println("8. Sealed Classes:")
    fun handleResult(result: Result) {
        val message = when (result) {
            is Result.Success -> "Success: ${result.data}"
            is Result.Error -> "Error: ${result.message}"
            is Result.Loading -> "Loading..."
        }
        println("   $message")
    }
    handleResult(Result.Success("Data loaded"))
    handleResult(Result.Error("Network error"))
    handleResult(Result.Loading)
    println()

    // 9. Range and Progression
    println("9. Ranges:")
    print("   Countdown from 5: ")
    for (i in 5 downTo 1) {
        print("$i ")
    }
    println()
    
    val inRange = 5 in 1..10
    println("   Is 5 in range 1..10? $inRange")
    println()

    // 10. Collection Operations
    println("10. Collection Operations:")
    val fruits = listOf("apple", "banana", "cherry", "date", "elderberry")
    val longFruits = fruits.filter { it.length > 5 }
    val upperFruits = fruits.map { it.uppercase() }
    val firstLongFruit = fruits.firstOrNull { it.length > 6 }
    
    println("   Fruits: $fruits")
    println("   Long fruits (>5 chars): $longFruits")
    println("   Uppercase: $upperFruits")
    println("   First fruit >6 chars: ${firstLongFruit ?: "None"}")
    println()

    println("=== End of Kotlin Demo ===")
}
