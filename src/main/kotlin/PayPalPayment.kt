import java.util.Random

class PayPalPayment: PaymentMethod() {
    override fun makePayment(amount: Double): Boolean {
        val random = Random()
        val isPaymentSuccessful = random.nextBoolean()
        if (isPaymentSuccessful) {
            println("Sie haben mit PayPal $amount bezahlt.")
        } else {
            println("Fehler beim bezahlen mit PayPal.")
        }
        return isPaymentSuccessful
    }
}