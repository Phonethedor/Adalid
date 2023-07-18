package com.example.individual8

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.individual8.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.add.setOnClickListener(View.OnClickListener {
            if (!validate()) {
                val resultado = binding!!.et1.text.toString().trim { it <= ' ' }
                    .toInt() + binding!!.et2.text.toString().trim { it <= ' ' }.toInt()
                binding!!.result.text = Integer.toString(resultado)
            } else {
                Toast.makeText(this@MainActivity, "Incorrect Numbers", Toast.LENGTH_LONG).show()
            }
        })
        binding!!.subtract.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (!validate()) {
                    val resultado = binding!!.et1.text.toString().trim { it <= ' ' }
                        .toInt() - binding!!.et2.text.toString().trim { it <= ' ' }.toInt()
                    binding!!.result.text = Integer.toString(resultado)
                } else {
                    Toast.makeText(this@MainActivity, "Incorrect Numbers", Toast.LENGTH_LONG).show()
                }
            }
        })
        binding!!.divide.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (validate()) {
                    Toast.makeText(this@MainActivity, "Incorrect Numbers", Toast.LENGTH_LONG).show()
                } else if (binding!!.et2.text.toString().trim { it <= ' ' }.toInt() == 0) {
                    Toast.makeText(
                        this@MainActivity,
                        "It is impossible to divide by 0",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    val resultado = binding!!.et1.text.toString().trim { it <= ' ' }
                        .toInt() / binding!!.et2.text.toString().trim { it <= ' ' }.toInt()
                    binding!!.result.text = Integer.toString(resultado)
                }
            }
        })
        binding!!.multiply.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (!validate()) {
                    val resultado = binding!!.et1.text.toString().trim { it <= ' ' }
                        .toInt() * binding!!.et2.text.toString().trim { it <= ' ' }.toInt()
                    binding!!.result.text = Integer.toString(resultado)
                } else {
                    Toast.makeText(this@MainActivity, "Incorrect Numbers", Toast.LENGTH_LONG).show()
                }
            }
        })
        binding!!.exit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                finish()
            }
        })
    }

    fun validate(): Boolean {
        var error = false
        if (binding!!.et1.text.toString().trim { it <= ' ' }
                .isEmpty() || binding!!.et2.text.toString().trim { it <= ' ' }
                .isEmpty()) {
            error = true
        }
        return error
    }
}