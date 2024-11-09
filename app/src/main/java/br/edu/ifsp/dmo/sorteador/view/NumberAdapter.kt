package br.edu.ifsp.dmo.sorteador.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.edu.ifsp.dmo.sorteador.R
import br.edu.ifsp.dmo.sorteador.model.NumberItemList
import java.util.Locale

class NumberAdapter(context: Context, dataset: List<NumberItemList>)
    : ArrayAdapter<NumberItemList>(context, R.layout.number_list_item, dataset) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView

        if (itemView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.number_list_item, null)
        }

        val number: NumberItemList? = getItem(position)

        if (itemView != null && number != null) {
            itemView.findViewById<TextView>(R.id.number).text = number.number.toString()
            itemView.findViewById<TextView>(R.id.number_position).text =
                String.format(Locale.getDefault(),"%dº:", number.position)
        }

        return itemView!!
    }
}