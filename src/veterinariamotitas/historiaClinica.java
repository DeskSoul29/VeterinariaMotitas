
package veterinariamotitas;

import Conexion.Conectar;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import static veterinariamotitas.newFactura.caja4;
import static veterinariamotitas.newVisit.caja;
import static veterinariamotitas.newVisit.caja1;


public class historiaClinica extends JFrame {
    
    public static JTextField cajamascota = new JTextField();
     public static JTextField cajacliente = new JTextField();
     public static String idMascota;
     public static JLabel labelRaza=new JLabel();
    public static JLabel labelEspecie=new JLabel();
    
    private JPanel contentPane;
    public static javax.swing.JTable jt1;

    public historiaClinica() {
        this.setLocationRelativeTo(null); 
          main();
    }
    
    public  String[][] my_db_select() {
          String[][] data = new String[10][10]; // [rows][columns]
	
          try{  
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();

               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("SELECT `consulta`.`fecha_cons`, `consulta`.`valoracion_cons`, `consulta`.`diagnostico_cons`" +
                                        "FROM `consulta` "
                                        + "LEFT JOIN `mascota` ON `mascota`.`id_masc` = `consulta`.`id_masc_cons`"
                                        + "WHERE mascota.id_masc = "+ idMascota +";");
               
               int i=0;
               
               while(rs.next())  {
                    for(int j=0;j<3;j++) {
                         data[i][j]=rs.getString(j+1);
                    }
                    i=i+1;
               }

          con.close();  
          }catch(Exception e){ 
               System.out.println(e);
          } 

          return data;
     }
     
     
    
    public void crearTabla(){
          JScrollPane scrollPane = new JScrollPane();
          scrollPane.setBounds(200, 280, 366, 107);
          contentPane.add(scrollPane);
          String[] column= {"Fecha Consulta","Valoración","Diagnostico"};

          jt1 = new JTable(my_db_select(),column);
          scrollPane.setViewportView(jt1);
     }
    
    
    
    public void main(){
        
        this.setSize(800,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Historia Clinica");
        this.setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null);
       
        
        JLabel text=new JLabel();
        text.setText("Historia Clinica");
        text.setBounds(200, 5, 380, 60);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        contentPane.add(text);
        
        
        JLabel text1=new JLabel();
        text1.setText("Mascota: ");
        text1.setBounds(100, 50, 200, 60);
        text1.setFont(new Font("Broadway",Font.BOLD,20));
        contentPane.add(text1);
        
        cajamascota.setBounds(330,50,260,40);
        cajamascota.setFont(new Font("Broadway",Font.BOLD,15));
        cajamascota.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        cajamascota.setBackground(Color.WHITE);
        cajamascota.setEnabled(false); 
        contentPane.add(cajamascota);  
        
        
        JButton botonS = new JButton();
        botonS.setText("Buscar");
        botonS.setBounds(590,50,120,40);
        botonS.setFont(new Font("Broadway",Font.BOLD,15));
        contentPane.add(botonS);
        
        botonS.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                historiaClinicaSuperior alumn = new historiaClinicaSuperior();
                alumn.setVisible(true);
            }
        });
        
        
        JLabel text2=new JLabel();
        text2.setText("Propietario: ");
        text2.setBounds(100, 80, 200, 60);
        text2.setFont(new Font("Broadway",Font.BOLD,20));
        contentPane.add(text2);
        
        cajacliente.setBounds(330,80,260,40);
        cajacliente.setFont(new Font("Broadway",Font.BOLD,15));
        cajacliente.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        cajacliente.setBackground(Color.WHITE);
        cajacliente.setEnabled(false); 
        contentPane.add(cajacliente);
        
        JLabel text3=new JLabel();
        text3.setText("Reporte Historia Clinica");
        text3.setBounds(150, 110, 500, 60);
        text3.setForeground(Color.BLUE);
        text3.setFont(new Font("Broadway",Font.BOLD,30));
        contentPane.add(text3);
        
        JLabel text4=new JLabel();
        text4.setText("Especie: ");
        text4.setBounds(100, 140, 200, 60);
        text4.setFont(new Font("Broadway",Font.BOLD,20));
        contentPane.add(text4);
        
        labelEspecie.setText("...aqui va la especie");
        labelEspecie.setBounds(220, 140, 400, 60);
        labelEspecie.setFont(new Font("Broadway",Font.BOLD,20));
        contentPane.add(labelEspecie);
        
        JLabel text6=new JLabel();
        text6.setText("Raza: ");
        text6.setBounds(100, 170, 200, 60);
        text6.setFont(new Font("Broadway",Font.BOLD,20));
        contentPane.add(text6);
        
        labelRaza.setText("...aqui va la raza");
        labelRaza.setBounds(220, 170, 400, 60);
        labelRaza.setFont(new Font("Broadway",Font.BOLD,20));
        contentPane.add(labelRaza);
        
        JButton botonMostrarHistClinic = new JButton();
        botonMostrarHistClinic.setText("Mostrar historial clinico");
        botonMostrarHistClinic.setBounds(500,180,260,40);
        botonMostrarHistClinic.setFont(new Font("Broadway",Font.BOLD,15));
        contentPane.add(botonMostrarHistClinic);
        
        botonMostrarHistClinic.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(cajacliente.getText().equalsIgnoreCase("")){
                      JOptionPane.showMessageDialog(null, "Debe seleccionar una Mascota", "Error", JOptionPane.WARNING_MESSAGE);
                }else{
                     crearTabla();
                }
            }
        });
        
        JLabel text8=new JLabel();
        text8.setText("Valoración y Diagnostico");
        text8.setBounds(150, 220, 500, 60);
        text8.setForeground(Color.BLUE);
        text8.setFont(new Font("Broadway",Font.BOLD,30));
        contentPane.add(text8);
        
        JButton botonNuevaConsulta = new JButton();
        botonNuevaConsulta.setText("Nueva Consulta");
        botonNuevaConsulta.setBounds(570,280,180,40);
        botonNuevaConsulta.setFont(new Font("Broadway",Font.BOLD,15));
        contentPane.add(botonNuevaConsulta);
        
        botonNuevaConsulta.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
              nuevaConsulta.idMasc = idMascota;
               nuevaConsulta alumn = new nuevaConsulta();
                alumn.setVisible(true);
            }
        });
        
        JButton boton1=new JButton();
        boton1.setBounds(80, 280, 80, 80);
        boton1.setFont(new Font("Broadway",Font.BOLD,15));
        boton1.setBackground(Color.WHITE);
        boton1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        contentPane.add(boton1);
        
        ImageIcon back=new ImageIcon("imagenes/back.png");
        boton1.setIcon(new ImageIcon(back.getImage().getScaledInstance(80, 80,Image.SCALE_SMOOTH)));
        contentPane.add(boton1);
        
        boton1.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                admin alumn = new admin();
                alumn.setVisible(true);
                 dispose();
            }
        });
        
    }
}
