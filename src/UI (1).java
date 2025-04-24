import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
class UI extends JFrame implements MouseListener {
    private final List<MovingCircle> circles = new ArrayList<>();
    public UI() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(this);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (MovingCircle circle : circles) {
            circle.paint(g);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        MovingCircle newCircle = new MovingCircle(e.getX(), e.getY(), this);
        circles.add(newCircle);
        newCircle.start();
    }
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
