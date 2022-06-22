package States

import Contexts.Detector
import Contexts.EmailDetector
import Contexts.PasswordDetector

class ValidCharacterState(detector: Detector): State(detector) {
    override var isAccepting = false

    override fun consumeInput(string: String) {
        isAccepting = detector is EmailDetector
        if (string !in "~`!@#$%^&*()_+-=[]{}|;':\",/<>?") {
            detector.state = InvalidState(detector)
        }
    }
}