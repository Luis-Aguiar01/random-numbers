package br.edu.ifsp.dmo.sorteador.view

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.sorteador.databinding.ActivityMainBinding
import br.edu.ifsp.dmo.sorteador.model.Draw

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var draw = Draw()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListener()
    }

    override fun onClick(view: View) {
        when (view) {
            binding.limitButton -> {
                val limit: Int = try {
                     binding.limitTextView.toString().toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                draw = if (limit > 1)
                    Draw(limit)
                else
                    Draw()
            }
            binding.generateButton -> {
                binding.resultTextView.text = draw.getNumber().toString()
            }
        }
    }

    private fun setClickListener() {
        binding.generateButton.setOnClickListener(this)
        binding.generateButton.setOnClickListener(this)
    }
}