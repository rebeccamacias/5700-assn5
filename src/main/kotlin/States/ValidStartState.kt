package States

import Contexts.BinaryDetector
import Contexts.Detector

class ValidStartState(detector: Detector): State(detector) {
    override var isAccepting = false

    override fun consumeInput(string: String) {
        if (string == "0") {
            if (detector !is BinaryDetector) {
                detector.state = ValidNumberState(detector)
            }
        } else if (string !in "0.") {
            detector.state = InvalidState(detector)
        }
    }
}