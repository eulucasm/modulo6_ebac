package br.com.lucao.ebac.polimorfismo.auladois

fun main() {
   var players = GoalKeeper()
   players.goalsConceded = 3
   players.name = "Lucas"
   players.number = 1

   println(players.rating())
   println(players.isGoodPlayer())

}

abstract class Players {
   abstract var name: String
   abstract var number: Int

   abstract fun rating(): Int

   fun isGoodPlayer(): Boolean{
      return rating() > 5
   }
}

class GoalKeeper : Players() {
   override var name: String = ""
   override var number: Int = 0
   var goalsConceded = 0

   override fun rating(): Int {
      return when{
         goalsConceded < 15 -> 10
         goalsConceded < 30 -> 5
         else -> 0
      }
   }
}