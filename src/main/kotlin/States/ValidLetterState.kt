package States

import Contexts.BinaryDetector
import Contexts.Detector

class ValidLetterState(detector: Detector): State(detector) {
    override var isAccepting = true

    override fun consumeInput(string: String) {
        isAccepting = detector !is BinaryDetector
        if (string !in "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ)") {
            detector.state = InvalidState(detector)
        }
    }
}