/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mathtutor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Eric Sullivan
 */
public class Frame extends JFrame{
    AccountPanel p;
    static TestGeneral currentPanel;
    public Frame(){
        super();
        p = new AccountPanel();
        currentPanel  = new TestGeneral();
        setLayout(new BorderLayout());
        add(p,BorderLayout.WEST);
        add(currentPanel,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800,600));
        pack();
        this.addMouseListener(new ImageHandler());
        setVisible(true);
        setResizable(false);
    
}
        public class ImageHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e)  
    {  
            System.out.println(e.getPoint());
        }
        }
public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
          new Frame();
      }
    });
}
}