package br.edu.ifsp.dmo.sorteador.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.edu.ifsp.dmo.sorteador.R

class NumberAdapter(context: Context, dataset: List<Int>)
    : ArrayAdapter<Int>(context, R.layout.number_list_item, dataset) {

    private var nextPosition = 1;

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView

        if (itemView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.number_list_item, null)
        }

        val number: Int? = getItem(position)

        if (itemView != null && number != null) {
            itemView.findViewById<TextView>(R.id.number).text = number.toString()
            itemView.findViewById<TextView>(R.id.result_textView).text = nextPosition.toString()
            nextPosition++
        }

        return itemView!!
    }
}