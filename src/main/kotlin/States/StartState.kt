package States

import Contexts.BinaryDetector
import Contexts.Detector
import Contexts.IntegerDetector

class StartState(detector: Detector): State(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        when (string) {
            in "0123456789" -> {
                detector.state = ValidNumberState(detector)
            }
            in "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" -> {
                detector.state = ValidCharacterState(detector)
            }
            in "~`!@#$%^&*()_+-={}|[]\\:\";'<>?,./" -> {
                detector.state = ValidSymbolState(detector)
            }
            else -> {
                detector.state = InvalidState(detector)
            }
        }
    }
}