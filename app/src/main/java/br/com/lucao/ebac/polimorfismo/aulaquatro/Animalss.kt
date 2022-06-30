package br.com.lucao.ebac.polimorfismo.aulaquatro

fun main() {
    val ant = Ant()
    println()
    val lion = Lion()

    val animalList: List<Animal> = listOf(ant, lion)

    animalList.forEach { animal ->
        println(animal)
        animal.feed()
        println(animal)

        if(animal is Lion){
            animal.roar()
        }
    }
}

abstract class Animal {
    var energy: Int = 0
    abstract var minEnergy: Int

    abstract fun feed()
    abstract fun play()
    fun isHungry(): Boolean = energy < minEnergy

    override fun toString() = "Energy: $energy, isHungry: ${isHungry()}"
}

class Ant : Animal() {
    override var minEnergy = 2
    override fun feed() {
        this.energy++
    }

    override fun play() {
        this.energy--
    }
}

class Lion : Animal() {
    override var minEnergy = 120
    override fun feed() {
        this.energy = energy + 70
    }

    override fun play() {
        this.energy = energy - 50
    }

    fun roar() = println("Roaaaaaaaaaaaaaaaaar")
}

