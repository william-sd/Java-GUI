# Explicação do Código: CRUD com Java Swing


## Importações

```java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
```

- **`javax.swing`**: Usado para criar componentes gráficos como botões, tabelas e janelas.
- **`javax.swing.table.DefaultTableModel`**: Facilita a manipulação dos dados exibidos na tabela.
- **`java.awt`**: Fornece classes para layouts e gerenciamento de interface.
- **`java.awt.event`**: Permite tratar eventos como cliques em botões.

---

## Estrutura Principal

### Configuração da Janela Principal

```java
JFrame frame = new JFrame("CRUD com Java Swing");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(600, 400);
frame.setLayout(new BorderLayout());
```

- **`JFrame`**: Cria a janela principal com título "CRUD com Java Swing".
- **`setDefaultCloseOperation`**: Configura a aplicação para encerrar ao fechar a janela.
- **`setSize`**: Define o tamanho da janela (600x400 pixels).
- **`setLayout`**: Usa o layout `BorderLayout` para organizar os componentes.

---

### Painel do Formulário

```java
JPanel formPanel = new JPanel(new GridLayout(4, 2));
```

- **`JPanel`**: Cria um painel para os campos do formulário.
- **`GridLayout`**: Organiza os componentes em 4 linhas e 2 colunas.

Os componentes do formulário incluem:

```java
JLabel idLabel = new JLabel("ID:");
JTextField idField = new JTextField();
JLabel nameLabel = new JLabel("Nome:");
JTextField nameField = new JTextField();
JLabel emailLabel = new JLabel("E-mail:");
JTextField emailField = new JTextField();
JButton addButton = new JButton("Adicionar");
JButton updateButton = new JButton("Atualizar");
```

- **`JLabel`**: Exibe rótulos para os campos.
- **`JTextField`**: Campos de entrada de texto.
- **`JButton`**: Botões para ações de adicionar e atualizar registros.

Os componentes são adicionados ao painel:

```java
formPanel.add(idLabel);
formPanel.add(idField);
formPanel.add(nameLabel);
formPanel.add(nameField);
formPanel.add(emailLabel);
formPanel.add(emailField);
formPanel.add(addButton);
formPanel.add(updateButton);
```

---

### Configuração da Tabela

```java
String[] columnNames = {"ID", "Nome", "E-mail"};
DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
JTable table = new JTable(tableModel);
JScrollPane tableScrollPane = new JScrollPane(table);
```

- **`columnNames`**: Define os nomes das colunas.
- **`DefaultTableModel`**: Gerencia os dados exibidos na tabela.
- **`JTable`**: Exibe os dados em formato tabular.
- **`JScrollPane`**: Adiciona uma barra de rolagem à tabela.

---

### Botão de Exclusão

```java
JButton deleteButton = new JButton("Excluir");
JPanel deletePanel = new JPanel();
deletePanel.add(deleteButton);
```

- Cria um botão e um painel para exclusão de registros.

---

## Listeners para Botões

### Botão Adicionar

```java
addButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();

        if (!id.isEmpty() && !name.isEmpty() && !email.isEmpty()) {
            tableModel.addRow(new Object[]{id, name, email});
            idField.setText("");
            nameField.setText("");
            emailField.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
});
```

- Adiciona uma nova linha à tabela com os dados do formulário, após validar os campos.

---

### Botão Atualizar

```java
updateButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();

            if (!id.isEmpty() && !name.isEmpty() && !email.isEmpty()) {
                tableModel.setValueAt(id, selectedRow, 0);
                tableModel.setValueAt(name, selectedRow, 1);
                tableModel.setValueAt(email, selectedRow, 2);
                idField.setText("");
                nameField.setText("");
                emailField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Selecione uma linha para atualizar!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
});
```

- Atualiza os dados da linha selecionada na tabela.

---

### Botão Excluir

```java
deleteButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Selecione uma linha para excluir!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
});
```

- Remove a linha selecionada da tabela.

---

## Seleção na Tabela

```java
table.getSelectionModel().addListSelectionListener(e -> {
    int selectedRow = table.getSelectedRow();

    if (selectedRow != -1) {
        idField.setText(tableModel.getValueAt(selectedRow, 0).toString());
        nameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
        emailField.setText(tableModel.getValueAt(selectedRow, 2).toString());
    }
});
```

- Exibe os dados da linha selecionada nos campos do formulário.

---

## Adicionando Componentes à Janela

```java
frame.add(formPanel, BorderLayout.NORTH);
frame.add(tableScrollPane, BorderLayout.CENTER);
frame.add(deletePanel, BorderLayout.SOUTH);
```

- Adiciona o formulário, a tabela e o botão de exclusão à janela principal.

---

