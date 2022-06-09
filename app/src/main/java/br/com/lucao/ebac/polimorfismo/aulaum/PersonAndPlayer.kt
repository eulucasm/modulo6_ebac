package br.com.lucao.ebac.polimorfismo.aulaum

open class Person {
   var name: String = ""
   var email: String = ""

   override fun toString() = "nome: $name email: $email"
}

class Player : Person() {
   var number: Int = 0
   override fun toString() = super.toString() + "numero: ${this.number}"
}

fun main() {

   var person = Person()
   person.name = "Lucas"
   person.email = "email@mail.com"

   var player = Player()
   player.number = 99
   player.name = "Jordan"
   player.email = "mail@email.com"
   println(player)

   if(person is Person){
      println("é uma pessoa")
   }else if(player is Player){
      println("é Jogador")
   }
}