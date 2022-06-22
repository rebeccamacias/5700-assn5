package States

import Contexts.Detector

class ValidStartState(detector: Detector): State(detector) {
    override val isAccepting: Boolean
        get() = true

    override fun consumeInput(string: String) {
        if (string !in "0.") {
            detector.state = InvalidState(detector)
        }
    }
}