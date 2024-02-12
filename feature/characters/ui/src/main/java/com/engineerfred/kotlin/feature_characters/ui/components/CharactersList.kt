package com.engineerfred.kotlin.feature_characters.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import com.engineerfred.kotlin.feature_characters.domain.model.Character

@Composable
fun CharactersList(
    modifier: Modifier = Modifier,
    characters: LazyPagingItems<Character>,
    onCardClick: (Long) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        items(
            count = characters.itemCount,
            key = { characters[it]!!.id },
            contentType = characters.itemContentType{"characters"}
        ) {
            characters[it]?.let {
                CharacterCard(
                    character = it,
                    onCardClick = {
                        onCardClick(it.id)
                    }
                )
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp))
            }
        }
        when ( characters.loadState.append ) {
            is LoadState.Error -> {
                item {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
                    ) {
                        Text(
                            text = "Failed to load more characters!",
                            fontSize = 13.sp,
                            color = Color.Gray,
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Retry",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Magenta,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 11.dp)
                                .clickable {
                                    characters.retry()
                            }, textAlign = TextAlign.Center
                        )
                    }
                }
            }
            LoadState.Loading -> {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator( modifier = Modifier.size(21.dp), color = Color.Magenta )
                    }
                }
            }
            else -> Unit
        }
    }

}