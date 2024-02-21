package com.example.dailyquotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dailyquotesapp.data.DataSource
import com.example.dailyquotesapp.model.Quote
import com.example.dailyquotesapp.ui.theme.DailyQuotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyQuotesAppTheme {
                QuotesApp()
            }
        }
    }
}

@Composable
fun QuotesApp()
{
    QuotesList(
        quotesList = DataSource().loadQuotes()
    )
}

@Composable
fun QuotesList(quotesList: List<Quote>, modifier: Modifier = Modifier)
{
    LazyColumn {
        items(quotesList) {
            quote: Quote -> QuoteCard(quote = quote, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun QuoteCard(quote: Quote, modifier: Modifier = Modifier)
{
    Card(modifier = modifier)
    {
        Column {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = quote.authorResourceId),
                    modifier = modifier.padding(10.dp),
                    style = MaterialTheme.typography.h6
                )

                Image(
                    painter = painterResource(id = quote.imageResourceId),
                    contentDescription = stringResource(id = quote.stringResourceId),
                    contentScale = ContentScale.Crop,
                    modifier = modifier.size(100.dp).clip(CircleShape)
                )
            }

            Text(
                text = stringResource(id = quote.stringResourceId),
                modifier = modifier.padding(10.dp),
                style = MaterialTheme.typography.body1
            )
        }
//        Column {
//            Image(
//                painter = painterResource(id = quote.imageResourceId),
//                contentDescription = stringResource(id = quote.stringResourceId),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(194.dp),
//                contentScale = ContentScale.Crop
//            )
//            Text(
//                text = stringResource(id = quote.stringResourceId),
//                modifier = modifier.padding(10.dp),
//                style = MaterialTheme.typography.h6
//            )
//        }
    }
}

@Preview
@Composable
fun QuoteCardPreview()
{
    QuotesApp()
}