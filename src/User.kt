class User(name: String) : AbstractPlayer(name) {
    override fun initCardList(deck: Deck) {
        draw(deck)
        draw(deck)
    }

    override fun drawCard(deck: Deck) {
        println("${name}の現在の得点は${calcScore()}点です。\n")
        var line: String? = null
        while (!isBust && line != "N") {
            println("カードを引きますか？引く場合はYを引かない場合はNを入力してください。")
            line = readLine()
            when {
                line == "Y" -> {
                    draw(deck)
                    println("$name の現在の得点は${calcScore()}点です。\n")
                }
                line != "N" -> {
                    println("Y/N以外が入力されました。")
                }
            }
        }
    }
}