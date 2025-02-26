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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
//                FavoriteCollectionGrid(modifier = Modifier.padding(8.dp))
                MySootheAppPortrait()
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

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }

        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionGrid()
        }
        Spacer(Modifier.height(16.dp))

    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
private fun BottomNavigation(modifier: Modifier = Modifier){
    NavigationBar (
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ){
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa ,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.home)
                )
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle ,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.profile)
                )
            },
            selected = true,
            onClick = {}
        )
    }
}

@Composable
fun MySootheAppPortrait() {
    JetpackComposeTheme {
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}


//@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
//@Composable
//fun HomeSectionPreview() {
//    JetpackComposeTheme {
//        HomeSection(R.string.align_your_body) {
//            AlignYourBodyRow()
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun homeScreenPreview() {
    JetpackComposeTheme {
        HomeScreen()
    }
}
//
//@Preview()
//@Composable
//fun searchBarPreview() {
//    JetpackComposeTheme {
//        SearchBar(modifier = Modifier.padding(8.dp))
//    }
//}
//
//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun FavoriteCollectionPreview() {
//    JetpackComposeTheme {
//        FavoriteCollectionGrid(modifier = Modifier.padding(8.dp))
////        FavoriteCollectionCardPreview(R.drawable.img1,R.string.nature_meditations,modifier = Modifier.padding(8.dp))
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun alignYourBodyPreview() {
//    JetpackComposeTheme {
//        AlignYourBodyRow()
////        AlignYourBodyElement(R.drawable.img2 , R.string.align_your_body,modifier = Modifier.padding(8.dp))
//    }
//}

@Preview(showBackground = true)
@Composable
fun bottonNavPreview() {
    JetpackComposeTheme {
        BottomNavigation(modifier = Modifier.padding(8.dp))
    }
}

