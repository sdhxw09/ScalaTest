/*
 * Copyright (c) 2011 Railinc.  All rights reserved.
 * 
 * Created on Jun 25, 2011
 */
/**
 * @author Hua Wu
 */
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
import scala.actors._
import scala.collection.mutable

object ScalaHelloWorld extends Application
{
    val numbers = List(3, 5, 1, 6, 8, 9)
    numbers.foreach(println(_))
    
    println("The 3rd member is " + numbers.toArray.apply(2))
    
    object MyActor extends Actor
    {
      def act()
      {
        for(i <- 1 to 5)
        {
          println("I am acting ...")
          Thread.sleep(100)
        }
      }
    }
    
    MyActor.start()
    
    val capitals = Map("Washington DC"->"US", "Beijing"->"China")
    capitals.foreach(p => printf("The capital of %s is %s.\n", p._2, p._1))
    //for ((x, y) <- capitals)
    //{
    //  printf("The capital of %s is %s.\n", y, x)
    //}
    
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
    
    testCatch()
    
    def testFilter = {
      numbers.filter(_ > 5)
    }
    
    println(testFilter)
    
    class Time
    {
        var hour:Int = _
        var minute:Int = _
    }
    
    var myTime = new Time
    myTime.hour = 22
    myTime.minute = 25
    println("Current time is " + myTime.hour + ":" + myTime.minute)
    
    def testTuple() = {
    	val name = "David Lier"
    	val age = 35
    	
    	(name, age)
    }
    
    val (name, age) = testTuple
    println(name + " is " + age + " years old.")
    
    def buildList(maxNum: Int): List[String] = {
        val newList = mutable.ListBuffer.empty[String]
        for (i <- 1 to maxNum) {
            newList += "*" * i
        }
        newList.toList   // turn the mutable into immutable
    }
    println(buildList(5))
    

}