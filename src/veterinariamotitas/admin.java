
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
import javax.swing.JPanel;


public class admin extends JFrame {
    
    
    public admin(){
        
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Veterinaria Motitas");
        this.setLocationRelativeTo(null);
        
        JPanel panel =new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        //Servicios
        JLabel text=new JLabel();
        text.setText("Servicios");
        text.setBounds(110, 250, 200, 60);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        panel.add(text);
        
        JButton boton=new JButton();
        boton.setBounds(100, 100, 150, 150);
        boton.setFont(new Font("Broadway",Font.BOLD,15));
        boton.setBackground(Color.WHITE);
        boton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(boton);
        
        ImageIcon huella=new ImageIcon("imagenes/huella2.png");
        boton.setIcon(new ImageIcon(huella.getImage().getScaledInstance(150, 150,Image.SCALE_SMOOTH)));
        panel.add(boton);
        
        boton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                serviciosR alumn = new serviciosR();
                alumn.setVisible(true);
                dispose();            
            }
        });
        
        //Productos
        JLabel text1=new JLabel();
        text1.setText("Productos");
        text1.setFont(new Font("Broadway",Font.BOLD,30));
        text1.setBounds(390, 260, 200, 60);
        panel.add(text1);
        
        JButton boton3=new JButton();
        boton3.setBounds(400, 120, 150, 150);
        boton3.setFont(new Font("Broadway",Font.BOLD,15));
        boton3.setBackground(Color.WHITE);
        boton3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(boton3);
        
        ImageIcon producto=new ImageIcon("imagenes/productos.png");
        boton3.setIcon(new ImageIcon(producto.getImage().getScaledInstance(150, 150,Image.SCALE_SMOOTH)));
        panel.add(boton3);
        
        boton3.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                productosR alumn = new productosR();
                alumn.setVisible(true);
                dispose();            
            }
        });
        
        //Historial
        JLabel text2=new JLabel();
        text2.setText("Historial");
        text2.setBounds(720, 270, 200, 60);
        text2.setForeground(Color.BLACK);
        text2.setFont(new Font("Broadway",Font.BOLD,30));
        panel.add(text2);
        
        JButton boton1=new JButton();
        boton1.setBounds(700, 100, 180, 180);
        boton1.setFont(new Font("Broadway",Font.BOLD,15));
        boton1.setBackground(Color.WHITE);
        boton1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(boton1);
        
        ImageIcon usu=new ImageIcon("imagenes/historial.png");
        boton1.setIcon(new ImageIcon(usu.getImage().getScaledInstance(180, 180,Image.SCALE_SMOOTH)));
        panel.add(boton1);
        
        boton1.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                historialVisitas alumn = new historialVisitas();
                alumn.setVisible(true);
                dispose();            
            }
        });
        
        //Facturacion
        JLabel text3=new JLabel();
        text3.setText("Facturación");
        text3.setFont(new Font("Broadway",Font.BOLD,30));
        text3.setBounds(180, 520, 250, 60);
        panel.add(text3);
        
        JButton boton2=new JButton();
        boton2.setBounds(220, 360, 150, 150);
        boton2.setFont(new Font("Broadway",Font.BOLD,15));
        boton2.setBackground(Color.WHITE);
        boton2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(boton2);
       
        ImageIcon factura=new ImageIcon("imagenes/factura.png");
        boton2.setIcon(new ImageIcon(factura.getImage().getScaledInstance(150, 150,Image.SCALE_SMOOTH)));
        panel.add(boton2);
       
        boton2.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                factura alumn = new factura();
                alumn.setVisible(true);
                dispose();            
            }
        });
        
        
        //Historia Clinica       
        JLabel text4=new JLabel();
        text4.setText("Historia Clinica");
        text4.setFont(new Font("Broadway",Font.BOLD,30));
        text4.setBounds(500, 520, 350, 60);
        panel.add(text4);
        
        JButton boton4=new JButton();
        boton4.setBounds(560, 360, 150, 150);
        boton4.setFont(new Font("Broadway",Font.BOLD,15));
        boton4.setBackground(Color.WHITE);
        boton4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(boton4);
       
        ImageIcon historiaC=new ImageIcon("imagenes/historiC.png");
        boton4.setIcon(new ImageIcon(historiaC.getImage().getScaledInstance(150, 150,Image.SCALE_SMOOTH)));
        panel.add(boton4);
        
        boton4.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                historiaClinica alumn = new historiaClinica();
                alumn.setVisible(true);
                dispose();            
            }
        });
       
        //Volver
        JButton botonT=new JButton();
        botonT.setBounds(10, 10, 80, 80);
        botonT.setFont(new Font("Broadway",Font.BOLD,15));
        botonT.setBackground(Color.WHITE);
        botonT.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(botonT);
        
        ImageIcon back = new ImageIcon("imagenes/back.png");
        botonT.setIcon(new ImageIcon(back.getImage().getScaledInstance(80, 80,Image.SCALE_SMOOTH)));
        panel.add(botonT);
        botonT.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                menuPrincipal alumn = new menuPrincipal();
                alumn.setVisible(true);
                dispose();
            }
        });
    }    
      

    
   }