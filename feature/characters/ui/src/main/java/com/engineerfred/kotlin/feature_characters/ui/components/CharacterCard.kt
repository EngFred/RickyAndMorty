package com.engineerfred.kotlin.feature_characters.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.engineerfred.kotlin.core.theme.theme.RIckyMortyFinaleTheme
import com.engineerfred.kotlin.feature_characters.domain.model.Character
import kotlinx.coroutines.Dispatchers
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    character: Character,
    onCardClick: () -> Unit
) {

    val context = LocalContext.current

    val imageRequest = ImageRequest.Builder(context)
        .data(character.imageUrl)
        .dispatcher(Dispatchers.IO)
        .memoryCacheKey(character.imageUrl)
        .diskCacheKey(character.imageUrl)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .build()

    // Load and display the image with AsyncImage

    Card(
        onClick = { onCardClick.invoke() },
        modifier = modifier.fillMaxWidth().height(185.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            AsyncImage(
                model = imageRequest,
                contentDescription = "character image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.background(Color.LightGray).fillMaxHeight().fillMaxWidth(.4f)
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 14.dp),
                verticalArrangement = Arrangement.Center
            ) {
                
                Text(
                    text = character.name,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Start
                ) {
                    StatusDot(status = character.status)
                    Text(
                        text = "${ character.status.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(
                                    Locale.getDefault()
                                ) else it.toString()
                            }
                        } - ${character.species.capitalize(Locale.ROOT)}",
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Last Known Location:",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${character.location?.name}",
                    fontSize = 17.sp
                )
            }
        }
    }
}

@Composable
private fun StatusDot(
    status: String
) {
    
    val color = when(status) {
        "Alive" -> Color.Green
        "Dead" -> Color.Red
        else -> Color.Gray
    }
    
    Box(
        modifier = Modifier
            .padding(top = 10.dp)
            .size(10.dp)
            .clip(CircleShape)
            .background(color),
    )

}


@Preview
@Composable
private fun StatusDotPreview() {
    RIckyMortyFinaleTheme {
        StatusDot(status = "alive")
    }
}

@Preview
@Composable
private fun CharacterCardPreview() {
    RIckyMortyFinaleTheme {
        CharacterCard(character = Character(
            id = 1,
            name = "Fred",
            status = "alive",
            gender = "male",
            species = "human",
            origin = null,
            imageUrl = "",
            location = null,
            episodeUrls = emptyList()
        )
        ) {
            
        }
    }
}