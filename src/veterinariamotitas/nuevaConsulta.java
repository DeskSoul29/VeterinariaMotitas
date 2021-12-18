package veterinariamotitas;

import Conexion.Conectar;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static veterinariamotitas.historiaClinica.cajacliente;


public class nuevaConsulta extends JFrame{
    
    public static String idMasc;
    
    public nuevaConsulta(){
        this.setLocationRelativeTo(null); 
          main();
    }
    
    public void main(){
        
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Nueva Consulta");
        this.setLocationRelativeTo(null);
        
        JPanel panel =new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        JLabel text=new JLabel();
        text.setText("Nueva Consulta");
        text.setBounds(200, 50, 380, 60);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        panel.add(text);
        
        JLabel text1=new JLabel();
        text1.setText("Valoración");
        text1.setBounds(100, 130, 380, 60);
        text1.setForeground(Color.BLUE);
        text1.setFont(new Font("Broadway",Font.BOLD,30));
        panel.add(text1);
        
        JTextArea cajaValoracion = new JTextArea(10,40);
        cajaValoracion.setBounds(320,140,400,130);
        cajaValoracion.setFont(new Font("Broadway",Font.BOLD,15));
        cajaValoracion.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        cajaValoracion.setBackground(Color.WHITE);
        panel.add(cajaValoracion);
        
         JLabel text2=new JLabel();
        text2.setText("Diagnostico");
        text2.setBounds(100, 300, 380, 60);
        text2.setForeground(Color.BLUE);
        text2.setFont(new Font("Broadway",Font.BOLD,30));
        panel.add(text2);
        
        JTextArea cajaDiagnostico = new JTextArea(10,40);
        cajaDiagnostico.setBounds(320,300,400,130);
        cajaDiagnostico.setFont(new Font("Broadway",Font.BOLD,15));
        cajaDiagnostico.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        cajaDiagnostico.setBackground(Color.WHITE);
        panel.add(cajaDiagnostico);
        
        JButton botonRegistrar=new JButton();
        botonRegistrar.setText("Registrar");
        botonRegistrar.setBounds(100, 430, 180, 60);
        botonRegistrar.setFont(new Font("Broadway",Font.BOLD,15));
        panel.add(botonRegistrar);
        
        ActionListener oyente = new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent ae) {
                
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();
               
               String numero1=cajaValoracion.getText();
               String numero2=cajaDiagnostico.getText();
               String numero3=idMasc;
              
              
              if(numero1.equalsIgnoreCase("") || numero2.equalsIgnoreCase("") ){
                  JOptionPane.showMessageDialog(null, "Debe diligenciar todos los datos");
              }else{
                  try{
                         PreparedStatement ps = con.prepareStatement("INSERT INTO consulta (valoracion_cons, diagnostico_cons, id_masc_cons) VALUES (?,?,?)");
                         ps.setString(1, numero1);
                         ps.setString(2, numero2);
                         ps.setString(3, numero3);

                         ps.executeUpdate();
                         
                         JOptionPane.showMessageDialog(null, "Agregado Correctamente");
                         
                         dispose();

                     }catch (Exception e){
                          System.out.println("Error al insertar, "+e);

                     }
                  
              }
                
            
            }
         
        };
        botonRegistrar.addActionListener(oyente);
        
        
    }
}