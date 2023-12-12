package com.listvictortercero.screen

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.listvictortercero.model.Ikea
import com.listvictortercero.navigation.Routes
import com.listvictortercero.viewmodel.IkeaViewModel

@Composable
fun MainScreen(
    navController: NavController,
    ikeaViewModel: IkeaViewModel
) {
    val furniture: List<Ikea> by ikeaViewModel.furniture.observeAsState(initial = emptyList())
    val isLoadingFurniture: Boolean by ikeaViewModel.isLoading.observeAsState(initial = false)

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 8.dp)
    ) {
        items(furniture) { furniture ->
            FurnitureCard(furniture = furniture, navController =navController , ikeaViewModel = ikeaViewModel)
        }
    }
    if (isLoadingFurniture) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Text(
                text = "Loading...",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(20.dp))
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FurnitureCard(
    furniture: Ikea,
    navController: NavController,
    ikeaViewModel: IkeaViewModel
) {
    OutlinedCard(
        modifier = Modifier
            .padding()
            .clickable {
                ikeaViewModel.onFurnitureClicked(furniture)
                navController.navigate(Routes.IkeaWiki.route)
            }
    ) {
        ListItem(
            headlineText = { Text(text = furniture.name) },
            supportingText = { Text(text = furniture.category) },
            leadingContent = {
                if (furniture.favorite) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Fav",
                        tint = Color(0xFFFB8C00)
                    )
                }
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Del",
                    modifier = Modifier.clickable {
                        ikeaViewModel.deleteFurniture(furniture)
                    })
            }
        )
    }
}