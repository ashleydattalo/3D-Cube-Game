import java.util.*;
import java.util.Random;
public class Cube {
    private int x, y, l, w, h, a;
    private int xRatio, yRatio;
    private boolean isClicked;
    public Cube(int x, int y, int l, int h, int w) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.h = h;
        this.w = w;
        this.a = (int) Math.sqrt(w*w/2);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return w;
    }
    public int getHeight() {
        return h;
    }
    public int getLength() {
        return l;
    }
    public int getA() {
        return a;
    }
    public void setCord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean inRect(int mX, int mY) {
        boolean inRect = false;
        if(mX >= x && mX <= x+l+a) {
            //x boundaries
            if(mY <= y && mY >= y-h-a) {
                //y boundaries
                boolean upperTri = mX>=x && mX<=x+a && mY>= y-l-(mX-x);
                boolean lowerTri = mX>=x+l && mX<=x+l+a && mY<= y-(mX-x-l);
                inRect = !upperTri || !lowerTri;
            }
        }
        
        return inRect;
    }
    public void setRatios( int x, int y ) {
        xRatio = x;
        yRatio = y;
    }
    public int getXRatio() {
        return xRatio;
    }
    public int getYRatio() {
        return yRatio;
    }
    public boolean getIsClicked() {
        return isClicked;
    }
    public void setIsClicked(boolean clicked) {
        isClicked = clicked;
    }
}