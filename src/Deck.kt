import java.util.*
import java.util.stream.IntStream

class Deck {
    private val cards: MutableList<Card>

    init {
        cards = Arrays.stream(Suit.values())
            .flatMap { s -> IntStream.rangeClosed(1, 13).mapToObj{ i -> Card(s, i) } }
            .toList().toMutableList()
        cards.shuffle()
    }

    fun draw(): Card {
        val card = cards[0]
        cards.removeFirst()
        return card
    }
}