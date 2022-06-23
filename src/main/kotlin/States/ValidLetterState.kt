package States

import Contexts.BinaryDetector
import Contexts.Detector
import Contexts.EmailDetector
import Contexts.PasswordDetector

class ValidLetterState(detector: Detector): State(detector) {
    override var isAccepting = false

    override fun consumeInput(string: String) {
        isAccepting = detector is EmailDetector || detector is PasswordDetector
        if (string !in "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ)" && !isAccepting) {
            detector.state = InvalidState(detector)
        }
    }
}