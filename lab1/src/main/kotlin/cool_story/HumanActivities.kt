package itmo.tpo.cool_story

interface HumanActivities {
    var aknowledge: Aknowledge

    fun feel(otherHumanKnowledge: Aknowledge)
    fun compare(mosquitoK : Double, humanK : Double) {
        aknowledge = if(humanK < mosquitoK)  HumanActivities.Aknowledge.STUPID
        else HumanActivities.Aknowledge.CLEVER
    }
    fun comeCloserHouse();
    fun comeHouse();

    enum class Aknowledge {
        CLEVER,
        STUPID
    }
}