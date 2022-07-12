package br.com.lucao.ebac.polimorfismo.aulacincofactory

fun main(){

    val factory = AnimalFactory()
    val animalListt: MutableList<Animall> = mutableListOf()

    for(i in 1..100){
        val animal = factory.createAnimal(i % 2, i)
        animalListt.add(animal)
    }

    animalListt.forEach { animal ->
        println(animal)
        animal.feed()
        println(animal)

        if(animal is Lion){
            animal.roar()
        }
    }
}

class AnimalFactory() {
    fun createAnimal(type: Int, id: Int) :Animall{
        return when(type){
            1 -> Ant(id)
            else -> Lion(id)
        }
    }
}

abstract class Animall(private val id: Int) {


    var energy: Int = 0
    abstract var minEnergy: Int

    abstract fun feed()
    abstract fun play()
    fun isHungry(): Boolean = energy < minEnergy

    override fun toString() = "id: $id ,Energy: $energy, isHungry: ${isHungry()}"
}

class Ant(id: Int) : Animall(id) {
    override var minEnergy = 2
    override fun feed() {
        this.energy++
    }

    override fun play() {
        this.energy--
    }
}

class Lion(id: Int) : Animall(id) {
    override var minEnergy = 120
    override fun feed() {
        this.energy = energy + 70
    }

    override fun play() {
        this.energy = energy - 50
    }

    fun roar() = println("Roaaaaaaaaaaaaaaaaar")
}