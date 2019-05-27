# mvel-ktx

mvel-ktx is a set of Kotlin extensions for [MVEL](https://en.wikipedia.org/wiki/MVEL)

## Getting started

This repository is hosted via [jitpack](https://jitpack.io/) since it's by far the easiest delivery method while also being pretty transparent to the developer.

Make sure you have added jitpack to the list of your repositories:

```kotlin
maven("https://jitpack.io")
```

Then simply add the `mvel-ktx` dependency

```kotlin
dependencies {
    compile("com.github.vishna:mvel-ktx:master-SNAPSHOT")
}
```

## Example usage

### Interpolation

```kotlin
val interpolatedString  = """@{resultCount} results matching "@{query}"""".interpolate(mapOf(
            "resultCount" to 256,
            "query" to "kotlin"
        ))

print(interpolatedString) // prints "256 results matching "kotlin"
```

### Evaluation

```kotlin
data class Foo(val bar: Int)
val sum : Int = """1 + 2 + bar""".eval(Foo(3))
println(sum) // prints "6"
```

For more documentation on API see [mvel.kt](https://github.com/vishna/mvel-ktx/blob/master/src/main/kotlin/dev/vishna/mvel/mvel.kt) and for more use examples see [mvel_tests.kt](https://github.com/vishna/mvel-ktx/blob/master/src/test/kotlin/dev/vishna/mvel/mvel_tests.kt)