package itmo.tpo.cool_story

import itmo.tpo.cool_story.HumanActivities.Aknowledge
import kotlin.collections.ArrayDeque
import kotlin.random.Random


object Ford : Creature(), HumanActivities {
    override val name = "Форд"
    override var location = "далеко от дома"
    override val knowledgeRate: Double = Random.nextDouble()
    override var aknowledge = Aknowledge.CLEVER

    val stateContext: StateContext = StateContext()

    private val queueWorkClever: ArrayDeque<String> = ArrayDeque(listOf(
        "Форд хорошо проводит время",
        "Форд ни о чём не беспокоится",
        "Форд старается не думать о плохом",
        "Форд считает, что всё не так уж и плохо",
        "Форд считает, что терпение - ключ к успеху"
    ))
    private val queueWorkStupid: ArrayDeque<String> = ArrayDeque(listOf(
        "Форда терзают сомнения по поводу умнственных способностей Артура",
        "Форд считает Артура тупым",
        "\"Артур - невежда, который знает о галактических делах не больше, чем комар из Илфорда о жизни в Пекине\" - подумал Форд",
        "Форд не хочет возиться с Артуром",
        "Форд не считает Артура умным"
    ))
    override fun feel(otherHumanKnowledge: Aknowledge): String {
        return when(stateContext.state) {
            is WorkingState -> when(otherHumanKnowledge) {
                Aknowledge.CLEVER -> {
                    queueWorkClever.addLast(queueWorkClever.first())
                    queueWorkClever.removeFirst()
                }
                Aknowledge.STUPID -> {
                    queueWorkStupid.addLast(queueWorkStupid.first())
                    queueWorkStupid.removeFirst()
                }
            }
            is ChillingState -> "История закончилась"
        }
    }

    override fun comeCloserHouse() {
        location = "почти дома"
    }

    override fun comeHouse() {
        location = "дома"
    }
}