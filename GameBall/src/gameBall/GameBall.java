package gameBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBall extends JFrame {

    private JLabel jLabelBarra;
    private JLabel jLabelPelota;
    private int posicionBarraX;
    private int posicionPelotaX;
    private int posicionPelotaY;
    private int velocidadPelotaX;
    private int velocidadPelotaY;
    Timer timer;

    public GameBall() {
        // Configura el JFrame
        setTitle("Game Ball");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null);
        setFocusable(true);
        setLocationRelativeTo(null);
        setResizable(false);
        requestFocusInWindow();

        // Configura la posición inicial de la barra
        posicionBarraX = 150;

        // Crea la barra
        jLabelBarra = new JLabel();
        jLabelBarra.setBackground(Color.GRAY);
        jLabelBarra.setOpaque(true);
        int barraHeight = 17;
        jLabelBarra.setBounds(posicionBarraX, getHeight() - barraHeight - 30, 100, barraHeight);

        // Crea la pelota
        posicionPelotaX = 200;
        posicionPelotaY = 200;
        velocidadPelotaX = 5;
        velocidadPelotaY = 5;

        jLabelPelota = new JLabel();
        jLabelPelota.setBounds(5, 5, 50, 50);
        jLabelPelota.setIcon(new ImageIcon("img/pelota.png"));
        jLabelPelota.setOpaque(true);

        add(jLabelBarra);
        add(jLabelPelota);

        // Agrega un KeyListener para mover la barra
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    // Mover la barra hacia la izquierda
                    if (posicionBarraX > 0) {
                        posicionBarraX -= 15;
                        jLabelBarra.setLocation(posicionBarraX, jLabelBarra.getY());
                    }
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    // Mover la barra hacia la derecha
                    if (posicionBarraX + jLabelBarra.getWidth() < getWidth()) {
                        posicionBarraX += 15;
                        jLabelBarra.setLocation(posicionBarraX, jLabelBarra.getY());
                    }
                }
            }
        });

        // Inicia un temporizador para mover la pelota
        timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mueve la pelota
                posicionPelotaX += velocidadPelotaX;
                posicionPelotaY += velocidadPelotaY;

                // Rebote en los bordes del JFrame
                if (posicionPelotaX <= 0 || posicionPelotaX + jLabelPelota.getWidth() >= getWidth()) {
                    velocidadPelotaX = -velocidadPelotaX;
                }
                if (posicionPelotaY <= 0 || posicionPelotaY + jLabelPelota.getHeight() >= getHeight()) {
                    velocidadPelotaY = -velocidadPelotaY;
                }

                // Colisión con la barra
                if (jLabelPelota.getBounds().intersects(jLabelBarra.getBounds())) {
                    velocidadPelotaY = -Math.abs(velocidadPelotaY);
                }

                // Colisión con nivel inferior (Game Over)
                if (posicionPelotaY + jLabelPelota.getHeight() >= getHeight()) {
                    timer.stop();
                    int option = JOptionPane.showConfirmDialog(null, "Game Over!!! :(\n¿Nuevo juego?", "Game Over", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        reiniciarJuego();
                    } else {
                        System.exit(0);
                    }
                }

                // Mover la pelota a su nueva posición
                jLabelPelota.setLocation(posicionPelotaX, posicionPelotaY);
            }
        });
        timer.start();

        setVisible(true);
    }

    private void reiniciarJuego() {
        // Restablecer la posición de la barra y la pelota
        posicionBarraX = 150;
        jLabelBarra.setLocation(posicionBarraX, jLabelBarra.getY());
        posicionPelotaX = 200;
        posicionPelotaY = 200;
        jLabelPelota.setLocation(posicionPelotaX, posicionPelotaY);

        // Reiniciar el temporizador
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameBall();
        });
    }
}
