import java.io.File

data class Usuario(
    var nome: String,
    var email: String,
    var idade: Int,
    var altura: String
)
fun main() {
    val arquivo = File("formulario.txt")
    val respostas = mutableListOf<String>()

    arquivo.forEachLine { pergunta ->
        println(pergunta)
        val resposta = readLine()
        respostas.add(resposta ?: "")
    }

    val usuario = Usuario(
        nome = respostas[0],
        email = respostas[1],
        idade = respostas[2].toInt(),
        altura = respostas[3].toString()
    )

    val nomeArquivo = "${usuario.nome}.txt"
    val conteudo = "${usuario.nome}\n${usuario.email}\n${usuario.idade}\n${usuario.altura}"

    File(nomeArquivo).writeText(conteudo)

    println("Informações do usuario salvas em $nomeArquivo")
}