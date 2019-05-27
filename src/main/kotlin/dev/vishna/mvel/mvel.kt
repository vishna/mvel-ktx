package dev.vishna.mvel

import org.mvel2.MVEL
import org.mvel2.templates.TemplateCompiler
import org.mvel2.templates.TemplateRuntime

/**
 * Interpolate MVEL string:
 *
 * ```kotlin
 * """@{resultCount} results matching "@{query}""".interpolate(mapOf(
 *   "resultCount" to 2,
 *   "query" to "foo"
 * ))
 * ```
 */
fun String?.interpolate(args: Map<String, Any>) : String? {
    if (this == null) return this

    val template = TemplateCompiler.compileTemplate(this)
    val description = TemplateRuntime.execute(template, args)
    return description.toString()
}

/**
 * Interpolate MVEL string with an instance of a class:
 *
 * ```kotlin
 * """@{resultCount} results matching "@{query}"""".interpolate(anything)
 * ```
 */
fun String?.interpolate(any: Any) : String? {
    if (this == null) return this

    val template = TemplateCompiler.compileTemplate(this)
    val description = TemplateRuntime.execute(template, any)
    return description.toString()
}

/**
 * Evaluates MVEL string expression against given context
 *
 * ```kotlin
 * data class Foo(val bar: Int)
 * """1 + 2 + bar""".eval(Foo(3)) // will be equal to 6
 * ```
 */
fun <T> String.eval(context: Any) : T {
    @Suppress("UNCHECKED_CAST")
    return MVEL.eval(this, context) as T
}