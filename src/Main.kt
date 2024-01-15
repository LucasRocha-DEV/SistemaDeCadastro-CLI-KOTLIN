import java.io.File

fun main() {
    val arquivo = File("formulario.txt")

    arquivo.forEachLine { linha ->
        println(linha)
    }
}