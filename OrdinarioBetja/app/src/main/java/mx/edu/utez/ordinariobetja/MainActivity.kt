package mx.edu.utez.ordinariobetja

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import mx.edu.utez.ordinariobetja.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSalir.setOnClickListener{
            finish()
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //redirection with menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnuE -> {
                val intent = Intent(this@MainActivity, Estaciones::class.java)
                startActivity(intent)
            }
            R.id.mnuApi -> {
                val intent = Intent(this@MainActivity, Api::class.java)
                startActivity(intent)
            }
            R.id.mnuA -> {
                val intent = Intent(this@MainActivity, SharedP::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }



}