package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ucp1(modifier: Modifier) {

    var berangkat by remember { mutableStateOf("") }
    var tujuan by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }
    var datakelas = listOf("Ekonomi", "Business")

    var confBerangkat by remember { mutableStateOf("") }
    var confTujuan by remember { mutableStateOf("") }
    var confKelas by remember { mutableStateOf("") }



Column (){
    Column (modifier = Modifier
        .padding(16.dp)
        .background(Color.White).shadow(5.dp
        )){

        Header()
        Text(text = "Pemesanan")
        TextField(
            value = berangkat,
            onValueChange = {berangkat = it},
            label = {
                Text(text = "Berangkat")
            },
            placeholder = {
                Text(text = "isi ") //Hint text
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = tujuan,
            onValueChange = {tujuan = it},
            label = {
                Text(text = "Tujuan")
            },
            placeholder = {
                Text(text = "isi tujuan") //Hint text
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Row (modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)){
            datakelas.forEach{selectedKelas ->
                Row (
                    verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = kelas == selectedKelas,
                        onClick = { kelas = selectedKelas
                        }
                    )
                    Text(text = selectedKelas)

                }}
        }

        Button(onClick = {
            confBerangkat = berangkat
            confTujuan = tujuan
            confKelas = kelas
        }) {
            Text(text = "Submit")

        }
        TampilData(param = "Berangkat",  argum = confBerangkat)
        TampilData(param = "Tujuan",  argum = confTujuan)
        TampilData(param = "Class",  argum = confKelas)
    }
}

}

@Composable
fun TampilData(
    param: String, argum: String
){
    Column {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Black))
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(text = param,
                    modifier = Modifier.weight(0.8f).background(Color.White)) // memberi ruang seberapa banyak dalam kolon/barisnya
                Text(text = ":",
                    modifier = Modifier.weight(0.2f).background(Color.White))
                Text(text = argum, //kenapa argum? karena isinya akan digantikan dengan parameter argum
                    modifier = Modifier.weight(2f).background(Color.White))

            }
        }
    }

}

@Composable
fun Header(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Box(
                contentAlignment = Alignment.BottomEnd
            ){
            }
            Icon(
                Icons.Filled.Notifications,
                contentDescription =null,
                modifier =Modifier.size(30.dp)
            )
            Column(
                modifier = Modifier.padding(14.dp)
            ){
                Text(text = "Good Afternoon,")
                Text(text = "Indra Al Fauzan")
            }
        }
    }
}