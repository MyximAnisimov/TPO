package itmo.tpo.cool_story

import itmo.tpo.cool_story.HumanActivities.Aknowledge
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.random.Random


object Arthur : Creature(), HumanActivities {
    override val name = "Артур"
    override var location = "с Фордом"
    override val knowledgeRate: Double = Random.nextDouble()
    override var aknowledge = Aknowledge.CLEVER

private val queueWorkStupid: ArrayDeque<String> = ArrayDeque(listOf(
        "Артур понял, что он самый тупой",
        "Артуру стыдно за его тупость",
        "Артур не знает, как его терпит Форд",
        "Артур наступил в лужу и промок",
        "Артур думал, что он встал не с той ноги"
    ))
    private val queueWorkClever: ArrayDeque<String> = ArrayDeque(listOf(
        "Артур чувствует себя хорошо",
        "Артур веселый и в хорошем настроении",
        "Артур очень любит гулять с Фордом",
        "Артур начал играть с бабочкой",
        "Артур бегает из стороны в сторону"
    ))
    val stateContext: StateContext = StateContext()

    override fun feel(otherHumanKnowledge: Aknowledge) {
        when(stateContext.state) {
            is WorkingState -> when(otherHumanKnowledge) {
                Aknowledge.CLEVER -> {
                    println(queueWorkClever.first())
                    queueWorkClever.addLast(queueWorkClever.first())
                    queueWorkClever.removeFirst()
                }
                Aknowledge.STUPID -> {
                    println(queueWorkStupid.first())
                    queueWorkStupid.addLast(queueWorkStupid.first())
                    queueWorkStupid.removeFirst()
                }
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