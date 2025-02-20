package itmo.tpo.cool_story

abstract class Creature {
    abstract var name: String
    abstract var location: String
    abstract var knowledge: Int

    constructor(name: String, location: String, knowledge: Int) {
        this.name = name;
        this.location = location;
        this.knowledge = knowledge;
    }

}