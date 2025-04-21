package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TerceraScreen(navController: NavController) {
    val categorias = DatoPelicula.categorias
    var movieName by remember { mutableStateOf("") }
    var movieDuration by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(0) }
    var expanded by remember { mutableStateOf(false) }
    var movieDescrip by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    fun validateInputs(): Boolean {
        return movieName.isNotBlank() && movieDuration.isNotBlank() && movieDescrip.isNotBlank()
    }

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
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color(0xFFe50914)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                        )
                        Text(stringResource(R.string.Button2))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF141414),
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = categorias[selectedCategory].genero,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(stringResource(R.string.SelectGen))},
                    trailingIcon = {
                        Icon(Icons.Filled.KeyboardArrowDown, contentDescription = null)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF333333),
                        unfocusedContainerColor = Color(0xFF333333),
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedIndicatorColor = Color.Red,
                        unfocusedIndicatorColor = Color.Gray
                    )
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    categorias.forEachIndexed { index, categoria ->
                        DropdownMenuItem(
                            text = { Text(categoria.genero, color = Color.Black) },
                            onClick = {
                                selectedCategory = index
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = movieName,
                onValueChange = { movieName = it },
                label = {Text(stringResource(R.string.NombrePeli)) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF333333),
                    unfocusedContainerColor = Color(0xFF333333),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = movieDuration,
                onValueChange = { movieDuration = it },
                label = {Text(stringResource(R.string.Duracion)) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF333333),
                    unfocusedContainerColor = Color(0xFF333333),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = movieDescrip,
                onValueChange = {  movieDescrip= it },
                label = {Text(stringResource(R.string.Descripcion)) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF333333),
                    unfocusedContainerColor = Color(0xFF333333),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            Button(
                onClick = {
                    if (validateInputs()) {
                        val categoriaSeleccionada = DatoPelicula.categorias[selectedCategory]
                        val nuevoId = categoriaSeleccionada.peliculas.maxOfOrNull { it.idPelicula }?.plus(1) ?: 1
                        val duracionInt = movieDuration.toIntOrNull() ?: 0
                        categoriaSeleccionada.peliculas.add(
                            peliculas(
                                idPelicula = nuevoId,
                                nombre = movieName,
                                duracion = duracionInt,
                                descripcion = movieDescrip
                            )
                        )
                        movieName = ""
                        movieDuration = ""
                        movieDescrip = ""
                        errorMessage = ""
                    } else {
                        //errorMessage = stringResource(id = R.string.RellenarTodosCampos)
                        errorMessage = "Por favor, rellene todos los campos"
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE50914),
                    contentColor = Color.White
                )
            ) {
                Text(stringResource(R.string.AgregarPeli))
            }
        }
    }
}
