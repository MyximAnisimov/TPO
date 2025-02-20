package itmo.tpo.cool_story

import itmo.tpo.cool_story.HumanActivities.Aknowledge
import kotlin.random.Random


object Ford : Creature(), HumanActivities {
    override val name = "Форд"
    override var location = "далеко от дома"
    override val knowledgeRate: Double = Random.nextDouble()
    override var aknowledge = Aknowledge.CLEVER

    val stateContext: StateContext = StateContext()

    override fun feel(otherHumanKnowledge: Aknowledge) {
        when(stateContext.state) {
            is WorkingState -> when(otherHumanKnowledge) {
                Aknowledge.CLEVER -> println("Форд хорошо проводит время")
                Aknowledge.STUPID -> println("Форд почувствовал досаду")
            }
            is ChillingState -> println("История закончилась")
        }
    }

    override fun comeCloserHouse() {
        location = "почти дома"
    }

    override fun comeHouse() {
        location = "дома"
    }
}