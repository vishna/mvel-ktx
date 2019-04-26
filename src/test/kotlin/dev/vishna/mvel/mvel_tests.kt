package dev.vishna.mvel

import org.amshove.kluent.`should equal`
import org.junit.Test

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
}

internal data class TestData(val resultCount: Int, val query: String)