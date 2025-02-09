# JobFinder

O **JobFinder** é um aplicativo Android moderno para busca de empregos, desenvolvido com Kotlin e Jetpack Compose. Ele permite que usuários (candidatos) e empresas se cadastrem, façam login, publiquem vagas e vejam vagas. O app utiliza Retrofit para comunicação com a API REST, Room para persistência local (armazenando informações de autenticação) e outras tecnologias modernas do ecossistema Android.

## Sumário

- [Recursos](#recursos)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Configuração do Projeto](#configuração-do-projeto)
- [Instalação](#instalação)
- [Uso](#uso)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Melhorias Futuras](#melhorias-futuras)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Recursos

- **Cadastro e Login:** Usuários e empresas podem se registrar e autenticar.
- **Dashboard Personalizado:** 
  - **Usuário:** Visualiza vagas.
  - **Empresa:** Gerencia vagas (cria, edita, exclui).
- **Persistência de Dados:** Utiliza Room para manter o estado de autenticação (token, email, etc.) mesmo após o fechamento do app.
- **Integração com API:** Comunicação com a API via Retrofit, com autenticação JWT.
- **Design Moderno:** Interface baseada em Jetpack Compose com temas e paleta de cores consistentes.

## Tecnologias Utilizadas

- **Linguagem:** Kotlin
- **Framework de UI:** Jetpack Compose
- **Persistência Local:** Room (para salvar dados do usuário autenticado)
- **Comunicação com API:** Retrofit com GsonConverterFactory
- **Autenticação:** JWT
- **Segurança:** EncryptedSharedPreferences (para armazenar token)
- **API:** VagasEmprego
- **Outros:** Material3, Navigation Compose

## Configuração do Projeto

Certifique-se de ter as seguintes dependências (ou versões equivalentes) no seu `build.gradle` (app):

```groovy
// Exemplo de dependências
implementation "androidx.compose.material3:material3:1.1.0"
implementation "androidx.compose.ui:ui:1.4.0"
implementation "androidx.activity:activity-compose:1.7.1"
implementation "androidx.navigation:navigation-compose:2.5.3"
implementation "androidx.room:room-runtime:2.6.0"
kapt "androidx.room:room-compiler:2.6.0"
implementation "androidx.room:room-ktx:2.6.0"
implementation "com.squareup.retrofit2:retrofit:2.9.0"
implementation "com.squareup.retrofit2:converter-gson:2.9.0"
implementation "androidx.security:security-crypto:1.1.0-alpha03"
