package itmo.tpo.cool_story

interface HumanActivities {
    var aknowledge: Aknowledge
    fun feel(stateContext : StateContext, location: String)
    fun compare(mosquitoK : Double, humanK : Double)
    enum class Aknowledge {
        CLEVER,
        STUPID
    }
}