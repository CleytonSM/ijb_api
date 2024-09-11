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

### ☕ Versão do JDK

- **17**

### ⚙️ Configurando Variáveis de Ambiente

Certifique-se de configurar as variáveis de ambiente necessárias para o funcionamento da aplicação. Os detalhes específicos das variáveis devem ser fornecidos pela equipe de desenvolvimento ou documentados em um arquivo separado.

---
### FlywayDB: Simplificando as Migrações de Banco de Dados

FlywayDB é uma ferramenta de migração de banco de dados que gerencia a versão do schema de maneira automática. Com o Flyway, você não precisa se preocupar em rodar scripts manualmente para criar ou modificar tabelas no banco de dados. Ele aplica automaticamente todas as mudanças (chamadas de "migrações") ao inicializar a aplicação, garantindo que o banco de dados esteja sempre sincronizado com o código.

### O que isso significa para você?
- **Sem necessidade de scripts manuais**: Toda a lógica de criação ou alteração de tabelas é gerenciada pelo FlywayDB. Não é necessário executar nenhum script SQL manualmente.
- **Automação das migrações**: Sempre que você inicializa a aplicação, o FlywayDB verifica quais migrações ainda não foram aplicadas e as executa, mantendo o banco de dados atualizado.

### O que pode dar errado?
- **Editar scripts já aplicados**: Se você modificar um script SQL que já foi aplicado no banco de dados, o FlywayDB detectará uma inconsistência e a aplicação pode não iniciar corretamente. Nesse caso, será necessário criar uma nova migração em vez de modificar as já existentes.
- **Nomear scripts de forma inadequada**: O FlywayDB segue um padrão rigoroso de nomenclatura dos arquivos de migração (por exemplo, `V1__create_table.sql`). Certifique-se de seguir esse padrão. Caso contrário, o script pode não ser executado corretamente.
- **Esquecer de adicionar novas migrações**: Se você fizer alterações no schema do banco de dados e esquecer de criar o script de migração correspondente, o FlywayDB não poderá aplicar a mudança automaticamente.

### Comunicação de alterações
Se houver alguma alteração ou problema com os scripts de migração, **todos os desenvolvedores serão avisados** para garantir que o repositório permaneça funcional e em conformidade com as versões corretas do banco de dados.

Portanto, ao contribuir com o repositório, **não se preocupe em rodar scripts SQL manualmente**, mas preste atenção às práticas recomendadas acima para evitar problemas.

---
### 🎨 Design Pattern 

Este projeto utiliza o padrão de design **MVC (Model-View-Controller)**. Abaixo está uma visão geral dos principais diretórios e suas responsabilidades:

- **Model**
  
  O diretório `models` contém as definições dos modelos, incluindo entidades e DTOs (Data Transfer Objects). Este diretório é subdividido em pastas para entidades e DTOs, conforme necessário.

- **Repository**
  
  O diretório `repositories` é responsável pela comunicação entre a aplicação e o banco de dados. Nele, você encontrará métodos básicos de CRUD, como `save`, `findById` e `delete`.

- **Service**
  
  O diretório `services` abriga as classes que realizam a lógica de negócios e operações intermediárias para as classes controladoras.

- **Controller**
  
  O diretório `controllers` contém as classes que gerenciam as requisições da aplicação e orquestram a resposta adequada.

- **Config**
  
  O diretório `configs` é dedicado às configurações básicas da aplicação, incluindo conectividade e roteamento.

- **Filter**
  
  O diretório `filters` inclui as classes responsáveis por filtrar as requisições antes que elas cheguem aos controladores, adicionando uma camada extra de validação.

- **Helper**
  
  O diretório `helpers` armazena classes utilitárias que fornecem funcionalidades auxiliares que podem ser reutilizadas em diferentes partes da aplicação.
