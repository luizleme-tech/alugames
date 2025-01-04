## Boas Vindas

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