/*
 * Copyright (c) 2011 Railinc.  All rights reserved.
 * 
 * Created on Jun 25, 2011
 */
/**
 * @author Hua Wu
 */
import java.lang.Thread
import scala.actors.Actor

object ActorTest extends Application
{
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
}