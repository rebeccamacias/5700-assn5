package States

import Contexts.BinaryDetector
import Contexts.Detector
import Contexts.IntegerDetector

class StartState(detector: Detector): State(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {

    }
}