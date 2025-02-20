package itmo.tpo.cool_story

import kotlin.random.Random

class Mosquito(name: String, location: String, knowledge: Int) :
    Creature(name, location){
    override var knowledge: Double = Random.nextDouble()
}