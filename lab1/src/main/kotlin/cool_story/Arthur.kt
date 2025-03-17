package itmo.tpo.cool_story

import itmo.tpo.cool_story.HumanActivities.Aknowledge
import kotlin.collections.ArrayDeque
import kotlin.random.Random


object Arthur : Creature(), HumanActivities {
    override val name = "Артур"
    override var location = "с Фордом"
    override val knowledgeRate: Double = Random.nextDouble()
    override var aknowledge = Aknowledge.CLEVER

    private val queueWorkStupid: ArrayDeque<String> = ArrayDeque(listOf(
        "Артуру перестало нравится прогулка с Фордом",
        "Артур думает, что Форд мог бы быть и поумнее",
        "Артур написал другим друзьям, чтобы погулять с ними",
        "Артуру обстановка совсем не по себе",
        "Артур не понимает, как комар может быть умнее Форда"
    ))
    private val queueWorkClever: ArrayDeque<String> = ArrayDeque(listOf(
        "Артур чувствует себя хорошо",
        "Артур веселый и в хорошем настроении",
        "Артур очень любит гулять с Фордом",
        "Артур начал играть с бабочкой",
        "Артур бегает из стороны в сторону"
    ))
    val stateContext: StateContext = StateContext()

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
            is ChillingState -> when(aknowledge) {
                Aknowledge.CLEVER -> "Артур валяется на гамаке"
                Aknowledge.STUPID -> "Артур пошел узнавать о Пекине"
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