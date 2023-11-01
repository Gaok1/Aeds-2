import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BrickBreaker extends JPanel implements ActionListener {
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private int ballX = 120; // Posição inicial da bola no eixo X
    private int ballY = 650; // Posição inicial da bola no eixo Y
    private int ballDirX = 1; // Direção da bola no eixo X
    private int ballDirY = 2; // Direção da bola no eixo Y
    private int paddleX = 100; // Posição inicial da raquete no eixo X
    private int paddleWidth = 100; // Largura da raquete
    private int brickRows = 3; // Número de fileiras de tijolos
    private int brickCols = 7; // Número de colunas de tijolos
    private int brickWidth = 60; // Largura de um tijolo
    private int brickHeight = 20; // Altura de um tijolo
    private boolean bricks[][] = new boolean[brickRows][brickCols]; // Matriz de tijolos

    public BrickBreaker() {
        // Inicializar a matriz de tijolos
        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickCols; j++) {
                bricks[i][j] = true;
            }
        }

        // Configurar o temporizador para atualizar o jogo
        Timer timer = new Timer(10, this);
        timer.start();

        // Adicionar ouvintes de teclado para controlar a raquete
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = false;
                }
            }
        });
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Atualizar a posição da bola
        ballX += ballDirX+3;
        ballY += ballDirY+3;

        // Colisão com as paredes
        if (ballX <= 0 || ballX >= getWidth()) {
            ballDirX = -ballDirX;
        }
        if (ballY <= 0) {
            ballDirY = -ballDirY;
        }

        // Colisão com a raquete
        if (ballY >= getHeight() - 20 && (ballX >= paddleX && ballX <= paddleX + paddleWidth)) {
            ballDirY = -ballDirY;
        }

        // Colisão com os tijolos
        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickCols; j++) {
                if (bricks[i][j]) {
                    int brickX = j * brickWidth;
                    int brickY = i * brickHeight;
                    if (ballX >= brickX && ballX <= brickX + brickWidth && ballY >= brickY
                            && ballY <= brickY + brickHeight) {
                        ballDirY = -ballDirY;
                        bricks[i][j] = false;
                    }
                }
            }
        }

        // Atualizar a posição da raquete com base nos controles de teclado
        if (leftPressed && paddleX > 0) {
            paddleX -= 6;
        }
        if (rightPressed && paddleX < getWidth() - paddleWidth) {
            paddleX += 6;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenhar a bola
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, 20, 20);

        // Desenhar a raquete
        g.setColor(Color.BLUE);
        g.fillRect(paddleX, getHeight() - 20, paddleWidth, 10);

        // Desenhar os tijolos
        g.setColor(Color.GREEN);
        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickCols; j++) {
                if (bricks[i][j]) {
                    int brickX = j * brickWidth;
                    int brickY = i * brickHeight;
                    g.fillRect(brickX, brickY, brickWidth, brickHeight);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Brick Breaker");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.add(new BrickBreaker());
            frame.setVisible(true);
        });
    }
}
