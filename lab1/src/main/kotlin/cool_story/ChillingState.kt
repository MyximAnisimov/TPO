package itmo.tpo.cool_story

class ChillingState: State {
    private val name: String = "Отдыхает"

    override fun getName(): String {
        return name;
    }

    override fun work(stateCtx: StateContext) {
        println("Начал возиться")
        stateCtx.state = WorkingState()
    }

    override fun chill(stateCtx: StateContext) {
        println("Продолжает отдыхать")
    }
}