package mx.edu.utez.ordinariobetja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.androidgamesdk.gametextinput.Listener
import mx.edu.utez.ordinariobetja.databinding.ActivityApiBinding
import mx.edu.utez.ordinariobetja.databinding.ActivityEstacionesBinding
import okhttp3.Response
import org.json.JSONArray

class Api : AppCompatActivity() {
    lateinit var  queue: RequestQueue
    lateinit var binding: ActivityApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        queue = Volley.newRequestQueue(this@Api)
        val url = "https://jsonplaceholder.typicode.com/posts"

        val listener = com.android.volley.Response.Listener<JSONArray>{ response ->
            Log.e("RESTLIBS", response.toString())

            var lista = mutableListOf<String>()
            for(i in 0 .. response.length()-1){
                lista.add(response.getJSONObject(i).getString("title") + "\n" +
                        response.getJSONObject(i).getString("body"))
            }

            val adaptador = ArrayAdapter(this@Api, android.R.layout.simple_list_item_1, lista)
            binding.lvlista.adapter = adaptador

        }
        val error = com.android.volley.Response.ErrorListener { error ->
            Log.e("RESTLIBS", error.message!!)
        }
        val request = JsonArrayRequest(
            com.android.volley.Request.Method.GET,
            url,
            null,
            listener,
            error
        )
        queue.add(request)


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //redirection with menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnuE -> {
                val intent = Intent(this@Api, Estaciones::class.java)
                startActivity(intent)
            }
            R.id.mnuApi -> {
                val intent = Intent(this@Api, Api::class.java)
                startActivity(intent)
            }
            R.id.mnuA -> {
                val intent = Intent(this@Api, SharedP::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}