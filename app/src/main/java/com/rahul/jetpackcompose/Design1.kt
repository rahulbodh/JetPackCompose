package com.rahul.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahul.jetpackcompose.data.AlignYourBodyItem
import com.rahul.jetpackcompose.data.FavoriteCollectionData
import com.rahul.jetpackcompose.ui.theme.JetpackComposeTheme

class Design1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
//                FavoriteCollectionCardPreview(R.drawable.img1,R.string.nature_meditations,modifier = Modifier.padding(8.dp))
//                AlignYourBodyRow(modifier = Modifier.padding(8.dp))
                FavoriteCollectionGrid(modifier = Modifier.padding(8.dp))


            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(R.string.search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    val alignYourBodyData = listOf(
        AlignYourBodyItem(R.drawable.img1, R.string.yoga),
        AlignYourBodyItem(R.drawable.img2, R.string.cycling),
        AlignYourBodyItem(R.drawable.img3, R.string.meditation),
        AlignYourBodyItem(R.drawable.img4, R.string.running),
        AlignYourBodyItem(R.drawable.img5, R.string.swimming)
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text, modifier)
        }
    }
}


@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
data class FavoriteCollectionData(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Composable
fun FavoriteCollectionGrid(
    modifier: Modifier = Modifier
) {
    val favoriteCollectionData = listOf(
        FavoriteCollectionData(R.drawable.img1, R.string.nature_meditations),
        FavoriteCollectionData(R.drawable.img2, R.string.nature_meditations),
        FavoriteCollectionData(R.drawable.img3, R.string.nature_meditations),
        FavoriteCollectionData(R.drawable.img4, R.string.nature_meditations)
    )

    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favoriteCollectionData) { item ->
            FavoriteCollectionCard(
                drawable = item.drawable,
                text = item.text,
                modifier = Modifier.height(80.dp)
            )
        }
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}


@Preview()
@Composable
fun searchBarPreview() {
    JetpackComposeTheme {
        SearchBar(modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionPreview() {
    JetpackComposeTheme {
        FavoriteCollectionGrid(modifier = Modifier.padding(8.dp))
//        FavoriteCollectionCardPreview(R.drawable.img1,R.string.nature_meditations,modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun alignYourBodyPreview() {
    JetpackComposeTheme {
        AlignYourBodyRow()
//        AlignYourBodyElement(R.drawable.img2 , R.string.align_your_body,modifier = Modifier.padding(8.dp))
    }
}