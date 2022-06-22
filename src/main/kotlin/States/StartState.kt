package States

import Contexts.Detector

class StartState(detector: Detector): State(detector) {
    override var isAccepting: Boolean = false

    override fun consumeInput(string: String) {
        when (string) {
            in "123456789" -> {
                detector.state = ValidNumberState(detector)
            } in "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" -> {
                detector.state = ValidLetterState(detector)
            } in "~`!@#$%^&*()_+-={}|[]\\:\";'<>?,/" -> {
                detector.state = ValidCharacterState(detector)
            } in "0." -> {
                detector.state = ValidStartState(detector)
            } else -> {
                detector.state = InvalidState(detector)
            }
        }
    }
}