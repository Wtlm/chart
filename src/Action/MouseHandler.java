package Action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Interface.Panel;

public class MouseHandler implements MouseListener{
    Panel panel;

    public MouseHandler(Panel panel) {
        this.panel = panel;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (panel.option.isIn(e, panel.option.pie1))
            panel.option.choosePie = 1;
        else panel.option.choosePie = 0;
        
        if (panel.option.isIn(e, panel.option.bar1)){
            panel.option.chooseBar = 1;
            System.out.println("hahaha");
        }
        else panel.option.chooseBar = 0;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!panel.option.isIn(e, panel.option.pie1))
            panel.option.choosePie = 0;
        else if (!panel.option.isIn(e, panel.option.bar1))
            panel.option.chooseBar = 0;

    }

}
