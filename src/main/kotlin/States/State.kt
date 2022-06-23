package States

import Contexts.Detector

abstract class State(val detector: Detector) {
    abstract var isAccepting: Boolean

    abstract fun consumeInput(string: String)
}