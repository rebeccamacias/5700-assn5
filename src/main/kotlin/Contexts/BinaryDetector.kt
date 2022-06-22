package Contexts

import States.StartState
import States.State

class BinaryDetector: Detector() {
    override var state: State = StartState(this)
    var isAccepting = false

    override fun detect(input: String): Boolean {
        val characters = input
            .trim()
            .split("")
            .drop(1)
            .dropLast(1)
            .toMutableList()

        for (i in 0 until characters.size) {
            if (characters[i] == "0" && (i == 0 || i == characters.size - 1)) {
                return false
            } else if (characters[i] != "0" && characters[i] != "1") {
                return false
            }
            state.consumeInput(characters[i])
            isAccepting = state.isAccepting
            state = StartState(this)

        }
        return isAccepting
    }
}