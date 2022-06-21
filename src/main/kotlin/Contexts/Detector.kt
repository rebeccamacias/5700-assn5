package Contexts

import States.StartState
import States.State

abstract class Detector {
    abstract var state: State

    abstract fun detect(input: String): Boolean
}