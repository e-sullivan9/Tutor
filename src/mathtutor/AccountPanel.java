/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mathtutor;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Eric Sullivan
 */
public class AccountPanel extends JPanel{
    Font myFont;
    JLabel name, accountPic, section, back, help;
    ArrayList<JLabel> sticker;
    JPanel top, bot, buttons, account;
    public AccountPanel(){
        myFont = new Font("Comic Sans MS", Font.BOLD,50);
        //setLayout(new GridLayout(3,1));
        setLayout(new BorderLayout());
        account = new JPanel(new GridLayout(2,1));
        account.setBorder(BorderFactory.createLineBorder(Color.black));
        buildTop();
        buildBot();
        buildButtons();
        account.add(top);
        account.add(bot);
        
        add(account,BorderLayout.CENTER);
               
        add(buttons,BorderLayout.SOUTH);
    }
    private void buildTop() {
        top = new JPanel();
        top.setLayout(new BoxLayout(top,BoxLayout.Y_AXIS));
        top.setBackground(new Color(144,210,144));
        name = new JLabel("John!");
        name.setForeground(Color.WHITE);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setFont(myFont);
        accountPic = new JLabel(new ImageIcon("pirate-clipart.png"));
        accountPic.setAlignmentX(Component.CENTER_ALIGNMENT);
        top.add(name);
        top.add(accountPic);
        section = new JLabel("COUNTING");
        myFont = new Font("Comic Sans MS", Font.BOLD,25);
        section.setFont(myFont);
        section.setAlignmentX(Component.CENTER_ALIGNMENT);
        top.add(section);
    } 
    private void buildBot() {
        bot = new JPanel();
        GridLayout gl =new GridLayout(2,2);
        gl.setHgap(10);
        gl.setVgap(10);
        bot.setLayout(gl);
        sticker = new ArrayList<>();
        bot.setBackground(new Color(144,210,144));
        for(int i = 0;i<4;i++){
            sticker.add(new JLabel(new ImageIcon("PlaceHolder[1].png")));
            sticker.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
            bot.add(sticker.get(i));
        }
        
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void buildButtons() {
        buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons,BoxLayout.X_AXIS));
        buttons.setBorder(BorderFactory.createLineBorder(Color.red));
        back = new JLabel(new ImageIcon("Back.png"));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        back.addMouseListener(new ImageHandler());
        buttons.add(back);
        buttons.add(Box.createRigidArea(new Dimension(5,0)));
        help = new JLabel(new ImageIcon("Q_Mark.png"));
        help.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        help.addMouseListener(new ImageHandler());
        buttons.add(help);
    }
    public class ImageHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e)  
    {  
        if(e.getSource()==help){
            Frame.currentPanel.help();
        }

       JOptionPane.showMessageDialog(null, "Soon");

    }  

    }


}
