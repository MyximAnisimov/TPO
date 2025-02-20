package itmo.tpo.cool_story

class Arthur : Creature {

    override var name: String = ""

    override var location: String = ""

    override var knowledge: Int = 0

    constructor(name: String, location: String, knowledge: Int) : super(name, location, knowledge) {
        this.name = name
        this.location = location
        this.knowledge = knowledge
    }
}