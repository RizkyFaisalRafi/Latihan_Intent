package com.rifara.praktik2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.rifara.praktik2.explicitIntent.MoveActivity
import com.rifara.praktik2.mengirimDataPadaIntent.MoveWithDataActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        // setOnClickListener: memberikan aksi kepada komponen apabila di klik oleh user
        btnMoveActivity.setOnClickListener(this)


        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
        // startActivity(moveIntent): Akan menjalankan activity baru tanpa membawa data
        // Obyek intent yang diinputkan adalah obyek moveIntent yang ketika kode ini dijalankan maka
        // akan membuka MoveActivity.
                startActivity(moveIntent)
            }

        // Perbedaan mendasar antara memindahkan Activity dengan membawa data atau tidak,
        // adalah dengan menempatkan data ke obyek Intent pada baris ini.
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)

        // memanfaatkan metode putExtra() untuk mengirimkan data bersamaan dengan obyek Intent.
        // Sedangkan metode putExtra() itu sendiri merupakan metode yang menampung pasangan
        // key-value dan memiliki beberapa pilihan tipe input hampir semua tipe data untuk input
        // value didukung oleh metode putExtra().
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
        /*
        MoveWithDataActivity.EXTRA_NAME diatas, dimana EXTRA_NAME adalah variabel static bertipe
        data string dan bernilai extra_name pada MoveWithDataActivity. Penentuan nilai untuk
        key parameter untuk intent adalah bebas, di sini kami merekomendasikan format
        terbaik yang biasa diimplementasikan.
        */


                startActivity(moveWithDataIntent)
            }

        }
    }




}