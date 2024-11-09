package br.edu.ifsp.dmo.sorteador.model

class Draw(private val border: Int = 0) {
    private var strategy: SorteioStrategy
    private val history = HashSet<Int>()

    init {
        if (border == 0)
            strategy = DefaultLimit
        else
            strategy = DefinedLimit(border)
    }

    fun getNumber(): Int {
        var number: Int

        if (history.size != getHighBorder()) {
            do {
                number = strategy.nextNumber()
            } while (!history.add(number))
        } else {
            number = -1
        }

        return number
    }

    fun getHistory() = ArrayList(history)

    fun getLowBorder() = strategy.getLowBorder()

    fun getHighBorder() = strategy.getHighBorder()

    fun reset() = history.clear()
}