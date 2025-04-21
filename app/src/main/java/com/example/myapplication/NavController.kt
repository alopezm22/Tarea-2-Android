package com.example.myapplication
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.myapplication.ui.FourScreen
import com.example.myapplication.ui.HomeScreen
import com.example.myapplication.ui.SecondScreen
import com.example.myapplication.ui.TerceraScreen
import kotlinx.serialization.Serializable


@Serializable
object Home

@Serializable
data class SecondPage(val id : Int)

@Serializable
data class TerceraPage(val id: Int)

@Serializable
data class FourPage(val id: Int)

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home){
        composable<Home>{
            HomeScreen(navController = navController)
        }
        composable<SecondPage> { backStackEntry ->
            val args = backStackEntry.toRoute<SecondPage>()
            SecondScreen(navController,args.id)

        }
        composable<TerceraPage> { bacStackEntry ->
            val args = bacStackEntry.toRoute<TerceraPage>()
            TerceraScreen(navController)
        }
        composable<FourPage> { bacStackEntry ->
            val args = bacStackEntry.toRoute<FourPage>()
            FourScreen(navController, args.id)
        }


    }
}


