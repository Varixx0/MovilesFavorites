/*
    @Author Victor Tercero
 */

package com.listvictortercero.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.listvictortercero.model.Ikea
import com.listvictortercero.viewmodel.IkeaViewModel

@Composable
fun IkeaWiki(
    navController: NavController,
    ikeaViewModel: IkeaViewModel
){
    val furniture: Ikea by ikeaViewModel.selectedFurniture.observeAsState(initial = Ikea())
    var favorite by rememberSaveable {
        mutableStateOf(0xFFFFFFFF)
    }
    Column (modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)
    ){
        if (furniture.favorite){
            favorite= 0xFFFFFFFF
            furniture.favorite=false
        } else{
            favorite = 0xFFFFD700
            furniture.favorite=true
        }
        Row (
            modifier = Modifier.clickable {
                navController.popBackStack()
            }
        ){
            Icon(imageVector = Icons.Default.ArrowBack , contentDescription = "Volver")
            Spacer(modifier = Modifier.width(30.dp))
            Text(text = "Volver")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(imageVector = Icons.Default.Menu, contentDescription ="IKEA" )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = furniture.name,
                fontSize = 30.sp
                )
            Spacer(modifier = Modifier.width(30.dp))
            Button(onClick = {
                if (furniture.favorite){
                    favorite= 0xFFFFFFFF
                    furniture.favorite=false
                } else{
                    favorite = 0xFFFFD700
                    furniture.favorite=true
                }
                             } , colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)) {
                Icon(imageVector = Icons.Default.Star, contentDescription ="", tint = Color(favorite))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(8.dp)
        ) {
            Text(text = "Aqui se encuentra la informacion detallada del mueble" ,
                color = MaterialTheme.colorScheme.onTertiary)
        }
    }
}