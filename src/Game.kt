class Game {
    /**
     * ゲーム開始
     */
    fun start() {
        println("ブラックジャックにようこそ！\n")
        println("ゲームを開始します。\n")

        val deck = Deck()
        val user: AbstractPlayer = User("あなた")
        val dealer: AbstractPlayer = Dealer("ディーラー")

        user.initCardList(deck)
        dealer.initCardList(deck)

        user.drawCard(deck)
        if (!user.isBust) dealer.drawCard(deck)

        printGameResult(user, dealer)

        println("\nブラックジャック終了！また遊んでね★")
    }

    /**
     * ゲームの結果を表示
     * @param player1 プレイヤー1
     * @param player2 プレイヤー2
     */
    private fun printGameResult(player1: AbstractPlayer, player2: AbstractPlayer) {
        when {
            player1.calcScore() == player2.calcScore() -> println("引き分けです。")
            !player1.isBust && (player2.isBust || player1.calcScore() > player2.calcScore()) -> {
                println("${player1.name}の勝ちです！")
            }
            else -> println("${player2.name}の勝ちです！")
        }
    }
}