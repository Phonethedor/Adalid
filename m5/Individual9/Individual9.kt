fun main(){

    println("Ingrese una temperatura")

    val temperatura= readLine()?.toFloatOrNull()

    if (temperatura !=null){
        println("Ingrese la unidad de medida c para celsius, f para Fahrenheit y k para kelvin")
        val eleccion = readLine()



    println("Ingreso $temperatura grados")

    when (eleccion) {
        "c" -> {
            println("Ingreso $temperatura grados Celsius")
            val celsiustofar = temperatura * 9 / 5 + 32
            println("Son $celsiustofar grados Fahrenheit")
            val fartokelvin = (temperatura + 273.15).toFloat()
            println("Son $fartokelvin grados Kelvin")
        }
        "f" -> {
            println("Ingreso $temperatura grados Fahrenheit")
            val fartokelvin = (temperatura - 32) * 5 / 9 + 273.15
            println("Son $fartokelvin grados Kelvin")
            val kelvintocelsius = fartokelvin - 273.15
            println("Son $kelvintocelsius grados Celsius")
        }
        "k" -> {
            println("Ingreso $temperatura grados Kelvin")
            val kelvintocelsius = temperatura - 273.15
            println("Son $kelvintocelsius grados Celsius")
            val celsiustofar = kelvintocelsius * 9 / 5 + 32
            println("Son $celsiustofar grados Fahrenheit")
        }
        else -> {
            println("Unidad de medida no válida")
        }
    }
    } else {
        println("Temperatura no válida")
    }
}
