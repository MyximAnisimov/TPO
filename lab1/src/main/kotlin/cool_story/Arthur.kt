package itmo.tpo.cool_story

import kotlin.random.Random


class Arthur(name: String, location: String) :
    Creature(name, location){
        override var knowledge: Double = Random.nextDouble()

    }