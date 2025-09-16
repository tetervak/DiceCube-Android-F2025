package ca.tetervak.dicecube.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ca.tetervak.dicecube.model.DiceCube
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DiceCubeViewModel: ViewModel() {

    private val diceCube: DiceCube = DiceCube()

    private val _diceState: MutableStateFlow<Int> = MutableStateFlow(diceCube.value)
    val diceState: StateFlow<Int> = _diceState

    fun onRollDice(){
        diceCube.roll()
        _diceState.value = diceCube.value
    }
}