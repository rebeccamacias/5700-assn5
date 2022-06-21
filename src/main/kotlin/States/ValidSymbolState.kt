package States

import Contexts.Detector

class ValidSymbolState(detector: Detector): State(detector) {
    override val isAccepting: Boolean
        get() = true

    override fun consumeInput(string: String) {
        if (string !in "~!@#$%^&*()_+-=[]{}|;':\",./<>?") {
            detector.state = InvalidState(detector)
        }
    }
}