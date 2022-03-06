package com.rifara.praktik2.mengirimDataPadaIntent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.rifara.praktik2.R

class MoveWithDataActivity : AppCompatActivity() {

    // companion object untuk membuat komponen yg static dan bisa di akses dari luar kelas
    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)


        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)
    // mengirimkan data bertipe string ke MoveWithDataActivity.
    // Di dalam MoveWithdataActivity akan mengambil nilai data berdasarkan key yang dikirimkan
    // dengan menggunakan metode getIntent().getStringExtra(key).
    // mengirim dan mengambil nilai data adalah sama, yaitu EXTRA_NAME (yang bernilai “extra_name”).
        val name = intent.getStringExtra(EXTRA_NAME)

    // Begitu juga dengan variable age.
    // Nilai dari variabel age yang bertipe data integer berasal dari getIntent().getIntExtra(Key, nilai default).
    // mengirimkan dan mengambil data adalah EXTRA_AGE (yang bernilai “extra_age”).

    // Nilai default di sini merupakan nilai yang akan digunakan jika ternyata datanya kosong.
    // Data kosong atau nilainya null bisa terjadi ketika datanya memang tidak ada, atau key-nya tidak sama.
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val text = "Name : $name\nYour Age : $age"
        tvDataReceived.text = text
    }
}

/*
Sebelumnya, mengirimkan data bernilai tunggal dari satu activity ke activity lain adalah hal yang
mudah. Bernilai tunggal karena data yang dikirimkan berasal dari satu tipe data.
Misalnya pada contoh di atas, pengiriman nilai data name dan age dilakukan secara individu.
Yang satu bertipe data string dan yang lainnya bertipe data integer.

Sekarang pertanyaanya bagaimana Anda bisa mengirimkan banyak data sekaligus dari
satu activity ke activity lain melalui intent? Caranya adalah dengan menggunakan
kelas model yang terimplementasi parcelable.
*/