## Instituto João de Barro

### Passos para Rodar a Aplicação Localmente

### 💻 Clonagem

Para clonar o repositório, você pode escolher entre os seguintes métodos:

- **HTTPS**

    ```bash
    git clone https://github.com/CleytonSM/ijb_api.git
    ```

- **SSH**

    ```bash
    git clone git@github.com:CleytonSM/ijb_api.git
    ```

### ⚙️ Configurando Variáveis de Ambiente

Certifique-se de configurar as variáveis de ambiente necessárias para o funcionamento da aplicação. Os detalhes específicos das variáveis devem ser fornecidos pela equipe de desenvolvimento ou documentados em um arquivo separado.

### 🎨 Design Pattern 

Este projeto utiliza o padrão de design **MVC (Model-View-Controller)**. Abaixo está uma visão geral dos principais diretórios e suas responsabilidades:

- **Model**
  
  O diretório `model` contém as definições dos modelos, incluindo entidades e DTOs (Data Transfer Objects). Este diretório é subdividido em pastas para entidades e DTOs, conforme necessário.

- **Repository**
  
  O diretório `repository` é responsável pela comunicação entre a aplicação e o banco de dados. Nele, você encontrará métodos básicos de CRUD, como `save`, `findById` e `delete`.

- **Service**
  
  O diretório `service` abriga as classes que realizam a lógica de negócios e operações intermediárias para as classes controladoras.

- **Controller**
  
  O diretório `controller` contém as classes que gerenciam as requisições da aplicação e orquestram a resposta adequada.

- **Config**
  
  O diretório `config` é dedicado às configurações básicas da aplicação, incluindo conectividade e roteamento.

- **Filter**
  
  O diretório `filter` inclui as classes responsáveis por filtrar as requisições antes que elas cheguem aos controladores, adicionando uma camada extra de validação.
