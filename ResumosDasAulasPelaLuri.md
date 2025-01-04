# Boas Vindas

Olá, estudante! Que bom te ver por aqui!Essa aula introdutória do curso "Kotlin: desenvolvendo sua primeira aplicação" apresenta o projeto AluGames, uma plataforma de aluguel de jogos que será desenvolvida ao longo do curso.  O foco será no desenvolvimento do back-end, utilizando a linguagem Kotlin.

 Aprenderemos a consumir dados externos de uma API, aplicar conceitos de Orientação a Objetos, tratar exceções, usar bibliotecas externas e aplicar boas práticas de Kotlin.  O curso é indicado para quem já possui conhecimento em lógica de programação, orientação a objetos e tem familiaridade com a formação Java da Alura.  A ideia é que você possa expandir o projeto AluGames ao longo do curso, adicionando funcionalidades e aprendendo Kotlin na prática!  Ficou alguma dúvida sobre o que veremos no curso?  Pergunte à vontade! 

## Iniciando o Projeto 

Oi, tudo bem?  Que bom que você quer fazer um resumo da aula! Essa aula foi incrível, né?  Nela, aprendemos a dar os primeiros passos no desenvolvimento de um aplicativo Kotlin que busca informações de jogos usando a API CheapShark.Primeiro, conhecemos o conceito de MVP (Produto Mínimo Viável), começando com uma funcionalidade simples: uma busca de jogos.  Em vez de criarmos um banco de dados próprio, usaremos uma API externa, a CheapShark, que já possui os dados que precisamos.

Usamos o Postman para testar a API e entender como ela funciona, visualizando a resposta JSON do endpoint que retorna informações de um jogo específico usando seu ID.  Aprendemos a fazer requisições GET e a importância de ferramentas como o Postman para facilitar o trabalho com APIs.

Depois, criamos nosso projeto no IntelliJ IDEA, usando Kotlin como linguagem e Maven como sistema de build.  Vimos a estrutura básica do projeto, incluindo as pastas src (para o código), test (para testes) e o arquivo pom.xml (para gerenciar dependências).  Finalmente, executamos nosso primeiro código Kotlin, um simples "Hello World!", para testar a configuração do ambiente.


[API ~ CheapShark](https://www.cheapshark.com/)


## Buscando dados da API

Oi, tudo bem? Essa aula foi incrível, né? Aprendemos a consumir uma API de jogos usando Kotlin, aproveitando a interoperabilidade com Java. Começamos com código Java, que a IDE converteu automaticamente para Kotlin. Usamos HttpClient, HttpRequest, e HttpResponse para fazer a requisição e receber a resposta da API https://www.cheapshark.com/api/1.0/games?id=146.

Precisamos importar as classes necessárias e lidar com algumas configurações de versão do JDK. No final, imprimimos a resposta da API (em JSON) no console, mostrando informações do jogo. Foi um processo bem legal que envolveu a utilização da documentação Java e a conversão automática de código Java para Kotlin pelo IntelliJ IDEA. Agora, no próximo passo, vamos modelar a aplicação para usar apenas as informações relevantes da API.

Existem várias maneiras de consumir uma API externa numa aplicação Kotlin, como a utilização de bibliotecas como a [Retrofit](https://square.github.io/retrofit/) ou a [OkHttp](https://square.github.io/okhttp/).



Mas, durante esse curso, utilizamos a HTTP Client, uma biblioteca do Java 11 que permite que façamos esse fluxo de consumo sem precisar instalar nada externo ao nosso projeto.

Você pode acessar a documentação que utilizamos durante o curso, abaixo:

[Documentação HttpRequest](https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpRequest.html)

[Documentação HttpResponse](https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpResponse.html)


E para entender melhor como funciona o protocolo HTTP e seus detalhes de utilização, você pode conferir o curso [HTTP: entendendo a web por baixo dos panos.](https://cursos.alura.com.br/course/http-entendendo-web-por-baixo-dos-panos)



# Modelando a Aplicação

## Criando a classe Jogo

Olá, estudante!  Que bom te ver por aqui! Essa aula foi incrível, né?  Aprendemos bastante sobre como modelar uma aplicação em Kotlin, usando o exemplo de um catálogo de jogos.  Vimos a diferença crucial entre arquivos e classes em Kotlin: arquivos podem conter código sem necessariamente serem classes, enquanto classes são fundamentais para a programação orientada a objetos.

Criamos a classe Jogo, com atributos como titulo, capa e descricao, aprendendo a diferença entre var (variáveis mutáveis) e val (variáveis imutáveis).  Uma dica importante:  é uma boa prática começar usando val e só mudar para var se realmente precisar alterar o valor depois da inicialização.

Também descobrimos que, ao contrário do Java, em Kotlin não precisamos especificar explicitamente o tipo de variável em muitas situações, pois o compilador consegue inferir o tipo com base no valor atribuído.  Vimos como inicializar variáveis em Kotlin (diferente do Java, onde isso não é obrigatório).

Por fim, praticamos a sobrescrita do método toString() para controlar como os objetos da classe Jogo são representados quando usamos println(), aprendendo a usar interpolação de strings para facilitar a leitura do código e evitar a concatenação com o operador +.  E, claro, aprendemos que ponto e vírgula (;) é opcional em Kotlin!

Ficou alguma dúvida específica sobre algum desses pontos?  Podemos revisar o que quiser!  Qual parte te deixou mais curioso(a)?  Vamos praticar um pouco mais?


## Construindo um novo Jogo

Oi, tudo bem? Nesta aula, aprendemos sobre construtores em Kotlin, utilizando a classe Jogo como exemplo. Inicialmente, criamos um construtor primário que recebe o título e a capa do jogo como parâmetros obrigatórios, declarados como val para garantir a imutabilidade após a criação do objeto. Vimos como passar esses parâmetros na instância da classe, tanto na ordem definida no construtor, quanto fora de ordem, especificando o nome de cada parâmetro. A aula também destaca a ajuda da IDE (IntelliJ) na hora de escrever o código, mostrando dicas (inlay hints) que podem ser desabilitadas se necessário. Por fim, foi mostrado como o método toString() facilita a visualização dos dados do objeto. A próxima etapa será integrar dados de uma API para alimentar a classe Jogo.


## Desserializando dados do JSON

Olá, estudante! Que bom te ver por aqui! Nesta aula, aprendemos a desserializar dados JSON de uma API usando a biblioteca Gson no Kotlin. Primeiro, adicionamos a dependência do Gson ao nosso projeto pom.xml via Maven, simplificando o processo comparado ao método manual de adicionar JARs como em Java. Depois, instanciamos o Gson em nosso código Kotlin.

Inicialmente, tentamos desserializar diretamente para nossa classe Jogo, mas isso falhou porque os nomes dos campos no JSON (title e thumb) diferiam dos nomes em nossa classe (titulo e capa). Para resolver isso, usamos a anotação @SerializedName na classe Jogo para mapear os nomes dos campos.

Mesmo assim, a desserialização ainda falhou porque o JSON tinha uma estrutura aninhada: os dados do jogo estavam dentro de um objeto info. Para solucionar, criamos uma nova classe InfoJogo para representar esse objeto info, e então desserializamos o JSON para InfoJogo antes de acessar os dados do jogo. Finalmente, conseguimos extrair os dados do JSON para o nosso jogo, mostrando o título e a capa. Por fim, a instrutora Jacqueline mencionou a importância de considerar alternativas à utilização de nomes fixos na anotação @SerializedName para evitar problemas futuros.

Gostaria de praticar? Que tal criar um exemplo com uma estrutura JSON diferente e uma classe correspondente em Kotlin? Pense em um cenário com mais atributos e diferentes tipos de dados (inteiros, booleanos, etc.). Vamos praticar a utilização do @SerializedName e a criação de classes intermediárias para lidar com estruturas aninhadas! Qualquer dúvida, pode me perguntar!

## Conhecendo as data classes


Nesta aula, aprendemos a usar data classes em Kotlin para melhorar a organização e a manutenção do código, especialmente quando lidamos com dados de APIs externas. Criamos uma data class (InfoApiShark) para representar os dados brutos de uma API específica, separando-a da nossa classe principal (Jogo). Isso torna o código mais flexível, pois podemos facilmente trocar de API sem modificar a estrutura principal. A classe InfoJogo atua como um intermediário, recebendo os dados de InfoApiShark e os passando para a classe Jogo. Por fim, refatoramos as classes Jogo e InfoJogo para também se tornarem data classes, aproveitando os benefícios da imutabilidade e dos métodos embutidos, como o toString(). Aprendemos também a importância de usar uma hierarquia de acesso aos dados, representada pela notação de ponto (.), para navegar pelas diferentes classes e acessar as informações desejadas.

**EXPLICAÇÃO**

A classe Jogo sem Data Classes: Inicialmente, você construiu sua casa de Lego de forma um pouco desorganizada. Cada tijolo (atributo) está conectado diretamente à estrutura principal, e você usou adesivos com os nomes "title" e "thumb" ( @SerializedName) colados diretamente nos tijolos. Se você precisar mudar a fonte dos tijolos (mudar de API), precisa desmontar toda a casa e colar novos adesivos, o que é trabalhoso e propenso a erros.

A classe InfoApiShark como uma caixa de Lego: Agora, você usa uma caixa para organizar os tijolos que vêm de um fornecedor específico (a API CheapShark). Essa caixa é a nossa data class InfoApiShark. Ela tem etiquetas claras "title" e "thumb" impressas na própria caixa, e não adesivos soltos. Se você precisar mudar de fornecedor, basta usar uma caixa nova com etiquetas diferentes, sem precisar mexer nos tijolos da casa principal.

A classe InfoJogo como um adaptador: Imagine um adaptador que conecta a caixa de Lego ( InfoApiShark) à sua casa principal ( Jogo). Ele pega os tijolos da caixa e os encaixa corretamente na estrutura da casa. Assim, a casa principal não precisa saber de onde os tijolos vieram, apenas que eles se encaixam perfeitamente.

A classe Jogo como Data Class: Depois de entender a importância da organização, você decide construir a casa principal ( Jogo) usando tijolos especiais que já vêm com encaixes perfeitos e etiquetas impressas. Esses tijolos especiais são as data classes. Eles são mais eficientes e fáceis de usar, e você não precisa mais se preocupar com adesivos soltos.

A hierarquia de pontos (.) Pense em uma escada. Para chegar ao topo (a informação desejada), você precisa subir degrau por degrau (meuInfoJogo.info.title). Cada ponto (.) representa um degrau, e você precisa percorrer todos para alcançar o seu objetivo.

Em resumo, as data classes no Kotlin são como tijolos de Lego especiais que facilitam a construção e a organização do seu código, tornando-o mais eficiente, limpo e fácil de manter. Usar data classes para representar dados de APIs é como usar caixas organizadas para separar os componentes, facilitando a troca de fornecedores (APIs) sem precisar reconstruir todo o projeto.

Agora, que tal tentar criar um exemplo de uma data class para representar um produto de uma loja online, com atributos como nome, preço e descrição? Pense em quais atributos seriam importantes e como você organizaria as informações. Lembre-se de usar val para os atributos, pois data classes são imutáveis. Depois, tente criar uma classe que utilize essa data class para representar um carrinho de compras. Qual seria a melhor forma de fazer isso?

[Kotlin Docs - Data Classes](https://kotlinlang.org/docs/data-classes.html)
