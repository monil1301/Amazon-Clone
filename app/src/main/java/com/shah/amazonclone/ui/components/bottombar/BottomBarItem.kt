package com.shah.amazonclone.ui.components.bottombar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
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
    badgeCount: Int = 0,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title, style = MaterialTheme.typography.labelMedium)
        },
        icon = {
            BadgedBox(
                badge = {
                    if (badgeCount > 0) {
                        Badge(
                            modifier = Modifier
                                .padding(top = 14.dp)
                                .size(16.dp)
                                .clip(CircleShape)
                        ) {
                            Text(text = badgeCount.toString())
                        }
                    }
                }
            ) {
                Icon(imageVector = screen.icon, contentDescription = "Navigation icon")
            }
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
