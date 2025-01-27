package com.nenu.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 1.使用KeyListener进行键盘监听控制图形移动
 */

public class BallMove extends JFrame {

    MyPanel myPane = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();

    }

    public BallMove() {

        myPane = new MyPanel();
        this.add(myPane);
        this.setSize(400, 300);
        //将myPane加入进行监听
        this.addKeyListener(myPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}

class MyPanel extends JPanel implements KeyListener {

    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void keyTyped(KeyEvent e) {//字符输出时触发

    }

    @Override
    public void keyPressed(KeyEvent e) {//某个键按下触发
//        System.out.println((char) e.getKeyCode()+"被触发...");
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }

        //坐标移动后需要重绘 不然不会动
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {//某个键松开触发

    }
}