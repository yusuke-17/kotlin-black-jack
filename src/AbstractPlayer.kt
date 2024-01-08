abstract class AbstractPlayer(val name: String) {
    companion object {
        const val BUST_POINT = 21
    }

    private val cardList: MutableList<Card> = mutableListOf()

    var isBust: Boolean = false

    private fun addCardList(card: Card) {
        cardList.add(card)
    }

    fun calcScore(): Int {
        // カードリストから、ポイントが1より大きいカードを抽出し、そのポイントの合計を計算
        val score = cardList.filter { card -> card.getPoint() > 1 }.sumOf { card -> card.getPoint() }
        // カードリストから、ポイントが1のカード（エース）の数を数える
        val aceCardCount = cardList.count { card -> card.getPoint() == 1}
        // エースの数によって境界となるスコアを計算
        val borderScore = 11 - aceCardCount

        // エースがない場合は計算したスコアを返す
        // エースがある場合は、計算したスコアが境界を超えるかどうかで追加ポイントを考慮してスコアを返す
        return if (aceCardCount == 0) {
            score
        } else if (score > borderScore) {
            score + 1
        } else {
            score + 10 + aceCardCount
        }
    }

    fun draw(deck: Deck) {
        draw(deck, false)
    }

    /**
     * 山札からカードを引く
     *
     * @param deck     山札
     * @param isHidden 引いたカードをを隠すか
     */
    fun draw(deck: Deck, isHidden: Boolean) {
        val card = deck.draw()
        addCardList(card)
        if (calcScore() > BUST_POINT) isBust = true
        val msg = if (isHidden) {
            "$name の引いたカードはわかりません。"
        }else {
            "$name の引いたカードは ${card.toString()} です。"
        }
        println(msg)
    }

    /**
     * 初期手札の作成
     *
     * @param deck 山札
     */
    abstract fun initCardList(deck: Deck)

    /**
     * 山札からカードを引く
     *
     * @param deck 山札
     */
    abstract fun drawCard(deck: Deck)
}