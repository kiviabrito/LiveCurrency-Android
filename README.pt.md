# Live Currency para Android - Kotlin

## Funcionalidade

Calcular valores em diferente moedas.

## Estrutura:
Alguns dos componentes utilizados são:

- Arquitetura MVVM.
- Room DataBase - para armazenamento em cache local.
- Corotinas - para tarefas em segundo plano, como chamadas de rede e acesso ao banco de dados.
- Ktor Client - para as chamadas de rede.
- KotlinSerialization - pela desserialização.
- RecyclerView - para exibir a lista de moedas.
- ConstraintLayout - para o design do layout.

## Libs:

   **JUNIT JUPITER (JUnit5) - Para test Unitário**
   
                def junit_jupiter_version = "5.3.2"
                testImplementation "org.junit.jupiter:junit-jupiter-api:$junit_jupiter_version"
                testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:$junit_jupiter_version"
            
   **COROUTINES-TEST - Para test Unitário**
   
                testImplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.6'
            
   **MOCKITO - Para test Unitário.**
   
                def mockito_version = "2.25.0"
                testImplementation "org.mockito:mockito-core:$mockito_version"
                testImplementation "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"
            
   **KOTLINX SERIALIZATION - Para desserialização de resposta da chamada de rede.**
   
                implementation "org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0"
            
   **KTOR CLIENT - Para chamadas de rede.**
   
                implementation "io.ktor:ktor-client-okhttp:1.3.2"
            
   **ROOM DATABASE - Para armazenamento local de dados.**
   
                def room_version = "2.2.5"
                implementation "androidx.room:room-runtime:$room_version"
                kapt "androidx.room:room-compiler:$room_version"
            



## Modelos:

Foram avaliados 3 diferentes models como resposta do Rest API.

>Live Request - >
- [ ] Success = true && QuoteData
- [ ] Success = false && Error

>List Request - >
- [ ] Success = true && CurrencyData
- [ ] Success = false && Error

Os 3 models estão sendo manuseados/definidos no file ClientAPI para evitar erros/crash no momento do request.

## Visualizações:

O aplicativo foi criado utilizando:

- [ ] 1 - Atividade
- [ ] 1 - ViewModel
- [ ] 2 - Fragmentos

A atividade foi utilizada como host para os fragmentos e o ViewModel está buscando dados e fazendo conexão/troca de dados entre os dois fragmentos.

Para uma resposta rápida e melhor eficiência do aplicativo, a página principal consiste em 4 views, dois Buttons, um EditText e um TextView no qual eles tem interação direta entre eles.

Quando o usuário seleciona qualquer moeda o valor atualiza sem que ele/ela tenha que pressionar qualquer outro botão, tendo assim uma resposta rápida à interação do usuário.

Quanto a página de seleção da moeda, foi adicionado um filtro em formato SearchBar para pesquisa pelo nome ou código da moeda e também foi adicionado a opção de organizar por ordem crescente tanto pelo código como pelo nome.

![alt text](https://github.com/kiviabrito/LiveCurrency-Android/blob/master/Screenshot_MainActivity.png) 

#### Note: Para que o offline mode funcione é necessário que o usuário tenha tido pelo menos uma "SuccessResponse" do network request.

## Executar o app

O app utiliza o [API CurrencyLayer](https://currencylayer.com/documentation) para a API, será necessário fazer um cadastro no plano gratuito para obter uma chave de acesso e atualizar a "key" variável no arquivo "ClientAPI.kt".
