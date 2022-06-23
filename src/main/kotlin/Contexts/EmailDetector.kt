package Contexts

import States.StartState
import States.State

class EmailDetector: Detector() {
    override var state: State = StartState(this)
    override var isAccepting: Boolean = true

    override fun detect(input: String): Boolean{
        val parts = input
            .trim()
            .split("@")
            .toMutableList()
        if (parts.size < 2 || parts.size > 2) {
            return false
        }

        val afterAt = parts[1]
            .split(".")
            .toMutableList()
        if (afterAt.size < 2 || afterAt.size > 2) {
            return false
        }

        val characters = input
            .trim()
            .split("")
            .drop(1)
            .dropLast(1)
            .toMutableList()
        if (characters.contains(" ")) {
            return false
        }
        for (character in characters) {
            state.consumeInput(character)
        }

        isAccepting = state.isAccepting
        state = StartState(this)
        return isAccepting
    }
}