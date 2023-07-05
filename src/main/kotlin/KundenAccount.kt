class KundenAccount(val userName: String, var pin: String, var kontostand: Double) {
    var warenkorb: MutableList<Produkt> = mutableListOf()

    fun addToWarenkorb(produkt: Produkt) {
        warenkorb.add(produkt)
    }
    fun removeFromWarenkorb(produkt: Produkt) {
        warenkorb.remove(produkt)
    }
    fun getWarenkorbKosten(): Double {
        return warenkorb.sumOf { it.preis }
    }
    fun bewerteProdukt(produkt: Produkt, bewertung: String) {
        produkt.bewertung = bewertung
    }
}