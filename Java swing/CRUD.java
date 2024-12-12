import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CRUD {

    public static void main(String[] args) {
        JFrame frame = new JFrame("CRUD com Java Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("E-mail:");
        JTextField emailField = new JTextField();
        JButton addButton = new JButton("Adicionar");
        JButton updateButton = new JButton("Atualizar");
        JButton deleteButton = new JButton("Excluir");

        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(addButton);
        formPanel.add(updateButton);

        String[] columnNames = {"ID", "Nome", "E-mail"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        JPanel deletePanel = new JPanel();
        deletePanel.add(deleteButton);

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

        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1) {
                idField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                nameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                emailField.setText(tableModel.getValueAt(selectedRow, 2).toString());
            }
        });

        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(tableScrollPane, BorderLayout.CENTER);
        frame.add(deletePanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
