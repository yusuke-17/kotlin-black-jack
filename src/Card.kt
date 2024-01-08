class Card(val suit: Suit, val rank: Int) {
    private fun displayValue(): String {
        return when (rank) {
            1 -> "A"
            11 -> "J"
            12 -> "Q"
            13 -> "K"
            else -> rank.toString()
        }
    }

    fun getPoint(): Int {
        return if (rank > 10) 10 else rank
    }

    override fun toString(): String {
        return "${suit.mark}の${displayValue()}"
    }
}