package com.example.myapplication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import androidx.compose.foundation.clickable
import com.example.myapplication.FourPage


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SecondScreen(navController: NavController, id: Int) {
    val categoria = DatoPelicula.categorias


    Scaffold(
        containerColor = Color(0xFF141414),
        topBar = {
            TopAppBar(
                title = {
                    Button(
                        onClick = {
                            navController.popBackStack()
                        },
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 0.dp),
                        colors = ButtonColors(
                            contentColor = Color(0xFFFFFFFF),
                            containerColor = Color(0xFFe50914),
                            disabledContentColor = Color(0xFFFFFFFF),
                            disabledContainerColor = Color.Transparent,
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                        )

                        Text(stringResource(R.string.Button2))
                    }
                },
                colors = TopAppBarColors(
                    containerColor = Color(0xFF141414),
                    scrolledContainerColor = Color(0xFF141414),
                    navigationIconContentColor = Color(0xFFFFFFFF),
                    titleContentColor = Color(0xFFFFFFFF),
                    actionIconContentColor = Color(0xFFFFFFFF)
                )
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            categoria.first { it.id == id }.peliculas.forEach { pelicula ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF333333),
                        contentColor = Color(0xFFFFFFFF)
                    ),
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 20.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(FourPage(pelicula.idPelicula))

                        }
                ) {
                Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = pelicula.nombre,
                            color = Color(0xFFFFFFFF),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = stringResource(R.string.Durac, pelicula.duracion) ,
                            color = Color(0xFFFFFFFF),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
