package Contexts

import States.StartState
import States.State

class PasswordDetector: Detector() {
    override var state: State = StartState(this)
    override var isAccepting: Boolean = false
    private var numCaps = 0
    private var numSpecial = 0

    override fun detect(input: String): Boolean {
        val characters = input
            .trim()
            .split("")
            .drop(1)
            .dropLast(1)
            .toMutableList()

        if (characters.size < 8) {
            return false
        }

        for (i in 0 until characters.size) {
            if (characters[i].isUpperCase()) {
                numCaps++
            }
            if (characters[i].isSpecial()) {
                numSpecial++
            }
            if (characters[i].isSpecial() && i == characters.size - 1) {
                return false
            }

            state.consumeInput(characters[i])
        }

        if (numCaps < 1 || numSpecial < 1) {
            return false
        }

        isAccepting = state.isAccepting
        state = StartState(this)
        return isAccepting
    }
    fun String.isUpperCase(): Boolean {
        return this in "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    }

    fun String.isSpecial(): Boolean {
        return this in "~`!@#$%^&*()_+-={}|[]\\:\";'<>?,./'"
    }
}