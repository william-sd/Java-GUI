# Explicação do Código

## Importações

```java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
```

As bibliotecas importadas são necessárias para:
- **`java.awt`**: Gerenciamento de layouts e eventos.
- **`javax.swing`**: Criação de componentes de interface gráfica como `JFrame`, `JTextField`, `JButton` e `JTable`.
- **`javax.swing.table.DefaultTableModel`**: Manipulação de dados exibidos na tabela.

---

## Estrutura Principal

### Configuração da Janela Principal

```java
JFrame frame = new JFrame("Formulário com Tabela");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(500, 400);
frame.setLayout(new BorderLayout());
```

- Cria uma janela principal (`JFrame`) com o título "Formulário com Tabela".
- Define o comportamento de fechamento da janela como encerramento da aplicação.
- Define o tamanho da janela (500x400 pixels).
- Utiliza o layout `BorderLayout` para organizar os componentes.

---

### Painel do Formulário

```java
JPanel formPanel = new JPanel(new GridLayout(3, 2));
```

- Cria um painel para organizar os campos de entrada usando o layout `GridLayout` com 3 linhas e 2 colunas.

```java
JLabel nameLabel = new JLabel("Nome:");
JTextField nameField = new JTextField();
JLabel emailLabel = new JLabel("E-mail:");
JTextField emailField = new JTextField();
JButton addButton = new JButton("Adicionar");
```

- Cria os componentes do formulário:
  - `JLabel`: Rótulos para identificar os campos.
  - `JTextField`: Campos de texto para entrada de dados.
  - `JButton`: Botão para adicionar os dados na tabela.

Os componentes são adicionados ao painel:

```java
formPanel.add(nameLabel);
formPanel.add(nameField);
formPanel.add(emailLabel);
formPanel.add(emailField);
formPanel.add(new JLabel()); // Espaço vazio
formPanel.add(addButton);
```

---

### Configuração da Tabela

```java
String[] columnNames = {"Nome", "E-mail"};
DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
JTable table = new JTable(tableModel);
JScrollPane tableScrollPane = new JScrollPane(table);
```

- Define as colunas da tabela (`Nome` e `E-mail`).
- Usa `DefaultTableModel` para gerenciar os dados da tabela.
- Cria uma tabela (`JTable`) e a envolve em um painel com barra de rolagem (`JScrollPane`).

---

### Configuração do Botão de Adição

```java
addButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();

        if (!name.isEmpty() && !email.isEmpty()) {
            tableModel.addRow(new Object[]{name, email});
            nameField.setText("");
            emailField.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
});
```

- Configura um ouvinte de eventos para o botão `addButton`.
- Verifica se os campos de texto estão preenchidos:
  - Se sim: Adiciona os valores como uma nova linha na tabela e limpa os campos.
  - Se não: Exibe uma mensagem de erro usando `JOptionPane`.

---

### Adicionando Componentes à Janela

```java
frame.add(formPanel, BorderLayout.NORTH);
frame.add(tableScrollPane, BorderLayout.CENTER);
```

- O painel do formulário é adicionado na parte superior da janela (`BorderLayout.NORTH`).
- A tabela com barra de rolagem é adicionada ao centro da janela (`BorderLayout.CENTER`).

---

### Tornando a Janela Visível

```java
frame.setVisible(true);
```

- Exibe a janela para o usuário.

---
