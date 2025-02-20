package itmo.tpo.cool_story

import kotlin.random.Random

class Mosquito : Creature(){
    override var name = "Mosquito"
    override var location = "somewhere"
    override var knowledgeRate: Double = Random.nextDouble()
}