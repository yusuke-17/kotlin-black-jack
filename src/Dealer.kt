class Dealer(name: String) : AbstractPlayer(name) {
    override fun initCardList(deck: Deck) {
        draw(deck)
        draw(deck, true)
    }

    override fun drawCard(deck: Deck) {
        println("$name の現在の得点は${calcScore()}点です。\n")
        while (calcScore() < 17) {
            draw(deck)
            println("$name の現在の得点は${calcScore()}点です。\n")
        }
    }
}