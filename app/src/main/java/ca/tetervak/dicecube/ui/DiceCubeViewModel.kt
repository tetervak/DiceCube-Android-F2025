package ca.tetervak.dicecube.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ca.tetervak.dicecube.model.DiceCube

class DiceCubeViewModel: ViewModel() {

    private val diceCube: DiceCube = DiceCube()
    var diceValue: Int by mutableIntStateOf( diceCube. value)
    private set

    fun onRollDice(){
        diceCube.roll()
        diceValue = diceCube.value
    }
}