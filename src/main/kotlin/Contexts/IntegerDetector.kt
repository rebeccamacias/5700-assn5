package Contexts

import States.StartState
import States.State

class IntegerDetector: Detector() {
    override var state: State = StartState(this)
    override var isAccepting = false

    override fun detect(input: String): Boolean {
        val characters = input
            .trim()
            .split("")
            .drop(1)
            .dropLast(1)
            .toMutableList()

        if (characters.isEmpty() || characters.contains(".") || characters.first() == " ") {
            return false
        }

        for (i in 0 until characters.size) {
            if (characters[i] == "0" && i == 0) {
                return false
            }
            state.consumeInput(characters[i])
        }
        isAccepting = state.isAccepting
        state = StartState(this)
        return isAccepting
    }
}