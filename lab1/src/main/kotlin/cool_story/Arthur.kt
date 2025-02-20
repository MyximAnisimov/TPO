package itmo.tpo.cool_story

import itmo.tpo.cool_story.HumanActivities.Aknowledge
import kotlin.random.Random


object Arthur : Creature(), HumanActivities {
    override val name = "Артур"
    override var location = "с Фордом"
    override val knowledgeRate: Double = Random.nextDouble()
    override var aknowledge = Aknowledge.CLEVER



    val stateContext: StateContext = StateContext()

    override fun feel(otherHumanKnowledge: Aknowledge) {
        when(stateContext.state) {
            is WorkingState -> when(otherHumanKnowledge) {
                Aknowledge.CLEVER -> println("Артур понял, что он самый тупой")
                Aknowledge.STUPID -> println("Артур чувствует себя хорошо")
            }
            is ChillingState -> when(aknowledge) {
                Aknowledge.CLEVER -> println("Артур пошел отдыхать")
                Aknowledge.STUPID -> println("Артур пошел узнавать о Пекине")
            }
        }
    }

    override fun comeCloserHouse() {
        location = "почти дома"
    }

    override fun comeHouse() {
        location = "дома"
    }
}