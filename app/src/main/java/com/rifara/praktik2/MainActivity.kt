package com.rifara.praktik2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.rifara.praktik2.explicitIntent.MoveActivity
import com.rifara.praktik2.intentDenganResultActivity.MoveForResultActivity
import com.rifara.praktik2.mengirimDataPadaIntent.MoveWithDataActivity
import com.rifara.praktik2.mengirimdatadenganparcelable.MoveWithObjectActivity
import com.rifara.praktik2.mengirimdatadenganparcelable.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Latihan Intent dengan ResultActivity
    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setOnClickListener: memberikan aksi kepada komponen apabila di klik oleh user
        // Latihan Explicit Intent
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        // Latihan mengirim data pada intent
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        // Latihan mengirim data dengan parcelable
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        // Latihan Implicit Intent
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        // Latihan Intent dengan ResultActivity/membuat sebuah Intent yang didalamnya akan membawa data dengan ResultActivity.
        val btnMoveForResult:Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)
        tvResult = findViewById(R.id.tv_result)

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


            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Dicoding Academy",
                    5,
                    "Academy@dicoding.com",
                    "Bandung"
                )

                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON,person)
                startActivity(moveWithObjectIntent)
            }


            R.id.btn_dial_number -> {
                val phoneNumber = "0895412892094"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }


            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity,MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }




}