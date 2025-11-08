# Learn Kotlin

A simple Kotlin console application demonstrating essential strengths of the Kotlin programming language.

## Features Demonstrated

This application showcases 10 key features of Kotlin:

1. **String Templates** - Embed expressions directly in strings
2. **Null Safety** - Compile-time null checking with safe call (`?.`) and Elvis (`?:`) operators
3. **Data Classes** - Concise class declarations with automatic `equals`, `hashCode`, `toString`, and `copy`
4. **Smart Casts** - Automatic type casting after type checks
5. **When Expressions** - Powerful replacement for switch statements
6. **Higher-Order Functions & Lambdas** - Functions as first-class citizens
7. **Extension Functions** - Add functionality to existing classes without inheritance
8. **Sealed Classes** - Exhaustive when expressions for representing restricted hierarchies
9. **Ranges** - Intuitive range expressions and progressions
10. **Collection Operations** - Rich functional-style collection processing

## Prerequisites

- Java 17 or higher
- Gradle 8.5 or higher (or use the included Gradle wrapper)

## Building the Project

```bash
./gradlew build
```

## Running the Application

```bash
./gradlew run
```

Or compile and run directly:

```bash
./gradlew installDist
./build/install/learn-kotlin/bin/learn-kotlin
```

## Project Structure

```
learn-kotlin/
├── src/
│   └── main/
│       └── kotlin/
│           └── Main.kt          # Main application file
├── build.gradle.kts              # Gradle build configuration
├── settings.gradle.kts           # Gradle settings
└── README.md                     # This file
```

## Learning Resources

- [Kotlin Official Documentation](https://kotlinlang.org/docs/home.html)
- [Kotlin Koans](https://play.kotlinlang.org/koans/overview)
- [Kotlin by Example](https://play.kotlinlang.org/byExample/overview)

## License

This is a learning project and is free to use and modify.