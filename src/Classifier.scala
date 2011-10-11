/*
 * Copyright (c) 2011 Railinc.  All rights reserved.
 * 
 * Created on Sep 29, 2011
 */
/**
 * @author Hua Wu
 */
import scala.collection.mutable

class Classifier (number: Int)
{
	require(number >= 0)
	
	val _number = number
	val _factors = mutable.Set.empty[Int]
	
	def isPerfect() = 
	{
		sumOfFactorsFor() - _number == _number
	}
	
	private def sumOfFactorsFor() =
	{
		calculateFactors();
		
		var sum = 0
		_factors.foreach( sum += _ )
		
		sum
	}
	
	private def calculateFactors()
	{
    	_factors += 1
    	_factors += number
    
    	val upperLimit = Math.sqrt(_number).toInt + 1
		for (i <- 2 to upperLimit)
		{
			addFactor(i)
		}
    	
//    	println("Factors: " + _factors)
	}
	
	def calculatePrimaryFactors() =
	{
        var x = _number
        for(i <- 2 to _number)
        {
            while(x % i == 0 && x/i > 1)
            {
            	_factors += i 
            	x/=i
            }
        }
        
        if(x > 1)
        	_factors += x
      
    	println("Primary Factors of " + _number + ": " + _factors)
	}
	
	private def addFactor(i: Int)
	{
		if (isFactor(i))
		{
			_factors += i
			_factors += _number/i
		}
	}
	
	private def isFactor(factor: Int) = 
	{
		_number % factor == 0
	}
}

object Classifier extends Application
{
//	for (i <- 1 to 10000)
//	{
//    	val classifier = new Classifier(i)
//    	if (classifier.isPerfect())
//    	{
//    		println(i + " is a perfect number")
//    	}
//	}

   	val classifier = new Classifier(28)
   	classifier.calculatePrimaryFactors()

}