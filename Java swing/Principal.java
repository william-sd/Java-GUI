import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Olá Mundo!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton button = new JButton("Clique aqui");
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Você clicou no botão!"));

        frame.getContentPane().add(button);

        frame.setVisible(true);
    }
}
