package com.shah.amazonclone.ui.components.bottombar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.shah.amazonclone.utilities.helpers.BottomBarScreen

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun RowScope.BottomBarItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title, style = MaterialTheme.typography.labelMedium)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Navigation icon")
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = MaterialTheme.colorScheme.outline,
        onClick = {
            navController.navigate(screen.route)
        }
    )
}
