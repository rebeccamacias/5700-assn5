package States

import Contexts.Detector

class ValidCharacterState(detector: Detector): State(detector) {
    override val isAccepting: Boolean
        get() = true

    override fun consumeInput(string: String) {
        if (string !in "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ)") {
            detector.state = InvalidState(detector)
        }
    }
}