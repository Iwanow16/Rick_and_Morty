package ru.example.characters.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.example.characters.model.CharacterUi

@Composable
fun CharacterItem(
    modifier: Modifier = Modifier,
    character: CharacterUi,
    onClick: (Long) -> Unit
) {
    val color = when (character.status) {
        "Alive" -> Color.Green
        "Dead" -> Color.Red
        else -> Color.Gray
    }

    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(character.id) }
    ) {
        Row {
            AsyncImage(
                model = character.imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.35f)
            )
            Column {
                Text(
                    text = character.name,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Origin", fontSize = 14.sp)
                Text(text = character.origin)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Status", fontSize = 14.sp)

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(color = color, shape = CircleShape)
                    )
                    Text(text = character.status + " - " + character.species)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterListContentPreview() {
    val character = CharacterUi(
        id = 44,
        name = "Body Guard Morty",
        status = "Dead",
        species = "Human",
        gender = "Male",
        origin = "unknown",
        imageUrl = "https://rickandmortyapi.com/api/character/avatar/44.jpeg"
    )
    MaterialTheme {
        CharacterItem(
            character = character,
            onClick = {}
        )
    }
}
