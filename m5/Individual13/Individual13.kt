
/*
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.ceil
 */
/*
fun suma(num1:Double,num2:Float): Double {
    return num1+num2.toDouble()

}
fun redondeo(num3:Double):Double{

    return ceil(num3)
}

fun muestraresultado(num: Double){

    val formato= NumberFormat.getCurrencyInstance(Locale.UK)
    val pasadaamoneda=formato.format(num)
    println(pasadaamoneda)
}

fun main(){
    val num1=5.77
    val num2= 6.8F //para formato a double
    val numredondeado= 6.78
    val moneda=7.89

    val resultado=suma(num1,num2)
    println(resultado)

    val redondeado= redondeo(numredondeado)
    println(redondeado)


    muestraresultado(moneda)

}
 */
 /*
 data class SuperHeroList(val superhero:String,val publisher:String,val realName:String,var photo:String){
}


fun main(){
    val superheroes= mutableListOf<SuperHeroList>()

    while (true) {
        println("Ingrese el nombre del superhéroe o 'salir' para terminar:")
        //Algunas validaciones para salir
        val name = readLine()?.trim() ?: ""
        //ignonarmos mayuscula o minuscula, solo debe escribir salir
        if (name.equals("salir", true)) {
            break
        }

        println("Ingrese el publisher:")
        //quitamos los espacios
        val publisher = readLine()?.trim() ?: ""

        println("Ingrese el nombre real:")
        val realName = readLine()?.trim() ?: ""

        println("Ingrese la foto:")
        val photo = readLine()?.trim() ?: ""

        val superhero = SuperHeroList(name, publisher, realName, photo)
        superheroes.add(superhero)
    }

    println("\nSuperhéroes ingresados:")
    for (superhero in superheroes) {
        println("*************************")
        println("Nombre: ${superhero.superhero}")
        println("Publisher: ${superhero.publisher}")
        println("Nombre real: ${superhero.realName}")
        println("Foto: ${superhero.photo}")
        println("*************************")
    }
}
 */