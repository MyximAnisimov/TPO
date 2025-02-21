import itmo.tpo.cool_story.*
import itmo.tpo.cool_story.HumanActivities.Aknowledge
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.random.Random

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CoolStoryTest {

    @BeforeEach
    fun resetPersonFields() {
        Arthur.location = "с Фордом"
        Arthur.aknowledge = Aknowledge.CLEVER

        Ford.location = "далеко от дома"
        Ford.aknowledge = Aknowledge.CLEVER
    }

    @Test
    fun `test Arthur's fields`() {
        assertEquals("Артур", Arthur.name)
        assertEquals("с Фордом", Arthur.location)
        assertTrue(Arthur.knowledgeRate in 0.0..1.0)
        assertEquals(HumanActivities.Aknowledge.CLEVER, Arthur.aknowledge)
    }

    @Test
    fun `test Ford's fields`() {
        assertEquals("Форд", Ford.name)
        assertEquals("далеко от дома", Ford.location)
        assertTrue(Ford.knowledgeRate in 0.0..1.0)
        assertEquals(HumanActivities.Aknowledge.CLEVER, Ford.aknowledge)
    }

    @Test
    fun `test Mosquito's fields`() {
        assertEquals(Mosquito.name, "Комар")
        assertEquals(Mosquito.location, "где-то")
        assertTrue(Mosquito.knowledgeRate in 0.0..1.0)
    }

    @Test
    fun `test comparing knowledge`() {
        Ford.compare(Mosquito.knowledgeRate, Ford.knowledgeRate)
        Arthur.compare(Mosquito.knowledgeRate, Arthur.knowledgeRate)

        if (Mosquito.knowledgeRate >= Arthur.knowledgeRate) {
            assertEquals(Arthur.aknowledge, HumanActivities.Aknowledge.STUPID)
        } else {
            assertEquals(Arthur.aknowledge, HumanActivities.Aknowledge.CLEVER)
        }

        if (Mosquito.knowledgeRate >= Ford.knowledgeRate) {
            assertEquals(Ford.aknowledge, HumanActivities.Aknowledge.STUPID)
        } else {
            assertEquals(Ford.aknowledge, HumanActivities.Aknowledge.CLEVER)
        }
    }

    @Test
    fun `test Arthur's feelings when Ford clever`() {
        Ford.aknowledge = Aknowledge.CLEVER

        val etalon = """
            Артур чувствует себя хорошо
            Артур веселый и в хорошем настроении
            Артур очень любит гулять с Фордом
            Артур начал играть с бабочкой
            Артур бегает из стороны в сторону
        """.trimIndent()

        testFeelingsWithEtalon(etalon, Arthur, Ford)
    }

    @Test
    fun `test Arthur's feelings when Ford stupid`() {
        Ford.aknowledge = Aknowledge.STUPID

        val etalon = """
            Артуру перестало нравится прогулка с Фордом
            Артур думает, что Форд мог бы быть и поумнее
            Артур написал другим друзьям, чтобы погулять с ними
            Артуру обстановка совсем не по себе
            Артур не понимает, как комар может быть умнее Форда
        """.trimIndent()

        testFeelingsWithEtalon(etalon, Arthur, Ford)
    }

    @Test
    fun `test Ford's feelings when Arthur clever`() {
        Arthur.aknowledge = Aknowledge.CLEVER

        val etalon = """
            Форд хорошо проводит время
            Форд ни о чём не беспокоится
            Форд старается не думать о плохом
            Форд считает, что всё не так уж и плохо
            Форд считает, что терпение - ключ к успеху
        """.trimIndent()

        testFeelingsWithEtalon(etalon, Ford, Arthur)
    }

    @Test
    fun `test Ford's feelings when Arthur stupid`() {
        Arthur.aknowledge = Aknowledge.STUPID

        val etalon = """
            Форда терзают сомнения по поводу умнственных способностей Артура
            Форд считает Артура тупым
            "Артур - невежда, который знает о галактических делах не больше, чем комар из Илфорда о жизни в Пекине" - подумал Форд
            Форд не хочет возиться с Артуром
            Форд не считает Артура умным
        """.trimIndent()

        testFeelingsWithEtalon(etalon, Ford, Arthur)
    }

    private fun testFeelingsWithEtalon(etalon: String, person: HumanActivities, otherPerson: HumanActivities) {
        StringBuilder().also { feelings ->
            feelings.append("${person.feel(otherPerson.aknowledge)}\n")
            feelings.append("${person.feel(otherPerson.aknowledge)}\n")
            feelings.append("${person.feel(otherPerson.aknowledge)}\n")
            feelings.append("${person.feel(otherPerson.aknowledge)}\n")
            feelings.append(person.feel(otherPerson.aknowledge))
        }.toString().let { assertEquals(etalon, it)}
    }
}