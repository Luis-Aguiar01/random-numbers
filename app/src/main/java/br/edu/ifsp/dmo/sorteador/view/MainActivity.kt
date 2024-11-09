package br.edu.ifsp.dmo.sorteador.view

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.sorteador.R
import br.edu.ifsp.dmo.sorteador.databinding.ActivityMainBinding
import br.edu.ifsp.dmo.sorteador.model.Draw
import java.util.Locale

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
                     binding.inputEditText.text.toString().toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                draw = if (limit > 1)
                    Draw(limit)
                else
                    Draw()

                updateUI()
            }
            binding.generateButton -> {
                val number = draw.getNumber().toString().toInt()
                if (number != -1) {
                    binding.resultTextView.text = number.toString()
                } else {
                    Toast.makeText(
                        this,
                        "Todos os números já foram sorteados.",
                        Toast.LENGTH_SHORT).show()
                }

                updateListView()
            }
            binding.resetButton -> {
                draw.reset()
                Toast.makeText(
                    this,
                    "O sorteio foi reiniciado.",
                    Toast.LENGTH_SHORT).show()
                updateUI()
                updateListView()
            }
        }
    }

    private fun setClickListener() {
        binding.generateButton.setOnClickListener(this)
        binding.limitButton.setOnClickListener(this)
        binding.resetButton.setOnClickListener(this)
    }

    private fun updateUI() {
        val str = String.format(Locale.getDefault(),
            "Intervalo de %d à %d.", draw.getLowBorder(), draw.getHighBorder())
        binding.limitTextView.text = str
        binding.inputEditText.text.clear()
        binding.resultTextView.text = getString(R.string.result_edit_text)
        updateListView()
    }

    private fun updateListView() {
        binding.listView.adapter  = NumberAdapter(
            this,
            draw.getHistory()
        )
    }
}