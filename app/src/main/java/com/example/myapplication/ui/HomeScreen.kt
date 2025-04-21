package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.SecondPage
import com.example.myapplication.TerceraPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var selected by remember { mutableIntStateOf(0) }
    val categoria = DatoPelicula.categorias

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF141414),
        topBar = {
            TopAppBar(
                title = {

                },
                navigationIcon = {
                },
                actions = {
                    Button(
                        onClick = {
                            navController.navigate(TerceraPage(id = 123))
                        },
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color(0xFFE50914),
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = "Form"
                        )
                        Text(stringResource(R.string.Button1))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF141414),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,
                    scrolledContainerColor = Color(0xFF141414)
                )
            )


        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(modifier = Modifier.fillMaxWidth(0.9f)) {

            }
            listarorganizacion(
                categoria = categoria,
                selected = selected,
                changeSelected = { selected = it },
                onCardClick = { id ->
                    navController.navigate(SecondPage(selected))
                }
            )

        }

    }
}

@Composable
fun listarorganizacion(
    categoria: List<categorias>,
    selected: Int,
    changeSelected: (Int) -> Unit,
    onCardClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(categoria) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (selected == it.id) Color(0xFFE50914) else Color(0xFF1F1F1F),
                    contentColor = Color.White,
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        changeSelected(it.id)
                        onCardClick(it.id)
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 10.dp, top = 10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Check Circle",
                        tint = if (selected == it.id) Color.White else Color.Transparent
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 20.dp, end = 20.dp, bottom = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {

                    Image(
                        painter = painterResource(it.icon),
                        contentDescription = it.genero
                    )
                    Text(
                        text = it.genero,
                        color = Color.White,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
            }
        }
    }
}


class peliculas(val idPelicula: Int, val nombre: String, val duracion: Int, val descripcion: String)

// Clase de categoría
class categorias(
    val id: Int,
    val genero: String,
    val icon: Int,
    val peliculas: MutableList<peliculas>
)



