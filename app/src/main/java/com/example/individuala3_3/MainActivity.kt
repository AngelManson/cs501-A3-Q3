package com.example.individuala3_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.individuala3_3.ui.theme.IndividualA33Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndividualA33Theme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        @OptIn(ExperimentalMaterial3Api::class)
                        CenterAlignedTopAppBar(
                            title = { Text("Tag Browser + Filter", fontWeight = FontWeight.Bold) }
                        )
                    }) { innerPadding ->
                    Flow(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Flow(modifier: Modifier = Modifier) {

    val allGenres = listOf("Romance", "Action", "Comedy", "Drama", "Fantasy", "Horror", "Mystery",
        "Sci-Fi", "Thriller", "Western", "Animation", "Crime", "Documentary", "Family",
        "History", "Musical", "War", "Foreign"
    )
    var favoriteGenres by remember { mutableStateOf(setOf<String>()) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "All Genres",
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            allGenres.forEach { genre ->
                val isSelected = genre in favoriteGenres

                FilterChip(
                    selected = isSelected,
                    onClick = {
                        favoriteGenres =
                            if (isSelected) favoriteGenres - genre //if its currently selected then clicking will unselect
                            else favoriteGenres + genre //if its not selected then clicking will select
                    },
                    label = { Text(genre) },
                    leadingIcon = if (isSelected) {
                        {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Selected",
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    } else {
                        null
                    },
                    border = BorderStroke(1.2.dp, Color.DarkGray)
                )
            }
        }

//        Spacer(modifier = Modifier.height(6.dp))
        Divider(modifier = Modifier.padding(horizontal = 16.dp))

        Text(
            text = "Favorite Genres",
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )
        )

        if (favoriteGenres.isEmpty()) {
            AssistChip(
                onClick = { },
                label = { Text("No tags selected") },
            )
        } else {
            FlowColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                maxItemsInEachColumn = 6
            ) {
                favoriteGenres.forEach { genre ->
                    AssistChip(
                        onClick = {
                            favoriteGenres = favoriteGenres - genre
                        },
                        label = { Text(genre) },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Remove Genre",
                                modifier = Modifier.size(AssistChipDefaults.IconSize)
                            )
                        },
                        border = BorderStroke(1.2.dp, Color.DarkGray)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { favoriteGenres = emptySet() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Clear Favorite")
        }

        ElevatedCard(
            modifier = Modifier.fillMaxSize(),
            shape = RectangleShape
        ) {
            Text(
                text = "Number of favorite genres: ${favoriteGenres.size}",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true, locale = "en") //needed to add locale for preview to start working again
@Composable
fun FlowPreview() {
    IndividualA33Theme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                @OptIn(ExperimentalMaterial3Api::class)
                CenterAlignedTopAppBar(
                    title = { Text("Tag Browser + Filter", fontWeight = FontWeight.Bold) }
                )
            }) { innerPadding ->
            Flow(modifier = Modifier.padding(innerPadding))
        }
    }
}