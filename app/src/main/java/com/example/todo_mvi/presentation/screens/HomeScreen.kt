package com.example.todo_mvi.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import com.example.todo_mvi.R
import com.example.todo_mvi.presentation.viewmodel.MainActivityViewModel
import com.example.todo_mvi.ui.theme.PrimaryColor
import com.example.todo_mvi.ui.theme.PrimaryLightColor
import com.example.todo_mvi.ui.theme.shadowColor

@Composable
fun HomeScreen(navController: NavHostController, mainViewmodel: MainActivityViewModel) {
    val homeUIState by mainViewmodel.homeUIState.collectAsState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (toolbar, logoBox,
            myTaskText, myTaskLazyColumn,
            completedTaskText, completedTaskLazyColumn,
            addFab) = createRefs()

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(color = PrimaryLightColor)
            .constrainAs(toolbar) {
                top.linkTo(parent.top, margin = 15.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Image(
                painter = painterResource(id = R.drawable.profile_icon),
                contentDescription = "Image",
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.CenterEnd
            )
        }

        Box(modifier = Modifier
            .size(130.dp)
            .padding(top = 10.dp)
            .background(Color.Transparent)
            .constrainAs(logoBox) {

            }
        ) {
            Image(painter = painterResource(R.drawable.tm_logo),
                contentDescription = "logo",
                modifier = Modifier.fillMaxSize()
                    .shadow(clip = true, elevation = 69.dp, shape = CircleShape, spotColor = shadowColor)
            )
        }

        Text(
            text = "My Tasks",
            fontSize = 21.sp,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
                .constrainAs(myTaskText) {
                    top.linkTo(logoBox.bottom)
                }
        )


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(myTaskLazyColumn) {
                    top.linkTo(myTaskText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(completedTaskText.top)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        ) {

        }

        Text(
            text = "My Completed Tasks",
            fontSize = 21.sp,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp)
                .constrainAs(completedTaskText) {
                    top.linkTo(myTaskLazyColumn.bottom, margin = 10.dp)
                    bottom.linkTo(completedTaskLazyColumn.top)
                }
        )


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(completedTaskLazyColumn) {
                    top.linkTo(completedTaskText.bottom, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        ) {

        }

        // Add Floating action button
        FloatingActionButton(onClick = {},
            containerColor = PrimaryColor,
            contentColor = PrimaryLightColor,
            shape = CircleShape,
            modifier = Modifier.constrainAs(addFab) {
                end.linkTo(parent.end, margin = 15.dp)
                bottom.linkTo(parent.bottom, margin = 15.dp)
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Icon")
        }

    }
}