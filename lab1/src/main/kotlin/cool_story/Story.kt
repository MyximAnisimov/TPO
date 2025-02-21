package itmo.tpo.cool_story

class Story(private val roadLength: Int = 1000, private val step: Int = 100) {

    fun runStory() {
        var road = 0
        println("Артур и Форд начали идти к дому\nЦелый путь составляет $roadLength\n")

        road = roadToHome(roadLength / 2, road)

        println("Пройдена половина пути...\nФорд и Артур заметили комара")
        Thread.sleep(500)
        Ford.comeCloserHouse()
        Arthur.comeCloserHouse()
        Ford.compare(Mosquito.knowledgeRate, Ford.knowledgeRate)
        Arthur.compare(Mosquito.knowledgeRate, Arthur.knowledgeRate)
        Ford.printKnowledge(Ford.name)
        Thread.sleep(500)
        Arthur.printKnowledge(Arthur.name)
        Thread.sleep(500)
        println()
        Thread.sleep(1000)

        roadToHome(roadLength, road)

        Ford.stateContext.chill(Ford.name)
        Arthur.stateContext.chill(Arthur.name)
        Ford.comeHouse()
        Arthur.comeHouse()
        println(Arthur.feel(Ford.aknowledge))
        Thread.sleep(500)
        println(Ford.feel(Arthur.aknowledge))
    }

    private fun roadToHome(dest: Int, nowDist: Int): Int {
        var road = nowDist
        while (road < dest) {
            println("Они прошли уже ${road}...")
            Thread.sleep(500)
            println(Ford.feel(Arthur.aknowledge))
            Thread.sleep(500)
            println(Arthur.feel(Ford.aknowledge))
            road += step
            println()
            Thread.sleep(1000)
        }
        return road
    }
}