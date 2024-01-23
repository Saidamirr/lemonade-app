package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Layout()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Layout(){
    var currentState by remember { mutableStateOf(1) }
    var imageId: Int
    var imgDc: Int
    var text: Int
    when (currentState) {
        1 -> {
            imageId = R.drawable.lemon_tree
            text = R.string.select_a_lemon
            imgDc = R.string.lemon_tree_cont_description
        }
        2 -> {
            imageId = R.drawable.lemon_squeeze
            text = R.string.squeeze_the_lemon
            imgDc = R.string.Lemon_c_d
        }
        3 -> {
            imageId = R.drawable.lemon_drink
            text = R.string.drink_lemonade
            imgDc = R.string.glass_of_lemonade_c_d
        }
        else -> {
            imageId = R.drawable.lemon_restart
            text = R.string.start_again
            imgDc = R.string.empty_glass_c_d
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
          

    ) {
        Text(
            text = "Lemonade",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFF9E44C))
                .padding(0.dp, 20.dp)

        )
        
        Spacer(modifier = Modifier.height(180.dp))
        
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(300.dp)
                .width(250.dp)
                .background(
                    color = Color(0xFFC3ECD2),
                    shape = RoundedCornerShape(40.dp)
                )

            ) {

            var tapsToSqueeze = (5..10).random()
            var tapped = 0


            Image(painter = painterResource(imageId),
                contentDescription = stringResource(imgDc),
                contentScale = ContentScale.Inside,
                modifier = Modifier.combinedClickable (
                    onClick = {

                    if (currentState != 4 && currentState != 2)  {currentState++}
                    else if(currentState != 2) {currentState = 1}
                    },
                    onLongClick = {
                        if (currentState == 2) {
                            currentState++
                        }
                    }
                    )
            )
        }
        Text(text = stringResource(id = text),
            fontSize = 18.sp,
            modifier = Modifier
                .padding(0.dp, 30.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    LemonadeAppTheme {
        Layout()
    }
}