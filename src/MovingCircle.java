import java.awt.*;
import java.util.Random;
class MovingCircle extends Thread {
    private int x, y;
    private final UI frame;
    private int dx, dy;
    private final int diameter = 100;
    private final Color color;
    private final Random rand = new Random();
    public MovingCircle(int x, int y, UI frame) {
        this.frame = frame;
        this.x = x - diameter / 2;
        this.y = y - diameter / 2;
        do {
            dx = rand.nextInt(11) - 5;
        } while (dx == 0);

        do {
            dy = rand.nextInt(11) - 5;
        } while (dy == 0);
        color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
    @Override
    public void run() {
        try {
            int topMargin = frame.getInsets().top;
            while (true) {
                Thread.sleep(20);
                x += dx;
                y += dy;
                if (x <= 0 || x + diameter >= frame.getWidth()) {
                    dx *= -1;
                }
                if (y <= topMargin || y + diameter >= frame.getHeight()) {
                    dy *= -1;
                }
                frame.repaint();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
}
