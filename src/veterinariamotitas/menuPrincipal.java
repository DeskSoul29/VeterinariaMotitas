package veterinariamotitas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class menuPrincipal extends JFrame {
    
    public menuPrincipal(){
        
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Veterinaria Motitas");
        this.setLocationRelativeTo(null);
        
        JPanel panel =new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        //Mascota
        JLabel text=new JLabel();
        text.setText("Mascota");
        text.setBounds(130, 320, 200, 60);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        panel.add(text);
        
        JButton boton=new JButton();
        boton.setBounds(100, 100, 200, 200);
        boton.setFont(new Font("Broadway",Font.BOLD,15));
        boton.setBackground(Color.WHITE);
        boton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(boton);
        
        ImageIcon huella=new ImageIcon("imagenes/huella.png");
        boton.setIcon(new ImageIcon(huella.getImage().getScaledInstance(200, 200,Image.SCALE_SMOOTH)));
        panel.add(boton);
        
        boton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                registroM alumn = new registroM();
                alumn.setVisible(true);
                dispose();            
            }
        });
        
        //Cliente
        JLabel text1=new JLabel();
        text1.setText("Cliente");
        text1.setFont(new Font("Broadway",Font.BOLD,30));
        text1.setBounds(420, 320, 200, 60);
        panel.add(text1);
        
        JButton boton2=new JButton();
        boton2.setBounds(390, 120, 180, 180);
        boton2.setFont(new Font("Broadway",Font.BOLD,15));
        boton2.setBackground(Color.WHITE);
        boton2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(boton2);
        
        ImageIcon usuario=new ImageIcon("imagenes/usuario.png");
        boton2.setIcon(new ImageIcon(usuario.getImage().getScaledInstance(180, 180,Image.SCALE_SMOOTH)));
        panel.add(boton2);
        
        boton2.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                registroP alumn = new registroP();
                alumn.setVisible(true);
                dispose();            
            }
        });
        
        //Administrador
        JLabel text2=new JLabel();
        text2.setText("Administrador");
        text2.setBounds(660, 320, 300, 60);
        text2.setForeground(Color.BLACK);
        text2.setFont(new Font("Broadway",Font.BOLD,30));
        panel.add(text2);
        
        JButton boton1=new JButton();
        boton1.setBounds(690, 120, 180, 180);
        boton1.setFont(new Font("Broadway",Font.BOLD,15));
        boton1.setBackground(Color.WHITE);
        boton1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(boton1);
        
        ImageIcon admi=new ImageIcon("imagenes/admin1.png");
        boton1.setIcon(new ImageIcon(admi.getImage().getScaledInstance(180, 180,Image.SCALE_SMOOTH)));
        panel.add(boton1);
        
        boton1.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                admin alumn = new admin();
                alumn.setVisible(true);
                dispose();            
            }
        });
                
    }    
    
   }