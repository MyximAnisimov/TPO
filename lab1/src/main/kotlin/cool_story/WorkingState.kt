package itmo.tpo.cool_story

class WorkingState: State {
    private val name: String = "Возится"

    override fun getName(): String = name

    override fun work(stateCtx: StateContext) {
        println("Продолжает возиться")
    }

    override fun chill(stateCtx: StateContext, name: String) {
        println("$name начал отдыхать")
        stateCtx.state = ChillingState()
    }
}