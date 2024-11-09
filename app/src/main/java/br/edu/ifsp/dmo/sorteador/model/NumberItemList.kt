package br.edu.ifsp.dmo.sorteador.model

class NumberItemList(
    val number: Int,
    val position: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NumberItemList

        return number == other.number
    }

    override fun hashCode(): Int {
        return number
    }
}