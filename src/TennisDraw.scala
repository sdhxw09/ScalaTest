import collection.mutable.ListBuffer
import io.Source
import java.io.{File, FileNotFoundException}

/**
 * Created by IntelliJ IDEA.
 * User: sdhxw09
 * Date: 7/19/11
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */

object TennisDraw
{
    def populatePlayer(record: String): Player =
    {
        val elements = record.split(',')
        val name = elements(0)
        val seed = elements(1)
        val city = elements(2)
        val state = elements(3)

        if (seed.isEmpty)
            new Player(name, city, state)
        else
            new Player(name, city, state, seed.toInt)
    }

    def getPlayers(file: String) =
    {
        val players = ListBuffer.empty[Player]
        try
        {
            for(line <- Source.fromFile(file).getLines())
            {
                val player = populatePlayer(line)
                players += player
            }
        }
        catch
        {
            case ex : FileNotFoundException => println(ex.getMessage)
        }

        players.toList
    }

    def main(args : Array[String])
    {
        getPlayers(args(0)).foreach(println)
    }
}