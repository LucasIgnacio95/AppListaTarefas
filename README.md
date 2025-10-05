# Lista de Tarefas - App Android 📝

Um aplicativo Android para gerenciamento de tarefas que permite ao usuário criar, ler, atualizar e excluir (CRUD) anotações. O projeto utiliza um banco de dados **SQLite** local para garantir a persistência dos dados, ou seja, as tarefas não são perdidas ao fechar o aplicativo.

## 📸 Screenshots

Tela Principal 

<img width="547" height="1232" alt="image" src="https://github.com/user-attachments/assets/00f764be-be39-4fc3-906b-4a77f1e858a9" />


Adicionar Tarefa 

<img width="562" height="1230" alt="image" src="https://github.com/user-attachments/assets/cab6edeb-9bdd-470a-8ba8-c72c3a035321" />


---

## ✨ Funcionalidades

* **Criar Tarefas:** Adicione novas tarefas através de um formulário simples.
* **Listar Tarefas:** Visualize todas as tarefas salvas na tela principal, com data e hora de criação.
* **Editar Tarefas:** Modifique a descrição de tarefas já existentes.
* **Excluir Tarefas:** Remova tarefas da lista com uma caixa de diálogo para confirmação.
* **Persistência de Dados:** As tarefas são armazenadas localmente em um banco de dados SQLite.

---

## 🏛️ Arquitetura e Componentes

O projeto foi estruturado para separar as responsabilidades, seguindo boas práticas de desenvolvimento Android.

### Camada de UI (Interface)
* **`MainActivity.kt`**: Tela principal que exibe a lista de tarefas. Utiliza um `RecyclerView` para renderizar a lista de forma eficiente.
* **`AdicionarTarefaActivity.kt`**: Tela responsável por adicionar uma nova tarefa ou editar uma já existente.
* **`TarefaAdapter.kt`**: Adaptador para o `RecyclerView`, responsável por vincular os dados de cada tarefa ao layout de item (`item_tarefa.xml`) e por capturar os eventos de clique nos botões de editar e excluir.
* **ViewBinding**: Utilizado para acessar os componentes de view de forma segura e concisa.

### Camada de Dados
* **Banco de Dados SQLite**: Sistema de armazenamento local para salvar as tarefas.
* **`DatabaseHelper.kt`**: Classe que herda de `SQLiteOpenHelper`, responsável por criar o banco de dados e a tabela de tarefas, além de gerenciar as versões do schema.
* **Padrão DAO (Data Access Object)**: Utilizado para abstrair o acesso ao banco de dados.
  * **`ITarefaDAO.kt`**: Uma **interface** que define o contrato com as operações que podem ser realizadas no banco (salvar, atualizar, remover, listar).
  * **`TarefaDAO.kt`**: A **implementação** concreta da interface, contendo o código SQL para interagir com a tabela de tarefas.

### Modelo de Dados
* **`Tarefa.kt`**: Uma `data class` que representa o modelo de uma tarefa, contendo `idTarefa`, `descricao` e `dataCadastro`. É `Serializable` para permitir que seja passada entre Activities através de `Intents`.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Kotlin
* **IDE:** Android Studio
* **Banco de Dados:** SQLite
* **Componentes de UI:**
  * `RecyclerView` para listas eficientes.
  * `FloatingActionButton` para ação principal.
  * `AlertDialog` para confirmações.
* **Bibliotecas Jetpack:**
  * `ViewBinding` para manipulação de views.
  * `AppCompat` e `Material Components` para o design.

---

## 🚀 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone <URL_DO_SEU_REPOSITORIO>
    ```

2.  **Abra no Android Studio:**
    * Abra o Android Studio.
    * Selecione "Open an existing Project".
    * Navegue até o diretório onde você clonou o projeto e selecione-o.

3.  **Sincronize e Execute:**
    * Aguarde o Gradle sincronizar todas as dependências do projeto.
    * Clique no botão "Run 'app'" (ícone de play verde) para instalar e executar o aplicativo em um emulador ou dispositivo Android físico.
