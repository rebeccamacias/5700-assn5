package Contexts

import States.StartState
import States.State


class FloatingPtDetector: Detector() {
    override var state: State = StartState(this)
    private var numOfPeriods: Int = 0
    override var isAccepting = false

    override fun detect(input: String): Boolean {
        val characters = input
            .trim()
            .split("")
            .drop(1)
            .dropLast(1)
            .toMutableList()

        for (i in 0 until characters.size) {
            if (characters[i] == ".") {
                numOfPeriods++
                if (numOfPeriods > 1) {
                    return false
                }
                if (i + 1 < characters.size && characters[i + 1] !in "0123456789") {
                    return false
                }
                if (i + 1 == characters.size) {
                    return false
                }
            }
            if (characters[i] == "0" && i == 0) {
                if (i + 1 < characters.size && characters[i + 1] != ".") {
                    return false
                }
                if (i + 1 == characters.size) {
                    return false
                }
            }
            state.consumeInput(characters[i])
            isAccepting = state.isAccepting
            state = StartState(this)
        }
        if (numOfPeriods < 1) {
            return false
        }
        return isAccepting
    }
}