/**
 * Represents a Customer with basic information.
 * @author Joseph Davidson
 * @property name The name of the customer.
 * @property phone The phone number of the customer.
 * @property address The address of the customer.
 * @property squareFootage The square footage of the property.
 */
open class Customer(val name: String, val phone: String, val address: String, val squareFootage: Int)

/**
 * Represents a Commercial Customer that extends.
 * @property propertyName The name of the commercial property.
 * @property multiProperty Indicates if the customer has multiple properties.
 */
class Commercial(name: String, phone: String, address: String, squareFootage: Int, val propertyName: String, val multiProperty: Boolean) : Customer(name, phone, address, squareFootage) {
// Calculate the weekly charge for the commercial customer.
    fun calculateWeeklyCharges(): Double {
        val rate = 5.0
        var totalCharge = squareFootage / 1000 * rate
        if (multiProperty) {
            totalCharge *= 0.9
        }
        return totalCharge
    }
}

/**
 * Represents a Residential Customer that extends.
 * val senior will determine if there will be a discount.
 */
class Residential(name: String, phone: String, address: String, squareFootage: Int, val senior: Boolean) : Customer(name, phone, address, squareFootage) {
// Calculate the weekly charge for the residential customer.
    fun calculateWeeklyCharges(): Double {
        val rate = 6.0
        var totalCharge = squareFootage / 1000 * rate
        if (senior) {
            totalCharge *= 0.85
        }
        return totalCharge
    }
}
/**
 * Main class to interact with the user and customer information.
 */
fun main() {
    var choice: Int
    do {
        println("Menu:")
        println("1. Residential Customer")
        println("2. Commercial Customer")
        println("3. Done")
        print("Enter your choice: ")
        choice = readLine()!!.toInt()

        when (choice) {
    // Command fields for residential
            1 -> {
                print("Enter customer name: ")
                val name = readLine()!!
                print("Enter customer phone: ")
                val phone = readLine()!!
                print("Enter customer address: ")
                val address = readLine()!!
                print("Enter square footage: ")
                val squareFootage = readLine()!!.toInt()
                print("Is the customer a senior (true/false): ")
                val senior = readLine()!!.toBoolean()

                val residentialCustomer = Residential(name, phone, address, squareFootage, senior)
                val weeklyCharge = residentialCustomer.calculateWeeklyCharges()
                println("Residential Customer Information: \"$name\", \"$phone\", \"$address\", \"$squareFootage\" sqft")
                println("Weekly Charge: $$weeklyCharge")
            }
         // Command fields for commercial
            2 -> {
                print("Enter customer name: ")
                val name = readLine()!!
                print("Enter customer phone: ")
                val phone = readLine()!!
                print("Enter customer address: ")
                val address = readLine()!!
                print("Enter square footage: ")
                val squareFootage = readLine()!!.toInt()
                print("Enter property name: ")
                val propertyName = readLine()!!
                print("Does the customer have multiple properties (true/false): ")
                val multiProperty = readLine()!!.toBoolean()
        // Information will be displayed in quotes 
                val commercialCustomer = Commercial(name, phone, address, squareFootage, propertyName, multiProperty)
                val weeklyCharge = commercialCustomer.calculateWeeklyCharges()
                println("Commercial Customer Information: \"$name\", \"$phone\", \"$address\", \"$squareFootage sqft\", \"$propertyName\"")
                println("Weekly Charge: $weeklyCharge")
            }
        }
// This will end the program
    } while (choice != 3)
}
