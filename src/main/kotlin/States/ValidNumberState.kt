package States

import Contexts.Detector

class ValidNumberState(detector: Detector): State(detector) {
    override var isAccepting = true

    override fun consumeInput(string: String) {
        if (string !in "0123456789") {
            detector.state = InvalidState(detector)
        }
    }
}