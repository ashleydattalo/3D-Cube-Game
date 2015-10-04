import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import java.applet.Applet;
import java.util.Random;
public class CubeDriver extends JApplet implements MouseListener, MouseMotionListener{
    int mouseX, mouseY;
    int mouseMovedX, mouseMovedY;
    int x, y, l, w, h, a;
    int numCubes = 10;
    //Cube [] cubes = new Cube[numCubes];
    Cube cube = new Cube(300,300,300,300,200);
    public void paint(Graphics g){
      Graphics2D g2 = (Graphics2D) g;
      g.clearRect(0, 0, 2000, 2000);
      
      //prints out a 'ruler' on the board
      for(int x = 0; x < 2000; x = x + 50)
      {
          g.drawString("-"+ x, 0, x);
          g.drawString("|", x, 10);
          g.drawString(""+x, x, 20);
      }
      getCube(g);
      g.drawString("mouseMovedX "+ (mouseMovedX), 400,360);
      g.drawString("mouseMovedY "+ (mouseMovedY), 400,380);
    }
    public void getCube(Graphics g) { 
        //for(int i = 0; i < numCubes; i++) { 
            Random rnd = new Random();
            //Cube cube = new Cube(rnd.nextInt(400),rnd.nextInt(400)+300,rnd.nextInt(100),rnd.nextInt(100),rnd.nextInt(50));
            //cubes[i] = cube;
            x = cube.getX();
            y = cube.getY();
            l = cube.getLength();
            h = cube.getHeight();
            a = cube.getA();
            drawFrontCube(g);
            drawBehindCube(g);
            drawLines(g);
          
        //}
    }
     public void drawFrontCube(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle frontRect = new Rectangle(x, y-h, l, h);
        g2.draw(frontRect);
    }
    public void drawBehindCube(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle behindRect = new Rectangle(x+a, y-h-a, l, h);
        g2.draw(behindRect);
        /*for(int i = 0; i < numCubes; i++) { 
           Cube cube = cubes[i];
           */
           if(cube.getIsClicked()) {
                g.setColor(new Color(.3f, .4f, .5f, .6f));
                g2.fill(behindRect);
            }
        
    }
    public void drawLines(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawLine(x, y-h, x+a, y-h-a);
        g2.drawLine(x+l, y-h, x+l+a, y-a-h);
        g2.drawLine(x, y, x+a, y-a);
        g2.drawLine(x+l, y, x+l+a, y-a);
    }
    public void init(){
      addMouseListener(this);
      addMouseMotionListener(this);
    }
    public void mouseClicked(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        //for(int i = 0; i < numCubes; i++) { 
           //Cube cube = cubes[i];
           if(cube.inRect(mouseX, mouseY)) {
               cube.setRatios(mouseX-cube.getX(), mouseY-cube.getY());
               cube.setIsClicked( !cube.getIsClicked() );
               //clickedCube = cubes[i];
           } 
        //}
        repaint();
    }
    public void mouseMoved(MouseEvent e) {
        mouseMovedX = e.getX();
        mouseMovedY = e.getY();
        
        if(cube.getIsClicked()) {
            cube.setCord(mouseMovedX-cube.getXRatio(), mouseMovedY-cube.getYRatio());
            repaint();
        }    
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    
}