package itmo.tpo.cool_story

import kotlin.random.Random


class Arthur : Creature(), HumanActivities {
    override var name = "Arthur"
    override var location = "somewhere"
    override var knowledgeRate: Double = Random.nextDouble()
    override var aknowledge = HumanActivities.Aknowledge.CLEVER

    override fun feel(stateContext: StateContext, location: String) {
       println("Arthur feels good")
    }

    override fun compare(mosquitoK: Double, humanK: Double){
        aknowledge = if(humanK < mosquitoK)  HumanActivities.Aknowledge.STUPID
        else HumanActivities.Aknowledge.CLEVER
    }
    }