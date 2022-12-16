package mx.edu.utez.ordinariobetja

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import mx.edu.utez.ordinariobetja.databinding.ActivityEstacionesBinding
import mx.edu.utez.ordinariobetja.databinding.ActivityMainBinding

class Estaciones : AppCompatActivity() {
    lateinit var binding: ActivityEstacionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEstacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val estacion = listOf("Primavera", "Verano", "Otoño", "Invierno")


        val adaptador =  ArrayAdapter(this@Estaciones,
            android.R.layout.simple_list_item_1,estacion
            )
        binding.spEstaciones.adapter = adaptador

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //redirection with menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnuE -> {
                val intent = Intent(this@Estaciones, Estaciones::class.java)
                startActivity(intent)
            }
            R.id.mnuApi -> {
                val intent = Intent(this@Estaciones ,Api::class.java)
                startActivity(intent)
            }
            R.id.mnuA -> {
                val intent = Intent(this@Estaciones, SharedP::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}