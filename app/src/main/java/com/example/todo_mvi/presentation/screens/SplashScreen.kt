package com.example.todo_mvi.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.todo_mvi.R
import com.example.todo_mvi.ui.theme.PrimaryLightColor

@Composable
fun SplashScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(PrimaryLightColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(200.dp)
                .shadow(30.dp, shape = CircleShape),
            painter = painterResource(R.drawable.tm_logo),
            contentDescription = "LogoImage")

        android.os.Handler().postDelayed({
            navController.navigate(Navigation.HOME_SCREEN)
        }, 3000)
    }
}