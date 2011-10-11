import java.io.{Writer, PrintWriter, File}
import java.lang.Boolean

object ScalaTest
{
	def main(args : Array[String])
	{
        val words = List("you", "me", "admin", "bear")
        println(sortList(words).map(_.toUpperCase))
        println(sortList(words).flatMap(_.toUpperCase))

        loanPatternTest(new File("./test.txt"))
        {
            writer => writer.println("Hello, world!")
        }

        val numbers = List(8, 2, 7, 5, 4, 9, 1)
        println(quickSort(numbers))

        val numToFind = 7
        println(if (binarySearch(quickSort(numbers), numToFind)) "find " + numToFind else numToFind + " not available")

        println(calculateFibonacci(2, 3).take(9).toList)
	}

	def sortList(words: List[String]): List[String] =
	{
        words.sortWith((e1, e2) => e1.compareTo(e2) < 0)
	}

    def loanPatternTest(file: File)(op: PrintWriter => Unit)
    {
        val writer = new PrintWriter(file)

        try
        {
            op(writer)
        }
        finally
        {
            writer.close()
        }
    }

    private def quickSort(a: List[Int]): List[Int] =
    {
        if (a.length < 2)
            a
        else
        {
            val pivot = a(a.length/2)
            quickSort(a.filter(_ < pivot)) ::: a.filter(_ == pivot) ::: quickSort(a.filter(_ > pivot))
        }
    }

    def binarySearch(a: List[Int], number: Int): Boolean =
    {
        val pivot = a(a.length/2)
        if (pivot == number)
            true
        else
        {
            if (a.length < 2)
                false
            else
            {
                if (number < pivot)
                    binarySearch(a.take(a.length/2), number)
                else
                    binarySearch(a.drop(a.length/2), number)
            }
        }
    }

    def calculateFibonacci(a: Int, b: Int): Stream[Int] =
    {
        a #:: calculateFibonacci (b, a + b)
    }
}