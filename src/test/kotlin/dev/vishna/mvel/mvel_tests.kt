package dev.vishna.mvel

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should equal`
import org.junit.Test
import org.mvel2.MVEL

class MVELTests {

    @Test
    fun `String interpolation with a map`() {
        val interpolatedString  = """@{resultCount} results matching "@{query}"""".interpolate(mapOf(
            "resultCount" to 256,
            "query" to "kotlin"
        ))

        interpolatedString `should equal` """256 results matching "kotlin""""
    }

    @Test
    fun `String interpolation with an object`() {
        val interpolatedString  = """@{resultCount} results matching "@{query}"""".interpolate(TestData(
            resultCount = 256,
            query = "kotlin"
        ))

        interpolatedString `should equal` """256 results matching "kotlin""""
    }

    @Test
    fun `String expression evaluation`() {
        data class Foo(val bar: Int)
        val sum : Int = """1 + 2 + bar""".eval(Foo(3))
        sum `should be equal to` 6
    }
}

internal data class TestData(val resultCount: Int, val query: String)