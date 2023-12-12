package com.listvictortercero.navigation

sealed class Routes(val route:String) {
    object MainScreen: Routes("Screen Principal")
    object IkeaWiki: Routes("Para todas tus necesidades informativas suecas")
}