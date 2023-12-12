package com.listvictortercero.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.listvictortercero.screen.IkeaWiki
import com.listvictortercero.screen.MainScreen
import com.listvictortercero.viewmodel.IkeaViewModel


@Composable
fun Navigation(ikeaViewModel: IkeaViewModel){
    val navController = rememberNavController()
    NavHost(
        navController=navController,
        startDestination = Routes.MainScreen.route
    ){
        composable(Routes.MainScreen.route){
            MainScreen(navController = navController, ikeaViewModel = ikeaViewModel )
        }
        composable(Routes.IkeaWiki.route){
            IkeaWiki(navController = navController, ikeaViewModel =ikeaViewModel )
        }
    }
}