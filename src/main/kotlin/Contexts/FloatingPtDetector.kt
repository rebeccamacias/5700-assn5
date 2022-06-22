package Contexts

import States.StartState
import States.State

// 1. A floating point value can start with either a (1-9) or a 0, or a period (.)
// 2. If the value starts with a 0 then a period must be the next character
// 3. The period must be followed by at least one digit (0-9)
// 4. A floating point value contains exactly one period
// 5. A floating point number must not contain any chars other than a period or a digit (0-9)

class FloatingPtDetector: Detector() {
    override var state: State = StartState(this)
    private var numOfPeriods: Int = 0
    private var isAccepting = false

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