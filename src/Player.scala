/**
 * Created by IntelliJ IDEA.
 * User: sdhxw09
 * Date: 7/20/11
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */

class Player(name: String, city: String, state: String, isSeed: Boolean, seedNum: Int)
{
    var _name = name
    var _city = city
    var _state = state
    var _isSeed = isSeed
    var _seedNum = seedNum

    def this(name: String) = this(name, "Cary", "NC", false, 0)
    def this(name: String, seedNum: Int) = this(name, "Cary", "NC", true, seedNum)
    def this(name: String, city: String, state: String) = this(name, city, state, false, 0)
    def this(name: String, city: String, state: String, seedNum: Int) = this(name, city, state, true, seedNum)

    override def toString() =
    {
        val seedDisplay = if (_isSeed) _seedNum; else " "
        seedDisplay + " " + _name + " " + _city + " " + _state
    }
}