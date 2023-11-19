
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;


public class panel extends javax.swing.JPanel {
    int lado = 100;
    int ubix;
    int ubiy;
    int x;
    int y;
    double zoom = 1.0;
     Point p = new Point();
    public panel() {
        initComponents();
        x = 100;
        y = 100;
        
        clippin c = new clippin();
            
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D) g;
        
        //Clipping
        Shape clip = new Rectangle(10,10,100,100);
        g2.setClip(clip);
        g2.setColor(Color.BLUE);
        g2.draw(clip);
        //end clipping
        
        
        
        
        //move in map
        g2.translate(ubix, ubiy);
        g2.fillOval(-5, -5, 10, 10);
        g2.scale(zoom, zoom);
        //end move int the map
        g2.setColor(Color.BLACK);
        g2.drawRect(x,y, 50, 50);
        
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 0, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int xsum = evt.getX() - ubix;
        int ysum = evt.getY() - ubiy;
        //xx = evt.getX();
        //yy = evt.getY();
        x+=xsum;
        y+=ysum;
        //System.out.println(x+" "+y);
       
        repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        ubix = evt.getX();
        ubiy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        
    }//GEN-LAST:event_formMouseMoved

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int click= evt.getClickCount();
        
        System.out.println("cantidad de clicks: "+click);
    }//GEN-LAST:event_formMouseClicked

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        double valor = evt.getPreciseWheelRotation();
        System.out.println("----------------------------------------");
        System.out.println("valor de zoom: "+valor);
        
        //this.setLocation(p);
        System.out.println("Posicion de p: "+evt.getX()+" "+evt.getY());
        
        
        if(valor < 0){
            zoom *= 1.1;
        }
        else{
            zoom /= 1.1;
        }
        repaint();
    }//GEN-LAST:event_formMouseWheelMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
