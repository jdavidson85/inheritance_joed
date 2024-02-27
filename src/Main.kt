open class Customer(val name: String, val phone: String, val address: String, val squareFootage: Int)

class Commercial(name: String, phone: String, address: String, squareFootage: Int, val propertyName: String, val multiProperty: Boolean) : Customer(name, phone, address, squareFootage) {
    fun calculateWeeklyCharges(): Double {
        val rate = 5.0
        var totalCharge = squareFootage / 1000 * rate
        if (multiProperty) {
            totalCharge *= 0.9
        }
        return totalCharge
    }
}

class Residential(name: String, phone: String, address: String, squareFootage: Int, val senior: Boolean) : Customer(name, phone, address, squareFootage) {
    fun calculateWeeklyCharges(): Double {
        val rate = 6.0
        var totalCharge = squareFootage / 1000 * rate
        if (senior) {
            totalCharge *= 0.85
        }
        return totalCharge
    }
}

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

                val commercialCustomer = Commercial(name, phone, address, squareFootage, propertyName, multiProperty)
                val weeklyCharge = commercialCustomer.calculateWeeklyCharges()
                println("Commercial Customer Information: \"$name\", \"$phone\", \"$address\", \"$squareFootage sqft\", \"$propertyName\"")
                println("Weekly Charge: $weeklyCharge")
            }
        }
    } while (choice != 3)
}