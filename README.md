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
## Tela

- **Splash Screen:** Exibe o logo do aplicativo e uma mensagem de boas-vindas por alguns segundos antes de redirecionar para a tela de login.
- **Tela de Login:** Permite a autenticação do usuário, com validação do formato de e-mail e dos campos obrigatórios. O usuário pode escolher entre as modalidades “User” e “Company”.
- **Tela de Registro de Usuário:** Permite o cadastro de novos usuários (voluntários ou candidatos) com validação de campos (nome, e‑mail e senha).
- **Tela de Registro de Empresa:** Permite o cadastro de empresas com os dados necessários (nome, e‑mail, endereço, senha) e validação dos campos.
- **Home do Usuário:** Exibe uma lista de vagas disponíveis para candidatos.
- **Home da Empresa:** Exibe apenas as vagas criadas pela empresa logada, permitindo gerenciar (criar, editar, excluir) as vagas.
- **Tela de Criação/Edição de Vaga:** Permite que a empresa crie uma nova vaga ou edite uma vaga existente.
- **Tela de Detalhes da Vaga:** Exibe informações detalhadas sobre a vaga (descrição, localização, salário, requisitos, benefícios, dados da empresa) e, de acordo com o tipo de usuário, permite ações como “Candidatar‑se” (para candidatos) ou “Editar/Excluir/Ver Candidatos” (para empresas).

## Screenshots


### Splash Screen
![Splash Screen] ![splashScreen](https://github.com/user-attachments/assets/de5f9b32-d20d-4fa5-aea4-854eb4f5875b)

*Exibe o logo do aplicativo e uma breve mensagem de boas‑vindas antes de redirecionar para a tela de login.*

### Tela de Login
![Login Screen](![login](https://github.com/user-attachments/assets/d2152d05-5ce6-4906-9a5a-81b2da0a76e6)

*A tela de login permite que o usuário insira seu e‑mail e senha, com validação do e‑mail e dos campos obrigatórios, e escolha entre “User” e “Company”.*

### Tela de Registro de Usuário
![Register User Screen] ![register](https://github.com/user-attachments/assets/94e32218-6053-4881-9832-ee8535e2c1d5)

*Permite o cadastro de usuários, validando os campos (nome, e‑mail e senha).*

### Tela de Registro de Empresa
![Register Company Screen] ![register1](https://github.com/user-attachments/assets/b4065aae-a1fb-4f9c-be05-8cec6c77ce98)

*Permite o cadastro de empresas, coletando informações como nome, e‑mail, endereço e senha, com validação dos campos.*

### Home do Usuário
![User Home Screen] ![user](https://github.com/user-attachments/assets/ce9e53d2-8687-448f-8b9c-2726981cda08)

*Exibe uma lista de vagas disponíveis para candidatos.*

### Home da Empresa
![Company Home Screen] ![userCompany](https://github.com/user-attachments/assets/8db6f413-fa79-4ebf-ba7b-49064c0aba6c)

*Exibe as vagas publicadas pela empresa logada, permitindo gerenciá-las (criar, editar, excluir, ver candidatos).*

### Criação/Edição de Vaga
![Create/Edit Job Screen]![criarVaga](https://github.com/user-attachments/assets/5b499fc7-bbbb-4ca7-9f0b-64fc7d4bcdea)

*Permite que a empresa crie ou edite uma vaga, com campos para título, descrição, salário, localização, requisitos e benefícios, com validações aplicadas.*

### Detalhes da Vaga
![Job Details Screen] ![user_details](https://github.com/user-attachments/assets/b56dedaf-2a0f-4565-bc7e-8c5e7fe6a1c6)


*Exibe os detalhes completos da vaga, incluindo informações da empresa (nome e e‑mail) e status da vaga. A interface se adapta para mostrar botões de ação diferentes para candidatos e empresas.*

## Configuração e Execução

### Pré-requisitos
- Android Studio Arctic Fox ou superior
- Gradle 7.0 ou superior

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

```gradle
implementation ("androidx.compose.material3:material3:1.1.0")
implementation ("androidx.compose.ui:ui:1.4.0")
implementation ("androidx.activity:activity-compose:1.7.1")
implementation ("androidx.navigation:navigation-compose:2.5.3")
implementation ("androidx.room:room-runtime:2.6.0")
kapt ("androidx.room:room-compiler:2.6.0")
implementation ("androidx.room:room-ktx:2.6.0")
implementation ("com.squareup.retrofit2:retrofit:2.9.0")
implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
implementation ("androidx.security:security-crypto:1.1.0-alpha03")
