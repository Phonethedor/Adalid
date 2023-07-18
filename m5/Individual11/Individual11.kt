/Ejercicio A
/*fun main(){
    var numero1=10
    val numero2=33
    val numero3=66
    var suma=numero1+numero2+numero3
    println(suma)
    numero1=55
    println(suma)
    var promedio= listOf(numero1,numero2,numero3).average()
    println("El promedio es $promedio")
}*/

//Ejercicio B

/*
fun main(){
    operaciones()
}
fun operaciones(){
    var numero1=10
    val numero2=33
    val numero3=66
    var suma=numero1+numero2+numero3
    println(suma)
    numero1=55
    suma=numero1+numero2+numero3
    println("La suma de los numeros es $suma")
    var promedio= listOf(numero1,numero2,numero3).average()
    println("El promedio es $promedio")
}
*/

//Ejercicio C

/*
fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    amanda.showProfile()
    atiqah.showProfile()
}
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
    println("Nombre: $name")
        println("Edad: $age")
        println("Le gusta: $hobby")
        if (referrer==null){
            println("No le han referido")
        }else{
            println("Fue referido por ${referrer.name}")
        }
    }
}
*/

//Ejercicio D:

fun main() {
    val winningBid = Bid(5000, "Private Collector")
    println("Item A is sold at ${auctionPrice(winningBid, 2000)} to ${winningBid.bidder}")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {

    if (bid != null && bid.amount >= minimumPrice) {
        return bid.amount
    } else {
        return minimumPrice
    }
}