package mx.edu.utez.ordinariobetja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import mx.edu.utez.ordinariobetja.databinding.ActivityApiBinding
import mx.edu.utez.ordinariobetja.databinding.ActivitySharedPBinding

class SharedP : AppCompatActivity() {
    lateinit var binding: ActivitySharedPBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPBinding.inflate(layoutInflater)
        setContentView(binding.root)


//
        var nombre =  ""

        binding.btnGuardar.setOnClickListener {
            val nombre = binding.edtNombre.text.toString()
            val carrera = binding.edtCarrera.text.toString()
            val sharedPref = getSharedPreferences("sharedPref", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("nombre",nombre)
            editor.putString("carrera",carrera)
            editor.apply()
            editor.commit()
            binding.edtNombre.setText("")

        }
        binding.btnMostrar.setOnClickListener {
            val sharedPref = getSharedPreferences("sharedPref", MODE_PRIVATE)
            val nombre = sharedPref.getString("nombre","")
            val carrera = sharedPref.getString("carrera","")
            binding.edtNombre.setText(nombre)
            binding.edtCarrera.setText(carrera)
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
                val intent = Intent(this@SharedP, Estaciones::class.java)
                startActivity(intent)
            }
            R.id.mnuApi -> {
                val intent = Intent(this@SharedP, Api::class.java)
                startActivity(intent)
            }
            R.id.mnuA -> {
                val intent = Intent(this@SharedP, SharedP::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}