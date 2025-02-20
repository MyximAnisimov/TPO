package itmo.tpo.cool_story

sealed interface State {
    fun getName(): String
    fun work(stateCtx: StateContext)
    fun chill(stateCtx: StateContext)
}