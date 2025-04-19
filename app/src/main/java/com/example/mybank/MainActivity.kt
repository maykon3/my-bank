package com.example.mybank

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.ui.theme.MyBankTheme
import com.example.mybank.ui.theme.Purple40
import com.example.mybank.ui.theme.PurpleGrey80
import com.example.mybank.ui.theme.corCinza
import com.example.mybank.ui.theme.corRoxa
import com.example.mybank.ui.theme.spaceFont


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBankTheme {
                Inicio()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(275.dp)
                .paint(
                    painterResource(id = R.drawable.bg_main_mobile),
                    contentScale = ContentScale.Crop
                )

        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 70.dp)
                    .size(160.dp)
                    .paint(
                        painterResource(id = R.drawable.bg_card_back),
                        contentScale = ContentScale.Crop
                    )

            ) {
                Text(
                    "000",
                    fontSize = 15.sp,
                    color = Color.White,
                    fontFamily = spaceFont,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 20.dp)
                    .offset(y = 53.dp)


            ){
                CardFront(name = "Jane Appleseed", cardNumber = "9591 6489 6389 1011", expDate = "00/00")
            }

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp)
                .padding(top = 50.dp)
        ) {
            Text(
                "CARDHOULDER NAME",
                fontSize = 15.sp,
                fontFamily = spaceFont,
                fontWeight = FontWeight.Medium,
            )
            var cartao by remember { mutableStateOf("") }
            var campoVazio = false

            var vazio = cartao
            if (vazio == ""){
                campoVazio = true
            }

           OutlinedTextField(
               textStyle = TextStyle(color = corCinza),
                value = cartao.uppercase(),
               isError = (campoVazio),
                onValueChange = {
                    newText -> cartao = newText
                },
               maxLines = 1,
               placeholder = {
                   Text(
                       "e.g. Jane Appleseed",
                       fontSize = 16.sp,
                       fontWeight = FontWeight.Medium,
                       color = corCinza,
                       fontFamily = spaceFont
                   )
               },
               shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
               ,
               colors = TextFieldDefaults.outlinedTextFieldColors(
                   unfocusedBorderColor = corCinza, // Ex: cinza claro quando não focado
                   focusedTextColor = corCinza,
               )
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))

            Text(
                "CARD NUMBER",
                fontSize = 15.sp,
                fontFamily = spaceFont,
                fontWeight = FontWeight.Medium,
            )

            OutlinedTextField(
                textStyle = TextStyle(color = corCinza),
                value = cartao.uppercase(),
                isError = (campoVazio),
                onValueChange = {
                        newText -> cartao = newText
                },
                maxLines = 1,
                placeholder = {
                    Text(
                        "e.g. 9591 6489 6389 1011",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = corCinza,
                        fontFamily = spaceFont
                    )
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
                ,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = corCinza, // Ex: cinza claro quando não focado
                    focusedTextColor = corCinza,
                )
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically,
            ){
                Column {
                    Text(
                        "EXP. DATE (MM/YY)",
                        fontSize = 15.sp,
                        fontFamily = spaceFont,
                        fontWeight = FontWeight.Medium,
                    )

                    Row {
                        OutlinedTextField(
                            textStyle = TextStyle(color = corCinza),
                            value = cartao.uppercase(),
                            isError = (campoVazio),
                            onValueChange = {
                                    newText -> cartao = newText
                            },
                            maxLines = 1,
                            placeholder = {
                                Text(
                                    "MM",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = corCinza,
                                    fontFamily = spaceFont
                                )
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .width(80.dp)
                                .padding(top = 5.dp)
                            ,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = corCinza, // Ex: cinza claro quando não focado
                                focusedTextColor = corCinza,
                            )
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        OutlinedTextField(
                            textStyle = TextStyle(color = corCinza),
                            value = cartao.uppercase(),
                            isError = (campoVazio),
                            onValueChange = {
                                    newText -> cartao = newText
                            },
                            maxLines = 1,
                            placeholder = {
                                Text(
                                    "YY",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = corCinza,
                                    fontFamily = spaceFont
                                )
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .width(80.dp)
                                .padding(top = 5.dp)
                            ,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = corCinza, // Ex: cinza claro quando não focado
                                focusedTextColor = corCinza,
                            )
                        )

                    }
                }

                Spacer(modifier = Modifier.padding(5.dp))
                Column {
                    Text(
                        "CVC",
                        fontSize = 15.sp,
                        fontFamily = spaceFont,
                        fontWeight = FontWeight.Medium,
                    )
                    OutlinedTextField(
                        textStyle = TextStyle(color = corCinza),
                        value = cartao.uppercase(),
                        isError = (campoVazio),
                        onValueChange = {
                                newText -> cartao = newText
                        },
                        maxLines = 1,
                        placeholder = {
                            Text(
                                "e.g. 123",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = corCinza,
                                fontFamily = spaceFont
                            )
                        },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .width(150.dp)
                            .padding(top = 5.dp)
                        ,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = corCinza, // Ex: cinza claro quando não focado
                            focusedTextColor = corCinza,
                        )
                    )

                }




            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(corRoxa)
            ) {
                Text(
                    "Confirm",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = corCinza,
                    fontFamily = spaceFont
                )

            }


        }

    }
}

@Composable
fun CardFront(cardNumber : String, name : String,  expDate : String) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(180.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .paint(
                    painterResource(id = R.drawable.bg_card_front),
                    contentScale = ContentScale.Crop
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                Modifier.widthIn(100.dp , 300.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)

                ) {
                    Card(
                        modifier = Modifier
                            .size(35.dp)
                            .clip(shape = RoundedCornerShape(50.dp)),
                        colors = CardDefaults.cardColors(Color.White)
                    ) {}

                    Spacer(modifier = Modifier.width(12.dp))

                    Card(
                        modifier = Modifier
                            .size(15.dp)
                            .clip(shape = RoundedCornerShape(50.dp)),
                        colors = CardDefaults.cardColors(Color.Transparent),
                        border = BorderStroke(1.3.dp, Color.White)

                    ) {}

                }

                Spacer(modifier = Modifier.padding(top = 25.dp))

                Text(
                    cardNumber,
                    fontSize = 25.sp,
                    fontFamily = spaceFont,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.padding(top = 5.dp))

                Row(
                    modifier = Modifier.width(260.dp).padding(start = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,

                ){
                    Text(
                        name.uppercase(),
                        fontSize = 10.sp,
                       fontFamily = spaceFont,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                    Text(
                        expDate,
                        fontSize = 12.sp,
                       fontFamily = spaceFont,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )

                }

            }
        }


}

@Preview
@Composable
fun Preview() {
    MyBankTheme {
        CardFront(name = "Jane Appleseed", cardNumber = "9591 6489 6389 1011", expDate = "00/00")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyBankTheme {
        Inicio()
    }
}