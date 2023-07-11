import java.util.*

enum class PaymentMethod { //Gordon Lucas 10.07.2023
    CREDIT_CARD {
        override fun makePayment(amount: Double): Boolean {
            println("Sie haben mit Kreditkarte $amount bezahlt.")
            return true
        }
    },
    PAYPAL {
        override fun makePayment(amount: Double): Boolean {
            println("Sie haben mit PayPal $amount bezahlt.")
            return true
        }
    };

    abstract fun makePayment(amount: Double): Boolean
}