package itmo.tpo.cool_story

import kotlin.random.Random


class Ford : Creature(), HumanActivities {
    override var name = "Ford"
    override var location = "somewhere"
    override var knowledgeRate: Double = Random.nextDouble()
    override var aknowledge = HumanActivities.Aknowledge.CLEVER
    override fun feel(stateContext: StateContext, location: String) {
        when(stateContext.state) {
            is WorkingState ->
        }
    }
}