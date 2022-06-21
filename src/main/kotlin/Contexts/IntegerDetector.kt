package Contexts

import States.StartState
import States.State

class IntegerDetector: Detector() {
    override var state: State = StartState(this)

    override fun detect(input: String): Boolean {
        val characters = input
            .trim()
            .split("")
            .drop(1)
            .dropLast(1)
            .toMutableList()

        for (i in 0 until characters.size) {
            if (characters[i] == "0" && i == 0) {
                return false
            }
            state.consumeInput(characters[i])
        }

        val isAccepting = state.isAccepting
        state = StartState(this)
        return isAccepting
    }
}