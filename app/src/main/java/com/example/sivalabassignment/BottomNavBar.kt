package com.example.sivalabassignment

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sivalabassignment.ui.theme.ButtonBlue
import com.example.sivalabassignment.ui.theme.DarkerButtonBlue
import com.example.sivalabassignment.ui.theme.Typography


@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
){
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = DarkerButtonBlue,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = ButtonBlue,
                unselectedContentColor = Color.White,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(imageVector = item.icon, contentDescription = item.name)
                        if (selected){
                            Text(text = item.name, textAlign = TextAlign.Center, style = Typography.h2 )
                        }
                    }
                }
            )
        }
    }

}

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route = Screen.HomeScreen.route){
            HomeScreen()
        }
        composable(route = Screen.AllLabScreen.route){
            AllLabScreen()
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen()
        }

    }
}