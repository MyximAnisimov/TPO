package itmo.tpo.cool_story

import kotlin.random.Random

class WorkingState: State {
    private val name: String = "Ввозится"

    override fun getName(): String = name;

    override fun work(stateCtx: StateContext) {
        println("Продолжает возиться")
    }

    override fun chill(stateCtx: StateContext) {
        println("Начал отдыхать")
        stateCtx.state = ChillingState()
    }
}