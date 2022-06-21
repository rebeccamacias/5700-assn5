package Contexts

import States.StartState
import States.State

class EmailDetector: Detector() {
    override var state: State = StartState(this)

    override fun detect(input: String): Boolean{
        val characters = input
            .trim()
            .split("")
            .drop(1)
            .dropLast(1)
            .toMutableList()

        for (character in characters) {
            state.consumeInput(character)
        }

        val isAccepting = state.isAccepting
        state = StartState(this)
        return isAccepting
    }
}