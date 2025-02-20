package itmo.tpo.cool_story

import kotlin.random.Random

object Mosquito : Creature(){
    override val name = "Комар"
    override var location = "где-то"
    override val knowledgeRate: Double = Random.nextDouble()
}