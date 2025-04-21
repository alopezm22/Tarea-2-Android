package com.example.myapplication.ui

import com.example.myapplication.R

object DatoPelicula {
    val categorias = mutableListOf(
        categorias(
            id = 1,
            genero = "Acción",
            icon = R.drawable.accion,
            peliculas = mutableListOf(
                peliculas(idPelicula = 1, nombre = "John Wick", duracion = 120, descripcion = "John Wick es un ex sicario, conocido como \"Babayaga\", que regresa a la vida criminal para vengarse de un grupo de gánsteres que le roban su coche y asesinan a su perro, un regalo de su difunta esposa"),
                peliculas(idPelicula = 2, nombre = "Caballito", duracion = 130, descripcion = "Su nombre original es la Estatua ecuestre de Carlos IV. Su andar en la historia mexicana ha estado envuelto en la polémica hasta nuestros días. Como ya se mencionó, su construcción tenía por objetivo honrar al recién nombrado rey de España.")
            )
        ),
        categorias(
            id = 2,
            genero = "Ficción",
            icon = R.drawable.ficcion,
            peliculas = mutableListOf(
                peliculas(idPelicula = 3, nombre = "Interestelar", duracion = 110, descripcion = "Gracias a un descubrimiento, un grupo de científicos y exploradores, encabezados por Cooper, se embarcan en un viaje espacial para encontrar un lugar con las condiciones necesarias para reemplazar a la Tierra y comenzar una nueva vida allí."),
                peliculas(idPelicula = 4, nombre = "Malevolo Cucarachón", duracion = 140, descripcion = "Los hombres de negro son el secreto mejor guardado del universo: su misión es monitorear a los extraterrestres desde la Tierra.")
            )
        ),
        categorias(
            id= 3,
            genero = "Comedia",
            icon= R.drawable.comedia,
            peliculas = mutableListOf(
                peliculas(idPelicula = 5, nombre ="Scary movie", duracion = 120, descripcion = "Una parodia de los filmes de asesinatos donde un homicida vengativo acecha a un grupo de adolescentes."),
                peliculas(idPelicula = 6, nombre ="¿Que paso ayer?", duracion = 140, descripcion = "Dos días antes de su boda, Doug y tres amigos viajan a Las Vegas para una fiesta inolvidable y salvaje. De hecho, cuando los tres acompañantes despiertan la mañana siguiente, no recuerdan nada ni encuentran a Doug. Con poco tiempo por delante, los tres amigos intentan recordar sus pasos y encontrar a Doug para que regrese a Los Ángeles para su boda.")
            )
        ),
        categorias(
            id = 4,
            genero = "Terror",
            icon = R.drawable.terror,
            peliculas = mutableListOf(
                peliculas(idPelicula = 7, nombre ="El conjuro", duracion = 140, descripcion = "A principios de los años 70, Ed y Lorrain Warren, reputados investigadores de fenómenos paranormales, se enfrentan a una entidad demoníaca al intentar ayudar a una familia que está siendo aterrorizada por una presencia oscura en su aislada granja."),
                peliculas(idPelicula = 8, nombre ="Destino Final", duracion = 150, descripcion = "wena")
            )
        )
    )
}
