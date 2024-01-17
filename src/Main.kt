import java.io.File

data class Usuario(
    var nome: String,
    var email: String,
    var idade: Int,
    var altura: String
)
fun main() {
    while (true) {
        println("Menu Principal:")
        println("1 - Cadastrar o usuário")
        println("2 - Listar todos usuários cadastrados")
        println("3 - Cadastrar nova pergunta no formulário")
        println("4 - Deletar pergunta do formulário")
        println("5 - Pesquisar usuário por nome ou idade ou email")
        println("Escolha uma opção:")

        val escolha = readLine()?.toInt()

        when (escolha) {
            1 -> cadastrarUsuario()
            2 -> listarUsuarios()
            3 -> println("Opção 3 selecionada")
            4 -> println("Opção 4 selecionada")
            5 -> println("Opção 5 selecionada")
            else -> println("Escolha inválida")
        }
    }
}
fun cadastrarUsuario() {
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

    val nomeArquivo = "cadastrados/${usuario.nome}.txt"
    val conteudo = "${usuario.nome}\n${usuario.email}\n${usuario.idade}\n${usuario.altura}"

    File(nomeArquivo).writeText(conteudo)

    println("Informações do usuario salvas em $nomeArquivo")
}

fun listarUsuarios() {
    val diretorio = File("cadastrados")
    val arquivos = diretorio.listFiles()

    arquivos?.forEachIndexed() { index, arquivo ->
        val nome = arquivo.nameWithoutExtension
        println("${index + 1} - $nome")
    }
}