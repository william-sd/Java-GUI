import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Formulario {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulário com Tabela");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("E-mail:");
        JTextField emailField = new JTextField();
        JButton addButton = new JButton("Adicionar");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(new JLabel()); // Espaço vazio
        formPanel.add(addButton);

        String[] columnNames = {"Nome", "E-mail"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

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

        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(tableScrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
