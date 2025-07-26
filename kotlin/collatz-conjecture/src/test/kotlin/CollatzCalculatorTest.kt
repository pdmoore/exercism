import org.junit.Test
import kotlin.test.assertEquals

class CollatzCalculatorTest {

    @Test
    fun `zero steps for 1`() = assertStepsEqual(1, 0)

    @Test
    fun `divide if even`() = assertStepsEqual(16, 4)

    @Test
    fun `even and odd steps`() = assertStepsEqual(12, 9)

    @Test
    fun `large number of even and odd steps`() = assertStepsEqual(1000000, 152)

    @Test(expected = IllegalArgumentException::class)
    fun `invalid input - zero`() {
        steps(0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `invalid input - negative`() {
        steps(-15)
    }

    @Test
    fun `generateSequence behavior`() {
        // on its own will never terminate
        // println(generateSequence(1) { n -> if (n % 2 == 0) n / 2 else n * 3 + 1 }

        // take(n) allows it to run until n elements are generated
        println(generateSequence(1) { n -> if (n % 2 == 0) n / 2 else n * 3 + 1 }.take(n = 10).toList());

        // indexOf allows it to run until the element is found (and returns a non -1 value)
        println(generateSequence(16) { n -> if (n % 2 == 0) n / 2 else n * 3 + 1 }.indexOf(1) )
    }
}

private fun assertStepsEqual(input: Int, steps: Int) = assertEquals(steps, steps(input))

private fun steps(input: Int) = CollatzCalculator.computeStepCount(input)
