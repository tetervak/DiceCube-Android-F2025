package ca.tetervak.dicecube.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.tetervak.dicecube.R
import ca.tetervak.dicecube.model.DiceCube
import ca.tetervak.dicecube.ui.theme.DiceCubeTheme

@Composable
fun AppRootScreen() {
    Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            val viewModel: DiceCubeViewModel = viewModel()
            val diceValue: Int by viewModel.diceState.collectAsState()

            Text(
                text = stringResource(R.string.hello),
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.Start)
            )
            DiceImage(diceValue)
            Text(text = diceValue.toString(), fontSize = 40.sp)
            Button(
                onClick = {
                    viewModel.onRollDice()
                },
                modifier = Modifier.padding(top=24.dp)
            ) {
                Text(text = stringResource(R.string.roll_dice))
            }
        }
    }
}

@Composable
private fun DiceImage(value: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(diceImageResourceId(value)),
        contentDescription = value.toString(),
        modifier = modifier.size(80.dp)
    )
}

private fun diceImageResourceId(value: Int) = when (value) {
    1 -> R.drawable.dice_1
    2 -> R.drawable.dice_2
    3 -> R.drawable.dice_3
    4 -> R.drawable.dice_4
    5 -> R.drawable.dice_5
    else -> R.drawable.dice_6
}

@Preview
@Composable
fun AppRootScreenPreview(){
    DiceCubeTheme {
        AppRootScreen()
    }
}