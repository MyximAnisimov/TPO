package itmo.tpo.cool_story

class StateContext {
    private var _state: State = WorkingState()

    var state: State
        get() = _state
        set(value) {
            _state = value
        }

    fun work() {
        state.work(this)
    }

    fun chill(name: String) {
        state.chill(this, name)
    }


}