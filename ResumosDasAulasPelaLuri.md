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