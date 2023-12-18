package Interface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import Stages.Intro;
import Stages.Option;
import Support.Table;

public class Panel extends JPanel implements Runnable {
    public Intro intro;
    public Option option;
    public Table table;
    public int stage;
    public int introStage = 0;
    public int optionStage = 1;
    public boolean run = true;
    public Thread thread;
    BufferedImage bgr;

    public Panel() {
        this.setFocusable(true);
        try {
            intro = new Intro(this);
            option = new Option(this);
            // table = new Table(this);
            bgr = ImageIO.read(new File("D:/DSA/chart/Data/BGR.png"));

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public Panel(Table table) {
        table = new Table(this);
        this.table = table;

    }

    public void startThread() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void update() {
        if (stage == optionStage) {
            if (option.getHeight() > 0) {
                option.setHeight(option.getHeight() - 10);
            }
        }
    }

    @Override
    public void run() {
        long FPS = 60;
        long period = 1000000000 / FPS;
        long beginTime;
        long sleepTime;

        beginTime = System.nanoTime();

        while (run) {

            // if (System.nanoTime() - beginTime >= 100) {
            update();
            // beginTime = System.nanoTime();
            // }

            repaint();
            // System.out.println(option.getHeight());
            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;
            try {
                if (sleepTime > 0)
                    Thread.sleep(sleepTime / 1000000);
                else
                    Thread.sleep(period / 2000000);
            } catch (InterruptedException e) {
                beginTime = System.nanoTime();
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(bgr, 0, 0, 1200, 600, null);
        if (stage == introStage) {
            // intro.draw(g2);
            // table.draw(g2);

        } else if (stage == optionStage)
            option.draw(g2);
        repaint();
    }

}
