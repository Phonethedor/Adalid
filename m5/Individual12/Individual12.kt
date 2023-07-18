class Usuario(var nombre: String, var apellido: String, var edad: Int, var correo: String, var salud: String){
    fun ingresardatos(){
        do {
            println("Ingrese nombre")
            nombre = readLine().toString()

            if (nombre.isNullOrBlank()){
                println("Debe ingresar un nombre")
            }else if (nombre.length>20){
                println("El nombre no puede tener mas de 20 caracteres")
            }else if(!nombre.matches(Regex("[a-zA-Z]+"))){
                println("El nombre solo puede llevar letras")
            }
        } while (nombre.isNullOrBlank() || nombre.length>20 || !nombre.matches(Regex("[a-zA-Z]+")))

        do {
            println("Ingrese apellido")
            apellido = readLine().toString()
            if (apellido.isNullOrBlank()){
                println("Debe ingresar un apellido")
            }else if (!apellido.matches(Regex("[a-zA-Z]+")))
                println("el apellido solo puede llevar letras")
        }while (apellido.isNullOrBlank()|| !apellido.matches(Regex("[a-zA-Z]+")))

        do {
            println("Ingrese edad")
            val edadingresada= readLine()
            edad= if (edadingresada.isNullOrBlank()){
                -1
            }else{
                if (edadingresada.toIntOrNull() !=null){
                    edadingresada.toInt()
                }else{
                    -1
                }

            }
        }while (edad<0)


        do {
            println("Ingrese correo")
            correo = readLine().toString()
            if (correo.isNullOrBlank()){
                println("Debe ingresar un correo")
            }else if (correo.matches(Regex("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")))
                println("Ingrese un correo válido")

        }while(correo.isNullOrBlank()|| !correo.matches(Regex("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")))


        do {
            println("Ingrese Sisteme de salud: 1 Fonasa, 2 Isapre, 3 particular ")
            salud = readLine().toString()
            salud= when (salud){
                "1" -> "Fonasa"
                "2" -> "ISapre"
                "3" -> "Particular"
                else ->""
            }
        }while (salud.isNullOrBlank())





    }
}

fun cantidad(): Int? {
    println("Ingrese cantidad de usuarios a ingresar")
    val numusers= readLine()?.toIntOrNull()
    return numusers

}

fun mostrardatos(usuarios: List<Usuario>){
    println("La cantidad de usuarios ingresada es ${usuarios.size}")
    for (usuario in usuarios) {
        println("************************")
        println("Nombre: ${usuario.nombre}")
        println("Apellido: ${usuario.apellido}")
        println("Edad: ${usuario.edad}")
        println("Correo: ${usuario.correo}")
        println("Sistema de salud: ${usuario.salud}")
        println("************************")

    }

}
fun main(){
    val cantidaddeusuarios= cantidad()
    if (cantidaddeusuarios !=null){
        val usuarios= mutableListOf<Usuario>()

        for (i in 1..cantidaddeusuarios){
            val usuario=Usuario("","",0,"","")
            usuario.ingresardatos()
            usuarios.add(usuario)
        }
        mostrardatos(usuarios)
    } else{
        println("Cantidad ingresada no es válida")
    }



    }