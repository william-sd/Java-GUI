# Explicação do Código

## Importação
```java
import javax.swing.*;
```

A linha acima importa os pacotes da biblioteca Swing, que é usada para criar interfaces gráficas (GUI) em Java. Ela inclui classes como `JFrame`, `JButton` e `JOptionPane` que serão usadas no programa.

---

## Definição da Classe Principal
```java
public class Frame {
    public static void main(String[] args) {
```

A classe `Frame` contém o método `main`, que é o ponto de entrada do programa.

---

## Criação do Frame
```java
JFrame frame = new JFrame("Olá Mundo!");
```

- Cria uma janela (`JFrame`) com o título "Olá Mundo!".
- O `JFrame` é o elemento principal onde os componentes da interface serão adicionados.

```java
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```
- Define a ação de fechamento da janela. `EXIT_ON_CLOSE` encerra a aplicação quando a janela é fechada.

```java
frame.setSize(300, 200);
```
- Define o tamanho da janela como 300 pixels de largura por 200 pixels de altura.

---

## Adição do Botão
```java
JButton button = new JButton("Clique aqui");
```
- Cria um botão com o texto "Clique aqui".

```java
button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Você clicou no botão!"));
```
- Adiciona um *listener* para capturar cliques no botão.
- Quando o botão é clicado, uma janela de diálogo é exibida com a mensagem "Você clicou no botão!".

---

## Adicionando o Botão ao Frame
```java
frame.getContentPane().add(button);
```
- Adiciona o botão ao painel de conteúdo do frame. 
- O painel de conteúdo é onde os componentes visuais (como botões e textos) são exibidos.

---

## Tornando a Janela Visível
```java
frame.setVisible(true);
```
- Torna a janela visível na tela.

---
