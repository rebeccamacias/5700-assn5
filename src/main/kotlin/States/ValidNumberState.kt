package States

import Contexts.Detector

class ValidNumberState(detector: Detector): State(detector) {
    override val isAccepting: Boolean
        get() = true

    override fun consumeInput(string: String) {
        if (string !in "123456789") {
            detector.state = InvalidState(detector)
        }
    }
}