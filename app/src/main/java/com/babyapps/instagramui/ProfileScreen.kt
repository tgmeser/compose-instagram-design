package com.babyapps.instagramui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.babyapps.instagramui.ui.theme.BlueLink
import com.babyapps.instagramui.ui.theme.MediumGray

@ExperimentalFoundationApi
@SuppressLint("RememberReturnType")
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "cakir_suleyman", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(5.dp))

        ProfileInfoSection()
        Spacer(modifier = Modifier.height(25.dp))

        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))

        StorySection(
            stories = listOf(
                Story(
                    title = "King",
                    image = painterResource(id = R.drawable.cakir)
                ),
                Story(
                    title = "Bro",
                    image = painterResource(id = R.drawable.bro)
                ),
                Story(
                    title = "Family",
                    image = painterResource(id = R.drawable.fam)
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        /*
        Post(title = "cakir12",image = painterResource(id = R.drawable.cakir12)),
                Post(title = "cakir11",image = painterResource(id = R.drawable.cakir11)),
                Post(title = "cakir10",image = painterResource(id = R.drawable.cakir10)),
                Post(title = "cakir8",image = painterResource(id = R.drawable.cakir8)),
                Post(title = "cakir7",image = painterResource(id = R.drawable.cakir7)),
                Post(title = "cakir6",image = painterResource(id = R.drawable.cakir6)),
                Post(title = "cakir5",image = painterResource(id = R.drawable.cakir5)),
                Post(title = "cakir4",image = painterResource(id = R.drawable.cakir4)),
                Post(title = "cakir3",image = painterResource(id = R.drawable.cakir3)),
                Post(title = "cakir2",image = painterResource(id = R.drawable.cakir2)),
                Post(title = "cakir1",image = painterResource(id = R.drawable.cakir)),
         */
        PostTabs(
            posts = listOf(
                Post(title = "Posts", image = painterResource(id = R.drawable.ic_grid)),
                Post(title = "Reels", image = painterResource(id = R.drawable.ic_reels)),
                Post(title = "IGTV", image = painterResource(id = R.drawable.ic_igtv)),
                Post(title = "Profile", image = painterResource(id = R.drawable.profile)),
            ),
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.cakir12),
                    painterResource(id = R.drawable.cakir11),
                    painterResource(id = R.drawable.cakir10),
                    painterResource(id = R.drawable.cakir8),
                    painterResource(id = R.drawable.cakir7),
                    painterResource(id = R.drawable.cakir6),
                    painterResource(id = R.drawable.cakir5),
                    painterResource(id = R.drawable.cakir4),
                    painterResource(id = R.drawable.cakir3),
                    painterResource(id = R.drawable.cakir2),
                    painterResource(id = R.drawable.cakir),
                ), modifier =Modifier.fillMaxWidth()
            )
        }

    }
}


//Top Bar
@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
        //Same space of topbar top and bot edges
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Go Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Icon(
            // Use painter if we pick an icon from our resource
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Go Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Go Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }

}

@Composable
fun ProfileInfoSection(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {

            // Profile pic is %30 of ProfileInfoSection
            RoundImage(
                image = painterResource(id = R.drawable.suleymancakir),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))

            // Statics Section is %70 of ProfileInfoSection
            StatsSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            displayName = "\uD83D\uDC51 King of Istanbul \uD83D\uDC51",
            description = "Husband, Dad, Youtuber, Gamer and more...\n" +
                    "Do not forget to subscribe my channel ♥♥♥",
            url = "youtube.com/cakirsuleyman",
            followedBy = listOf("ali_candan", "34.nesrin"),
            otherCount = 20
        )


    }

}

@Composable
fun RoundImage(image: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatsSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ProfileStats(numberText = "10", text = "Posts")
        ProfileStats(numberText = "50 M", text = "Followers")
        ProfileStats(numberText = "0", text = "Following")
    }
}

@Composable
fun ProfileStats(numberText: String, text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = text)

    }

}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int,
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = BlueLink,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )

        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    pushStyle(boldStyle)
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1)
                            append(", ")
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }


    }
}

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height = height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height = height)
        )
        ActionButton(
            text = "Email",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height = height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier.size(height)
        )

    }
}

@Composable
fun ActionButton(modifier: Modifier = Modifier, text: String? = null, icon: ImageVector? = null) {
    // Some buttons have symbols some buttons have just text or just symbols
    //Thats why we use nullable text and icon above

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }
        if (icon != null) {
            Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        }

    }
}

@Composable
fun StorySection(
    modifier: Modifier = Modifier,
    stories: List<Story>
) {
    LazyRow(modifier = modifier) {
        items(stories.size) {
            Column(
                modifier = Modifier.padding(end = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                RoundImage(image = stories[it].image, modifier = Modifier.size(70.dp))
                Text(
                    text = stories[it].title,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}


@Composable
fun PostTabs(
    modifier: Modifier = Modifier,
    posts: List<Post>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    TabRow(
        backgroundColor= Color.Transparent,
        selectedTabIndex = selectedTabIndex,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        posts.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = MediumGray,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.title,
                    tint = if (selectedTabIndex == index) Color.Black else MediumGray,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )

            }
        }

    }

}

@ExperimentalFoundationApi
@Composable
fun PostSection(posts: List<Painter>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = modifier.scale(1.01f)) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp, color = Color.White)
            )
        }
    }
}