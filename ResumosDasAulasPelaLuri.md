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


# Tratamento de Erros e Refatoração

## Lendo o id do jogo para ser buscado

Imagine que nossa API de jogos é como uma gigantesca biblioteca. Cada jogo é um livro, e cada livro tem um código único (o ID) na sua capa. Antes, nós só tínhamos o código do Batman (146) e só conseguíamos pegar esse livro específico. Era como ter uma chave que só abria uma porta específica.

O Scanner é como um atendente da biblioteca. Ele nos permite perguntar ao usuário qual o código do livro que ele quer ("Digite um código de jogo para buscar:"). O usuário digita o código (o ID do jogo), e o atendente (o Scanner) anota esse código.

A variável busca é um papelzinho onde o atendente anota o código que o usuário pediu. Antes, tínhamos escrito "146" diretamente no papelzinho. Agora, o atendente escreve o que o usuário falar.

A URL da API, https://www.cheapshark.com/api/1.0/games?id=146, é o endereço da biblioteca. O id=146 é como um guia para o atendente encontrar o livro específico. Antes, o guia sempre apontava para o Batman. Agora, o guia aponta para o livro que o usuário pediu, graças à interpolação de string, que é como se a gente pegasse o papelzinho com o código ($busca) e colasse ele no endereço da biblioteca.

Então, agora, o atendente (Scanner) pergunta ao usuário qual o código, anota no papelzinho (variável busca), e usa esse papelzinho para atualizar o guia do endereço da biblioteca. Assim, a biblioteca (API) entrega o livro (jogo) correto!

A exceção NullPointerException é como se o atendente fosse buscar um livro, mas o livro não estivesse na biblioteca. A biblioteca não tem um livro com aquele código. Precisamos aprender a lidar com essa situação, para não deixar o usuário esperando indefinidamente ou mostrar uma mensagem de erro amigável. A gente precisa de um plano B para quando o livro não for encontrado.

Faz sentido assim? Tem alguma parte que você gostaria que eu explicasse com mais detalhes ou com outra analogia?

## Lidando com Exceções

Imagine que você está construindo um robô de entregas. Esse robô precisa pegar um pacote (as informações do jogo) em um depósito (a API). A instrução para ele é: "Pegue o pacote com o código 174".

Cenário 1: Sem tratamento de erros (o que aconteceu inicialmente).

O robô vai até o depósito, procura pelo pacote 174 e... não encontra! Ele para, fica parado e te manda uma mensagem de erro super técnica, cheia de códigos e termos que você não entende ("Exception in thread "main" java.lang.NullPointerException..."). Ele não sabe lidar com a situação de "pacote não encontrado". Isso é como o nosso código antes do try-catch: ele quebra quando encontra um problema inesperado.

Cenário 2: Com tratamento de erros (usando try-catch).

Agora, você programa o robô para lidar com a possibilidade de não encontrar o pacote. Você usa um "mecanismo de segurança":

try (tente): "Tente pegar o pacote 174."
catch (pegue): "Se não encontrar o pacote 174, faça o seguinte: mande uma mensagem amigável para o usuário dizendo 'Pacote não encontrado. Tente outro código.'"
Agora, se o robô não encontrar o pacote, ele não para tudo! Ele te avisa de forma clara e amigável, sem te inundar com códigos de erro complexos. Isso é exatamente o que o try-catch faz: ele tenta executar um bloco de código e, se ocorrer um erro específico (a NullPointerException, no nosso caso, a ausência do título), ele executa um bloco alternativo para lidar com o problema.

Cenário 3: Usando runCatching (uma abordagem mais moderna e eficiente).

Imagine que você melhora ainda mais o robô. Em vez de um "mecanismo de segurança" simples, você dá a ele uma "inteligência" maior. Ele tenta pegar o pacote e, ao mesmo tempo, já avalia se a operação foi bem-sucedida. Se deu certo, ele segue em frente. Se não, ele te avisa sem precisar de um "plano B" separado. O runCatching é como essa inteligência: ele tenta executar o código e te retorna um resultado que indica se deu certo ou não, permitindo que você trate o resultado de forma mais elegante e concisa.

Em resumo: o tratamento de erros é como dar ao seu programa a capacidade de lidar com situações inesperadas, assim como você programaria um robô para lidar com imprevistos em sua entrega. try-catch é um mecanismo de segurança básico, enquanto runCatching é uma abordagem mais sofisticada e eficiente.

Agora, que tal você tentar criar um exemplo de código com try-catch para uma situação diferente? Pense em um cenário onde você precisa ler um arquivo, e esse arquivo pode não existir. Como você usaria try-catch para lidar com essa situação? Vamos praticar!

## Usando runCatching

Imagine que você está construindo um robô que busca informações sobre jogos em um banco de dados. Esse banco de dados é como a nossa API que retorna informações dos jogos.

O try-catch é como ter um robô com um para-quedas:

Se o robô tenta pegar informações de um jogo que não existe (um erro, como uma NullPointerException), ele cai. O try é o robô tentando pegar a informação, e o catch é o para-quedas que o impede de cair completamente e o faz pousar suavemente, exibindo uma mensagem de erro ("Jogo inexistente"). Ele tenta fazer algo, e se der errado, ele tem um plano B.

O runCatching é como ter um robô com um sistema de telemetria:

Em vez de um para-quedas, o robô tem um sistema de telemetria que monitora constantemente seu estado. Ele tenta pegar a informação (runCatching). Se der certo, ele retorna a informação do jogo. Se der errado, ele envia uma mensagem de erro, mas continua funcionando. O resultado.onSuccess é como receber um sinal de "missão cumprida" e o resultado.onFailure é como receber um sinal de "ocorreu um problema". Você pode então agir de acordo com a mensagem recebida, sem que o robô pare completamente.

A adição da descrição personalizada é como dar ao robô uma ferramenta extra:

Depois de pegar as informações do jogo, o robô pergunta ao usuário se ele quer adicionar uma descrição personalizada. É como dar ao robô uma ferramenta extra para melhorar o resultado. Se o usuário disser "sim", o robô usa essa ferramenta; se disser "não", ele usa a descrição padrão.

Em resumo:

try-catch: Robô com para-quedas – tenta uma ação, e se falhar, tem um plano de contingência para evitar uma queda completa.
runCatching: Robô com telemetria – tenta uma ação, e se falhar, reporta o erro, mas continua funcionando, permitindo ações diferentes dependendo do sucesso ou falha.
onSuccess e onFailure: Sinais de "missão cumprida" e "ocorreu um problema" enviados pela telemetria do robô.
Descrição personalizada: Ferramenta extra para o robô melhorar o resultado final.

## Finalizando uma descrição Personalizada

Imagine que você está construindo um castelo de Lego. Seu castelo (o programa) precisa de várias peças (variáveis e funções). Algumas peças são essenciais (variáveis val), como as torres principais, que você define uma vez e não muda mais. Outras peças (variáveis var) são mais versáteis, como os bandeirinhas, que você pode trocar de lugar ou até mesmo remover.

No nosso código, a variável meuJogo é como uma base para o castelo. Inicialmente, ela pode ser null (vazia), como se você tivesse uma base sem nada construído nela ainda. Usar meuJogo: Jogo? = null é como dizer: "Eu tenho uma base para um castelo, mas ainda não construí nada nela; ela pode estar vazia".

O runCatching é como uma rede de segurança. Você tenta construir uma parte do castelo (criar o jogo com meuJogo = Jogo(...)), e se algo der errado (um erro na API, por exemplo), a rede de segurança pega a peça que caiu e evita que o castelo inteiro desmorone.

O meuJogo?.descricao é como tentar pegar uma peça específica do castelo (a descrição) com cuidado. O ponto de interrogação ? é como uma luva: você tenta pegar a peça, mas se ela não estiver lá (se meuJogo for null), você não quebra nada. Se a peça estiver lá, você a pega e usa.

A variável descricao em Jogo.kt sendo val inicialmente era como ter uma placa de identificação no castelo que você não pode mudar. Ao mudar para var, você pode trocar a placa de identificação sempre que quiser.

O conflito entre descricao sendo String em Jogo.kt e podendo ser null em Main.kt é como tentar colocar uma peça de um castelo de Lego diferente no seu castelo. As peças não se encaixam perfeitamente, então você precisa adaptar uma das peças para que elas se encaixem.

Por fim, o resultado.onSuccess é como um evento de inauguração do castelo. Depois de construir o castelo (o código principal), você pode fazer outras coisas, como colocar uma placa de "inaugurado com sucesso" (println("Busca finalizada com sucesso.")). Você pode ter vários eventos de inauguração (vários onSuccess), um para cada etapa da construção.

### Para saber mais runCatching

Vimos que para lidar com exceções no Kotlin podemos utilizar o try-catch do mesmo modo que vimos anteriormente na formação Java. Porém, no Kotlin existe o runCatching, que é outra possibilidade de tratar exceções que consegue capturar a exceção gerada sem interromper o fluxo de execução e salva seu resultado em uma variável que pode ser utilizada para trabalhar comportamentos de sucesso ou de falha de execução de um bloco de código.

Nos links a seguir você pode [conhecer mais sobre o funcionamento do runCatching](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/run-catching.html) e [saber mais sobre as opções de tratamento dos resultados apresentados nas exceções.](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-result/)

## Tratamento de Erros e refatorações

Imagine que você está construindo uma casa. No começo, tudo fica em um único cômodo: ferramentas, materiais, móveis, tudo misturado. É difícil encontrar algo, e a casa fica bagunçada e ineficiente. Esse cômodo único é como nossa Main inicial, com muito código misturado.

A aula nos ensina a organizar essa casa, dividindo-a em cômodos específicos:

Pacotes (Cômodos): São como os cômodos da casa. Criamos pacotes como br.com.alura.alugames.modelo, br.com.alura.alugames.principal e br.com.alura.alugames.servicos. Cada um tem uma função específica:

modelo (Quarto): Guarda os "modelos" da casa, ou seja, as classes que representam os elementos importantes do nosso projeto (como Jogo, InfoJogo, etc.). São os tijolos, a madeira, os móveis da casa.
principal (Sala de Estar): É onde fica a nossa Main, a entrada principal da casa. Aqui, coordenamos tudo, mas sem fazer todo o trabalho pesado.
servicos (Cozinha): É onde ficam as tarefas específicas, como buscar informações da API (ConsumoApi). É como a cozinha, onde preparamos os ingredientes (dados da API) para serem usados na sala de estar (Main).
Classes (Móveis): Cada classe é um móvel específico. Jogo é uma cadeira, InfoJogo é uma mesa, e ConsumoApi é o fogão, que prepara os ingredientes (dados).

Métodos (Ações): Os métodos são as ações que podemos fazer com os móveis. Por exemplo, o método buscaJogo() na classe ConsumoApi é como usar o fogão para cozinhar (buscar dados da API).

Mover as classes para os pacotes certos é como organizar os móveis em seus cômodos apropriados. Colocar o código da API em uma classe separada (ConsumoApi) é como separar a cozinha do resto da casa, deixando a sala de estar (Main) mais limpa e organizada.

Refatorar o código é como reformar a casa: mudamos algumas coisas, mas a estrutura geral permanece a mesma, ficando mais funcional e bonita.

Ao separar as responsabilidades em diferentes classes e pacotes, tornamos o código mais fácil de entender, manter e expandir, assim como uma casa bem organizada é mais fácil de viver e manter. Se precisarmos mudar algo na forma como buscamos informações da API, só precisamos mexer na "cozinha" (ConsumoApi), sem precisar tocar no resto da casa.

# Aprimorando a busca

## Caracterisiticas e comportamentos do Gamer

Imagine que estamos construindo uma locadora de jogos online. Precisamos de duas coisas principais: os jogos (que já modelamos em aulas anteriores) e os jogadores, que são os nossos gamers.

A classe Gamer é como um formulário de cadastro de um cliente na nossa locadora. O construtor primário (data class Gamer(var nome:String, var email:String)) é como a parte mínima do formulário que todo cliente precisa preencher para ter acesso básico: nome e e-mail. É como se fosse o cadastro "express". Você pode entrar na locadora, navegar pelos jogos, mas para alugar, precisa de mais informações.

O construtor secundário (constructor(nome: String, email: String, dataNascimento:String, usuario:String): this(nome, email)) é como um formulário completo. Ele pega tudo do formulário "express" (nome e e-mail) e adiciona informações extras: data de nascimento e nome de usuário. É como se fosse o cadastro completo, que permite alugar jogos. Observe que ele chama o construtor primário (this(nome, email)) primeiro, garantindo que as informações básicas estejam sempre presentes.

O idInterno é como o número do CPF ou RG do cliente. É um identificador único e imutável ( val ), que a locadora usa internamente para rastrear todas as atividades do cliente (aluguéis, pagamentos, etc.). Ele é diferente do nome de usuário, que pode ser alterado.

As Scope functions, como let, são como ferramentas mágicas que nos permitem modificar o formulário do cliente de forma mais eficiente. Imagine que você precisa atualizar a data de nascimento e o nome de usuário de um cliente. Ao invés de escrever várias linhas de código separadas (gamer1.nome = "novoNome"; gamer1.dataNascimento = "novaData";), usamos uma Scope function para fazer tudo de uma vez só, de forma mais limpa e organizada.

Por fim, a mudança de val para var em dataNascimento e idInterno é como permitir que a locadora altere informações no formulário do cliente. Inicialmente, esses campos eram imutáveis (como o CPF), mas percebemos que precisamos permitir alterações (como atualizar a data de nascimento).

Então, resumindo: a classe Gamer modela nossos clientes, os construtores são como formulários de cadastro com diferentes níveis de detalhe, o idInterno é um identificador único, e as Scope functions são ferramentas para facilitar a manipulação dos dados do cliente.


### Scope functions

As scope functions, ou funções de escopo, são funções que têm como objetivo executar um bloco de código em um objeto de maneira mais concisa e legível. Todas as scope functions possuem o mesmo objetivo, a diferença entre elas é como esse objeto está disponível no bloco de código e qual será o resultado da expressão.

As scope functions são:

- let - executa uma ação em um objeto e retorna o resultado da expressão lambda;

- run - também executa uma ação em um objeto como o let, mas não retorna o resultado da expressão, e sim o resultado do bloco de código;

- with - executa uma sequência de operações sendo necessário passar o objeto como argumento explícito;

- apply - realiza operações de configuração em um objeto e retorna o próprio objeto modificado;

- also - realiza a mesma coisa que o apply, porém retorna o próprio objeto original.

Para conhecer mais sobre as scope functions, como funciona cada uma e ver exemplos práticos de aplicação, [recomendamos a leitura da documentação](https://kotlinlang.org/docs/scope-functions.html).

## Adicionando novos métodos

Para analisar se você aplicou corretamente os conceitos da aula sobre a adição do método criarIdInterno() na classe Gamer, sugiro que você siga estes passos:

Revise o código: Compare seu código com o exemplo fornecido na aula. Preste atenção em cada detalhe: a declaração do método, a geração do número aleatório com Random.nextInt(10000), o uso de String.format("%04d", numero) para garantir um número de quatro dígitos, a concatenação para formar o idInterno ("$usuario#$tag") e, finalmente, a chamada do método criarIdInterno() dentro do construtor da classe Gamer.

Teste seu código: Execute seu TesteGamer.kt. Observe atentamente a saída no terminal. Você consegue ver o idInterno sendo gerado corretamente para cada instância de Gamer criada? O formato nomeDeUsuario#númeroDeQuatroDígitos está sendo respeitado? Se você criar vários objetos Gamer, cada um terá um idInterno único?

Analise a lógica: Pense na lógica por trás do código. O idInterno deve ser gerado apenas uma vez, no momento da criação do objeto Gamer. Seu código garante isso? Se você tentar modificar o idInterno diretamente após a criação do objeto, ele deve permanecer inalterado. Seu código reflete esse comportamento?

Faça um teste adicional: Crie um novo objeto Gamer no seu TesteGamer.kt com um nome diferente e observe se o idInterno gerado é único e segue o padrão esperado. Isso ajudará a confirmar que o método está funcionando corretamente para diferentes entradas.

## Encapsulando Dados

Imagine uma casa (nossa classe Gamer). Dentro dessa casa, temos vários cômodos (atributos como idInterno, nome, email).

Encapsulamento sem getters e setters explícitos (apenas private):

Inicialmente, nosso idInterno era como um cômodo secreto, trancado com uma fechadura super reforçada (private). Ninguém de fora (outras partes do código) consegue entrar ou ver o que tem lá dentro. Nem mesmo nós conseguimos acessar diretamente, pois ele começa vazio (null). Isso é como uma casa que só pode ser acessada pela porta da frente, mas a porta está trancada e não temos a chave.

Encapsulamento com getters e setters explícitos (como em Java):

Depois, aprendemos a criar uma "fechadura inteligente" (getIdInterno()). Essa fechadura permite que apenas pessoas autorizadas (a nossa classe Gamer) abram a porta e vejam o que tem dentro do cômodo secreto. É como se tivéssemos uma chave especial para o cômodo secreto. Ainda assim, não podemos mudar o que está dentro do cômodo sem uma chave diferente (um setter).

Encapsulamento com Properties do Kotlin (a forma mais idiomática):

A forma mais elegante no Kotlin é como se a casa já viesse com uma "fechadura inteligente" embutida em cada cômodo. Podemos ver o conteúdo do cômodo (get), mas só podemos mudar o que está dentro dele se tivermos a permissão (private set). É como se a casa tivesse um sistema de segurança interno que permite a visualização, mas restringe a alteração sem autorização. A chave para alterar o conteúdo está com a casa (a classe Gamer).

O set(value) com a condição:

Agora, imagine que a casa só recebe um novo idInterno (uma nova chave para o cômodo secreto) quando um novo morador (usuario) se muda. O set(value) com a condição if(idInterno.isNullOrBlank()) é como se a casa só gerasse uma nova chave para o cômodo secreto (criarIdInterno()) quando um novo morador se inscreve. Se o morador já existe, a chave antiga continua válida.

Em resumo, o encapsulamento é como proteger os dados internos da nossa classe, permitindo o acesso e a modificação de forma controlada, como se fosse um sistema de segurança em uma casa. O Kotlin nos oferece diferentes maneiras de implementar essa segurança, sendo a utilização de Properties a mais eficiente e elegante.

Entendeu melhor agora? Qualquer dúvida, pode perguntar! Vamos praticar com alguns exercícios? Que tal você tentar criar uma classe Carro com atributos como modelo, cor e placa, onde a placa só pode ser definida uma vez no construtor ou através de um método específico? Pense em como você pode usar o encapsulamento para garantir que a placa não seja alterada depois de definida. Depois, podemos discutir sua solução!

### [Properties - Get & Set](https://kotlinlang.org/docs/properties.html#getters-and-setters)

### [Modificadores de visibilidade](https://kotlinlang.org/docs/visibility-modifiers.html#class-members)

## Validando informações

Imagine que você está construindo uma casa de Lego. Cada tijolo de Lego representa um dado na sua aplicação, como o nome e o email do jogador. A data class é como o projeto da sua casa: define quais tijolos você precisa e como eles se encaixam.

O construtor é como o ato de começar a construir a casa. Você precisa de certos tijolos para que a casa fique de pé, certo? A validação do email e do nome são como checar se você tem todos os tijolos necessários e se eles estão em boas condições antes de começar a construir. Se um tijolo (dado) estiver quebrado (inválido), você não consegue construir a casa (objeto).

O método validarEmail() é como um inspetor de tijolos. Ele verifica se o tijolo "email" está no formato correto ("exemplo@email.com"). Se estiver, ele aprova o tijolo; se não, ele rejeita, indicando que está quebrado. A Regex é a régua que o inspetor usa para medir se o tijolo tem o tamanho e formato corretos.

O init{} é como a fase de inspeção final antes de começar a construir de fato. Ele verifica todos os tijolos (dados) antes de começar a montá-los. Se algum tijolo estiver quebrado, a construção para e você recebe uma mensagem de erro, indicando qual tijolo precisa ser substituído. Se tudo estiver certo, a construção (criação do objeto) continua.

O throw IllegalArgumentException() é como um alarme que toca quando um tijolo está quebrado. Ele interrompe a construção e te avisa qual tijolo precisa ser consertado.

Por fim, o try-catch (que não foi usado explicitamente no exemplo, mas mencionado) seria como ter um plano B caso algo dê errado durante a construção. Você pode tentar consertar o tijolo quebrado ou usar um tijolo reserva, em vez de parar a construção completamente.

Então, em resumo, a aula ensinou como garantir que você só use tijolos (dados) válidos para construir sua casa de Lego (objeto), evitando problemas durante a construção e garantindo uma casa (objeto) bem-feita e funcional.

Agora, para praticar, tente criar um exemplo de validação para um campo de "idade" no seu Gamer. Que tipo de validação você faria? Que mensagem de erro você mostraria se a idade for inválida? Pense em como você faria isso usando o init{} e IllegalArgumentException(). Lembre-se de considerar o tipo de dado da idade e quais valores seriam considerados inválidos. Qualquer dúvida, pode me perguntar!


### [Init](https://kotlinlang.org/docs/classes.html#constructors)

# Implementando a lista de jogos


## Busca com repetição

Imagine que você é um bibliotecário(a) e precisa organizar as buscas dos seus usuários. Antes, a cada busca por um livro, você precisava recomeçar todo o processo: procurar o livro, anotar o título e autor, e só então registrar a busca. Era trabalhoso, não é?

O do/while é como um sistema automatizado que facilita esse trabalho. É como se você tivesse um formulário onde o usuário preenche o título do livro que procura. O do representa a ação de procurar o livro e anotar as informações. O while é a pergunta: "O usuário quer procurar outro livro?". Se a resposta for "sim", o processo (do) se repete; se for "não", o processo para. Assim, você consegue registrar várias buscas de uma só vez, sem precisar recomeçar a cada uma.

Agora, imagine que você precisa guardar todas as buscas do dia. Antes, você anotava cada busca em um papel separado. Com a lista MutableList<Jogo>, é como se você tivesse um grande caderno onde pode anotar todas as buscas, adicionar novas buscas e, se necessário, apagar alguma anotação. A List<Jogo> seria como um livro de registros antigo, onde você só pode ler as informações, sem poder adicionar ou remover nada. MutableList<Jogo> é muito mais prático para o seu trabalho, certo? Você pode adicionar cada livro encontrado (cada Jogo) a essa lista, criando um registro completo das buscas do dia.

Então, o do/while automatiza o processo de busca, e o MutableList<Jogo> armazena todas as buscas de forma organizada e editável, assim como um bibliotecário organiza as buscas dos seus usuários em um sistema eficiente. Entendeu a analogia? Qualquer dúvida, pode perguntar!

### [Listas e coleções](https://kotlinlang.org/docs/collections-overview.html)


## Lista de Jogos Buscados


Imagine que você está construindo um álbum de figurinhas digital de jogos. O Gamer é como o próprio álbum, onde você guarda as informações do colecionador (nome, email, etc.) e as figurinhas (jogos buscados).

O companion object é como a loja onde você compra o álbum. Você não precisa ter um álbum em mãos para ir na loja e comprar um, certo? A função criarGamer() dentro do companion object é como o atendente da loja que te ajuda a preencher as informações do seu álbum (nome, email, etc.) antes mesmo de você ter o álbum em mãos. Ele te faz perguntas e, com base nas suas respostas, cria o álbum personalizado para você.

O Scanner é como a sua caneta para preencher as informações no álbum. Em vez de usar várias canetas diferentes, você usa apenas uma para preencher todos os dados. Isso deixa o processo mais eficiente e organizado, assim como no código, onde reutilizamos o mesmo Scanner.

A condicional if (opcao.equals("s", true)) é como uma pergunta: "Você quer um álbum completo ou um álbum básico?". Se você disser "sim" (ou "s"), o atendente te pergunta mais informações (data de nascimento, nome de usuário) para completar o álbum. Se você disser "não", ele cria um álbum básico com apenas o nome e o email.

O return Gamer(...) é como o atendente te entregando o álbum pronto, com todas as informações preenchidas. Dependendo da sua escolha, ele te entrega um álbum completo ou um álbum básico.

Finalmente, adicionar jogos à lista jogosBuscados é como colar as figurinhas no seu álbum. A cada jogo que você busca, você adiciona uma nova figurinha ao seu álbum. O Jogo? indica que algumas páginas do álbum podem estar vazias (null) se você não tiver encontrado todas as figurinhas que queria.

Então, resumindo: a aula ensinou como criar uma função que, como um atendente de loja, te ajuda a criar um álbum de figurinhas digital (o Gamer), te perguntando informações e te entregando o álbum pronto, com a opção de adicionar mais informações (como data de nascimento e nome de usuário) e, depois, te permite adicionar figurinhas (jogos buscados) a ele.


### [Companion objects](https://kotlinlang.org/docs/object-declarations.html#data-objects)

**JOGOS BUSCADOS**

146, 150, 153, 612


## Manipulando Listas

Imagine que a nossa lista de jogos é como uma pilha de cartas de um jogo de baralho. No começo, elas estão todas embaralhadas, na ordem que foram adicionadas (como a lista jogosBuscados inicialmente).

Ordenação (sortBy): É como se pegássemos essa pilha de cartas embaralhadas e as ordenássemos por naipe ou valor. A função sortBy { it?.titulo } é como se tivéssemos um critério para ordenar: ordenar as cartas pelo nome do jogo (o título). O it?.titulo é como pegar o nome escrito em cada carta para comparar e ordenar. O ? é uma precaução, como se algumas cartas estivessem em branco e precisássemos lidar com essa possibilidade sem que o jogo pare.

Exibição somente do título (forEach): Depois de ordenar, podemos querer ver apenas o nome das cartas, sem ver o resto da informação de cada uma. A função forEach é como se estivéssemos passando por cada carta e anotando apenas o nome em um papel separado. println("Título: " + it?.titulo) é como escrever "Título: [nome da carta]" em nosso papel.

Filtragem (filter): Agora, imagine que queremos apenas as cartas de um naipe específico, por exemplo, apenas os jogos com "Batman" no título. A função filter { it?.titulo?.contains("batman", true) ?: false } é como se estivéssemos separando as cartas, pegando apenas aquelas que possuem a palavra "Batman" no nome, independente de maiúsculas ou minúsculas (true em ignoreCase). O ?: false é como dizer: "Se não encontrar nenhuma carta com 'Batman', a pilha filtrada fica vazia".

Exclusão (removeAt): Finalmente, imagine que queremos tirar uma carta específica da pilha. A função removeAt(posicao) é como se estivéssemos removendo uma carta de uma posição específica da pilha. Precisamos saber a posição da carta (o índice) para removê-la corretamente.

Em resumo, a aula ensina a manipular a lista de jogos como se fosse uma pilha de cartas, permitindo ordená-la, mostrar apenas partes específicas de cada carta, filtrar cartas com características específicas e remover cartas de posições determinadas. Cada função do Kotlin é uma ferramenta para realizar essas operações na nossa "pilha de cartas" (lista).

***Resumo 2***

A aula ensina como manipular uma lista de objetos Jogo em Kotlin. Inicialmente, a lista é exibida na ordem de adição. Aprendemos a:

Ordenar a lista: Usando sortBy { it?.titulo }, ordenamos a lista de jogos alfabeticamente pelo título. O it representa cada elemento da lista, e ?. trata a possibilidade de um título nulo.

Exibir apenas o título: Usando forEach { println("Título: " + it?.titulo) }, iteramos pela lista e imprimimos apenas o título de cada jogo.

Filtrar a lista: Usando filter { it?.titulo?.contains("batman", true) ?: false }, criamos uma nova lista contendo apenas os jogos com "batman" (maiúsculas ou minúsculas) no título. O operador Elvis (?: false) garante que a lista filtrada não seja nula caso não haja jogos correspondentes.

Excluir um item da lista: Usando removeAt(posicao), removemos um jogo da lista original, baseado em sua posição (índice) na lista.

Em resumo, a aula demonstra como usar funções de manipulação de listas em Kotlin para ordenar, filtrar e remover elementos, lidando com a possibilidade de valores nulos e garantindo a robustez do código. Tudo isso usando a mutableList<T>.


## Usando Extension functions

Imagine uma Extension Function como um acessório para uma roupa. Você tem uma roupa básica, digamos, uma camiseta branca (a sua classe). Essa camiseta por si só é funcional, mas pode ser melhorada. Uma Extension Function seria como adicionar um broche, um bordado, ou uma estampa (a funcionalidade extra). Você não precisa mudar a camiseta em si, apenas adiciona algo que melhora ou amplia sua funcionalidade.

No nosso caso, a camiseta branca é a classe String que representa a data de nascimento. Ela já existe, já funciona, mas não tem a capacidade de calcular a idade diretamente. A nossa Extension Function transformarEmIdade() é o broche que adicionamos. Ela pega a String (a data de nascimento), faz o processamento necessário (usando DateTimeFormatter e Period), e retorna a idade (um novo atributo). A camiseta continua sendo uma camiseta branca, mas agora tem um detalhe extra, uma nova capacidade.

Outro exemplo: imagine uma caixa de ferramentas (a sua aplicação). Dentro dela, você tem várias ferramentas (classes e funções). Uma Extension Function seria como adicionar uma nova ferramenta multifuncional. Essa ferramenta não precisa ser parte de um conjunto específico, ela pode ser usada com diferentes tipos de parafusos (diferentes classes de dados), adaptando-se à necessidade. No nosso caso, a ferramenta multifuncional é a transformarEmIdade(), que funciona com qualquer String que represente uma data no formato correto.

Por fim, pense em um carro (a sua aplicação). Ele já tem funcionalidades básicas como acelerar, frear e virar (as funções da classe). Uma Extension Function seria como instalar um novo acessório, como um GPS ou um sensor de estacionamento (a nova funcionalidade). Você não precisa modificar o motor ou a estrutura do carro, apenas adiciona um novo recurso que melhora a experiência do usuário. No nosso exemplo, o acessório é a função que calcula a idade a partir da data de nascimento, adicionando uma nova funcionalidade à nossa aplicação sem precisar modificar a estrutura principal.

***Resumo2***

Nesta aula, aprendemos sobre Extension Functions em Kotlin. Elas permitem adicionar novas funcionalidades a classes existentes sem modificá-las diretamente, como adicionar um método a uma classe String para calcular a idade a partir de uma data de nascimento. Criamos uma Extension Function chamada transformarEmIdade() que recebe uma String (data no formato dd/MM/yyyy), usa DateTimeFormatter para parsear a data, LocalDate para representar as datas e Period para calcular a diferença entre a data de nascimento e a data atual, retornando a idade em anos. Aprendemos também a lidar com possíveis erros de formatação de data usando tratamento de exceções (embora a aula tenha sugerido e não implementado). Por fim, vimos como usar essa Extension Function em nosso projeto para exibir a idade do jogador, destacando a flexibilidade e reutilização que as Extension Functions oferecem. A aula também enfatizou a importância de considerar se uma nova funcionalidade deve ser uma Extension Function ou um método dentro da própria classe, dependendo do contexto e da responsabilidade de cada parte do código.

### [Extension Functions](https://kotlinlang.org/docs/extensions.html#extension-functions)

