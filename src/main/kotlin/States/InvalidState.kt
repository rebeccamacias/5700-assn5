package States

import Contexts.Detector

class InvalidState(detector: Detector): State(detector) {
    override var isAccepting = false

    override fun consumeInput(string: String) {
        // no-op
    }
}