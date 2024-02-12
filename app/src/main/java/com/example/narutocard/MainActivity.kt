package com.example.narutocard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.narutocard.ui.theme.NarutoCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NarutoCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    VixCardBiz()
                }
            }
        }
    }
}


@Composable
fun VixCardBiz() {
    val buttonClickState = remember{
        mutableStateOf(false)
    }
    Surface(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        Card(
            modifier = Modifier.width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {

            Column(modifier = Modifier.width(390.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider()
                CreateInfo()
                Button(onClick = {
                    //Log.d("Clicked","Hurrayyy!! You Just Become Hokage")
                    buttonClickState.value = !buttonClickState.value
                }){
                    Text(text = "Hokage")


                }
                if(buttonClickState.value){
                    Content()
                }
                else{
                    Box{

                    }
                }
            }



        }



    }

}
@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)){
        Surface(modifier = Modifier.padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf(
                mapOf("name" to "Hasirama Senju",
                        "desc" to "First Hokage",
                         "img" to R.drawable.hasirama
                      ),
                mapOf("name" to "Tobirama Senju",
                    "desc" to "Second Hokage",
                    "img" to R.drawable.tobirama
                ),
                mapOf("name" to "Hiruzen Sarutobi",
                    "desc" to "Third Hokage",
                    "img" to R.drawable.miruzen
                ),
                mapOf("name" to "Minato Namikaze",
                    "desc" to "Fourth Hokage",
                    "img" to R.drawable.minato
                ),
                mapOf("name" to "Tsunade Senju",
                    "desc" to "Fifth Hokage",
                    "img" to R.drawable.tsunade
                ),
                mapOf("name" to "Kakashi Hatake",
                    "desc" to "Sixth Hokage",
                    "img" to R.drawable.kakashi
                ),
                mapOf("name" to "Naruto Uzumaki",
                    "desc" to "Seventh Hokage",
                    "img" to R.drawable.naruto_big
                )))
        }
    }

}

@Composable
fun Portfolio(data: List<Map<String, Any>>) {
    LazyColumn{
        items(data){
                item ->
            Card (modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
                shape = RectangleShape
            ){
                Row(modifier = Modifier.padding(8.dp)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)
                    .fillMaxWidth()){
//                    Surface (modifier = Modifier.size(50.dp)){  }
                    CreateImageProfile(modifier = Modifier.size(5.dp), item.get("img") as Int)
                    Column(modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)) {
                        Text(text = item["name"].toString(), fontWeight = FontWeight.Bold)
                        Text(text = item["desc"].toString(), style=MaterialTheme.typography.bodySmall)
                    }



                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Naruto Uzumaki",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary

        )
        Text(
            text = "Hokage Of Hidden Leaf Village!",
            modifier = Modifier.padding(3.dp),
//                     style = MaterialTheme.typography.headlineMedium,
        )
        Text(
            text = "@NarutoUzumaki",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.bodySmall
        )

    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier= Modifier,Image_id: Int = R.drawable.naruto) {
    Surface(
        modifier = Modifier.size(130.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        tonalElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = Image_id),
            contentDescription = "profile picture",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NarutoCardTheme {
        VixCardBiz()
    }
}

