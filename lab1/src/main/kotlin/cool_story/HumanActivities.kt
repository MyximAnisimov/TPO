package itmo.tpo.cool_story

interface HumanActivities {
    var aknowledge: Aknowledge

    fun feel(otherHumanKnowledge: Aknowledge): String
    fun compare(mosquitoK : Double, humanK : Double) {
        aknowledge = if(humanK < mosquitoK)  Aknowledge.STUPID
        else Aknowledge.CLEVER
    }
    fun comeCloserHouse()
    fun comeHouse()
    fun printKnowledge(name: String) {
        if (aknowledge == Aknowledge.CLEVER) {
            println("$name остался умным")
        } else {
            println("$name стал глупым")
        }
    }

    enum class Aknowledge {
        CLEVER,
        STUPID
    }
}