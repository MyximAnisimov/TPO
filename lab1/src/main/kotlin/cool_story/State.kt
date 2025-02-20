package itmo.tpo.cool_story

interface State {
    fun getName(): String
    fun work(stateCtx: StateContext)
    fun chill(stateCtx: StateContext)
}