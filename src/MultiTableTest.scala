/**
 * Created by IntelliJ IDEA.
 * User: sdhxw09
 * Date: 7/18/11
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */

object MultiTableTest
{
	def multiTable(max : Int) =
	{
		def maxNumDigits(num :Int) =
		{
			(num * num).toString.length + 1
		}

		def makeRowSequence(row :Int) =
		{
			for (col <- 1 to max) yield
			{
				val product = (row * col).toString
				val padding = " " * (maxNumDigits(max) - product.length)
				padding + product
			}
		}

		def makeRow(row : Int) =
		{
			makeRowSequence(row).mkString
		}

		val tableSequence =
		{
			for (row <- 1 to max)
				yield makeRow(row)
		}

		tableSequence.mkString("\n")
	}

	def main(args : Array[String])
	{
		println(multiTable(args(0).toInt))
	}
}