package com.base.meditation_composeui.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.base.meditation_composeui.BottomMenuItem
import com.base.meditation_composeui.Features
import com.base.meditation_composeui.R


@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier.background(DeepBlue)
            .fillMaxSize()
    ){
     Column{
         GreetingSection()
         ChipSection(chips = listOf(
             "Sweet sleep","Insomia","Depression"
         ))
         CurrentMeditation()
         FeatureSection(features = listOf(
             Features(
                 title = "Sleep Meditation",
                 color = BlueViolet3,
                 R.drawable.headphone
             ),
             Features(
                 title = "Tips for Sleeping",
                 color = LightGreen3,
                 R.drawable.recorder
             ),
             Features(
                 title = "Night Island",
                 color = OrangeYellow3,
                 R.drawable.recorder
             ),
             Features(
                 title = "Calming Sounds",
                 color = Beige3,
                 R.drawable.headphone
             )

         ))

     }
        BottomMenu(items = listOf(
            BottomMenuItem(
                "Home",R.drawable.home,
            ),
            BottomMenuItem(
                title = "Meditate",R.drawable.meditate
            ),
            BottomMenuItem(
                title = "Sleep",R.drawable.moon
            ),
            BottomMenuItem(
                title = "Music",R.drawable.music
            ),
            BottomMenuItem(
                title = "Profile",R.drawable.profile
            )
        ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun GreetingSection(
    name:String="Messi"
){
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(15.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning $name",
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 14.sp,
                color = TextWhite
            )
            Text(
                text = "Have a good day today",
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 14.sp,
                color = TextWhite
            )
        }
        Icon(
           painter = painterResource(R.drawable.baseline_search_24),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(
    chips:List<String>
){
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start=15.dp,top=15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex=it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if(selectedChipIndex==it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ){
                Text(text=chips[it],color= TextWhite, fontSize = 14.sp,
                    fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
            }
        }
    }
}
@Composable
fun CurrentMeditation(
    color:Color= LightRed
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){
        Column {
            Text(
                text = "Daily Thought",
                color= TextWhite,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp

            )

            Text(
                text = "Meditation",
                color= TextWhite,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(R.drawable.baseline_play_arrow_24),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun FeatureSection(
    features:List<Features>
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Featured",
            color = TextWhite,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 20.dp,top=23.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start=7.dp,end=7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ){
            items(features.size){
             FeatureItem(features=features[it])
            }
        }
    }

    }
@Composable
fun FeatureItem(
    features: Features
){
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(15.dp)
            .background(features.color)
            .height(180.dp)
            .width(180.dp)
            .clip(RoundedCornerShape(10.dp))
    ){
        Text(
            text = features.title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = Color.Black,
            modifier = Modifier.align(Alignment.TopStart)
                .padding(20.dp)
        )
        Icon(
            painter = painterResource(id = features.iconid),
            contentDescription = "Images",
            tint = Color.Black,
            modifier = Modifier.align(Alignment.BottomStart)
                .padding(20.dp)
        )

       Icon(
           painter = painterResource(R.drawable.baseline_start_24),
           contentDescription = "Start",
           tint = Color.Black,
           modifier = Modifier.align(Alignment.BottomEnd)
               .padding(20.dp)
       )
    }
}


@Composable
fun BottomMenu(
    items:List<BottomMenuItem>,
    modifier: Modifier=Modifier,
    activehighlightcolor:Color= ButtonBlue,
    activeTextColor:Color=Color.White,
    inactiveTextcolor:Color= AquaBlue,
    selectedindex:Int=0
){
 var selectedindex by remember {
     mutableStateOf(selectedindex)
 }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ){
        items.forEachIndexed{index,item ->
          BottomMenuItems(item=item,
              isseleted = index==selectedindex,
              activehighlightcolor=activehighlightcolor,
              activeTextColor=activeTextColor,
              inactiveTextcolor=inactiveTextcolor
          ){
            selectedindex=index
          }
        }
    }
}

@Composable
fun BottomMenuItems(
    item:BottomMenuItem,
    isseleted:Boolean=false,
    activehighlightcolor:Color= ButtonBlue,
    activeTextColor:Color=Color.White,
    inactiveTextcolor:Color= AquaBlue,
    onItemClick:()-> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }

    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.clip(RoundedCornerShape(18.dp))
                .background(
                    if(isseleted) activehighlightcolor else Color.Transparent
                )
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(id=item.iconid),
                contentDescription = item.title,
                tint = if(isseleted) activeTextColor else inactiveTextcolor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color=if(isseleted) activeTextColor else inactiveTextcolor,
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
    }
}