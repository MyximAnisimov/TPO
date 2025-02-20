package itmo.tpo.cool_story

class Story(private val roadLength: Int = 1000, private val step: Int = 100) {

    fun runStory() {
        var road = 0
        while (road < roadLength / 2) {
            Ford.feel(Arthur.aknowledge)
            Arthur.feel(Ford.aknowledge)
            road += step
        }

        Ford.comeCloserHouse()
        Arthur.comeCloserHouse()
        Ford.compare(Mosquito.knowledgeRate, Arthur.knowledgeRate)
        Arthur.compare(Mosquito.knowledgeRate, Ford.knowledgeRate)

        while (road < roadLength) {
            Ford.feel(Arthur.aknowledge)
            Arthur.feel(Ford.aknowledge)
            road += step
        }

        Ford.stateContext.chill()
        Arthur.stateContext.chill()
        Ford.comeHouse()
        Arthur.comeHouse()
        Arthur.feel(Ford.aknowledge)
        Ford.feel(Arthur.aknowledge)
    }
}