import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
import scala.collection.mutable
    
object ScalaTest extends Application
{
    val numbers = List[Int](2,-1,3,-5,6,9)
    numbers.filter(_ > 0).foreach(println(_))
    
    val myTime = new Time(22, 30)
    println("The time is " + myTime.hour + ":" + myTime.minute)
    
    val address = Address("209 Pine gate Dr.", "Durham", "NC", "27713")
    println(address)
    
    val sumOfSquares = (1 to 20).map { i => i * i }.sum
    println(sumOfSquares)
    
    val myScalaTest = new ScalaTest()
    myScalaTest.testSwitch("French")
    myScalaTest.testSwitch("Spanish")
    myScalaTest.testCatch()
    
    println(myScalaTest.buildList(6))

    val capitals = Map("Washington DC"->"US", "Beijing"->"China")
    capitals.foreach(p => printf("The capital of %s is %s.\n", p._2, p._1))
}

case class Address(street: String, city: String, state: String, zip: String)
class Time(var hour: Int, var minute: Int)
    
class ScalaTest
{
    def buildList(maxNum: Int): List[String] = {
    	val newList = mutable.ListBuffer.empty[String]
    	for (i <- 1 to maxNum) 
    	{
    		newList += "*" * i
    	}
    
    	newList.toList // turn the mutable into immutable
    }
    
    def testSwitch(lang:String) = lang match {
        case "English" => println("You choose English")
        case "German" => println("You choose German")
        case "French" => println("You choose French")
        case "Chinese" => println("You choose CHinese")
        case _ => println("You choose Nothing")
    }

    def testCatch()
    {
      try
      {
        val fileReader = new FileReader("input.txt")
      }
      catch
      {
        case ex:FileNotFoundException => println("FileNotFoundException thrown!")
        case ex:IOException => println("IOException thrown!")
      }
    }
}
