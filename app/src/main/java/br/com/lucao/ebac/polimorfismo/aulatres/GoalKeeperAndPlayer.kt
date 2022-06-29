package br.com.lucao.ebac.polimorfismo.aulatres

class GoalKeeperAndPlayer {}

fun main(){
    val players = GoalKeeper()
    players.goalsConceded = 3
    players.name = "Lucas"
    players.number = 1

    print(players)
    println(players.rating())
    println(players.isGoodPlayer())
}

interface Players {
    var name: String
    var number: Int
    fun rating(): Int

    fun isGoodPlayer(): Boolean{
        return rating() > 5
    }
}

class GoalKeeper : Players {
    override var name: String = ""
    override var number: Int = 0
    var goalsConceded = 0

    override fun rating() = 5

    override fun toString() = "name: $name number: $number goals: $goalsConceded"
}

