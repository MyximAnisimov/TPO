package itmo.tpo.cool_story

class StateContext {
    private var _state: State = ChillingState()

    var state: State
        get() = _state
        set(value) {
            _state = value
        }

    fun work() {
        state.work(this)
    }

    fun chill() {
        state.chill(this)
    }


}