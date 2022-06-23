package Contexts

import States.StartState
import States.State

abstract class Detector {
    abstract var state: State
    abstract var isAccepting: Boolean

    abstract fun detect(input: String): Boolean
}