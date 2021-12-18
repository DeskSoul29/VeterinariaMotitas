
package veterinariamotitas;

import Conexion.Conectar;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import static veterinariamotitas.historiaClinica.idMascota;
import static veterinariamotitas.visitaSuperior.jt1;

public class historiaClinicaSuperior extends JFrame{
    
    String idMascota;
    String especie,raza;
    
    private JPanel contentPane;
     public static javax.swing.JTable jt1;
    
    public historiaClinicaSuperior(){
    
        this.setLocationRelativeTo(null); 
          main();
    }
    
     public void volver(){

          dispose();
     }
     
     public  String[][] my_db_select() {
          String[][] data = new String[10][10]; // [rows][columns]
	
          try{  
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();

               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("SELECT `cliente`.`id_clien`, `cliente`.`nombre_clien`, `mascota`.`id_masc`, `mascota`.`nombre_masc`, `mascota`.`especie`" +
                                        "FROM `cliente` "
                                        + "LEFT JOIN `mascota` ON `mascota`.`id_prop` = `cliente`.`id_clien`"
                                        + "WHERE mascota.nombre_masc != 'NULL';");
               
               int i=0;
               
               while(rs.next())  {
                    for(int j=0;j<5;j++) {
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
     
     
    public  String[][] my_db_select2() {
          String[][] data = new String[10][10]; // [rows][columns]
	
          try{  
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();

               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("SELECT `mascota`.`especie`, `mascota`.`raza`" +
                                        "FROM `mascota` "
                                        + "WHERE mascota.id_masc = "+ idMascota +";");
               
               int i=0;
               
               while(rs.next())  {
                    for(int j=0;j<2;j++) {
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
          scrollPane.setBounds(200, 164, 366, 107);
          contentPane.add(scrollPane);
          String[] column= {"Cedula","Propietario","id mascota","Mascota","Especie"};

          jt1 = new JTable(my_db_select(),column);
         
          setEventoMouseClicked(jt1);
          scrollPane.setViewportView(jt1);
     }
     
     private void setEventoMouseClicked(JTable tbl){
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
 
        @Override
        public void mouseClicked(MouseEvent e) {
             tblEjemploMouseClicked(e, tbl);
        }
        });
    }
     
     public void tblEjemploMouseClicked(java.awt.event.MouseEvent evt, JTable jtl) {
 
       String cadena="";
       try{
            
          int fila = jtl.getSelectedRow();
          String mascota, propietario;
          

          idMascota = jtl.getValueAt(fila, 2).toString();
          mascota = jtl.getValueAt(fila, 3).toString();
          propietario = jtl.getValueAt(fila, 1).toString();

          historiaClinica.cajamascota.setText(mascota);
          historiaClinica.cajacliente.setText(propietario);
          historiaClinica.idMascota = idMascota;
          
          String dataMascotas[][] = my_db_select2();
          especie= dataMascotas[0][0];
          raza= dataMascotas[0][1];
          System.out.println("especie: " + especie);
           System.out.println("raza: " + raza);
          historiaClinica.labelEspecie.setText(especie);
          historiaClinica.labelRaza.setText(raza);
          
          
           volver();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
       }
 
        
    }
    
    
    public void main(){
        this.setSize(800,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clientes");
        this.setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null);
        

        JLabel text = new JLabel();
        text.setText("Clientes");
        text.setBounds(300, 50, 400, 60);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        contentPane.add(text);
          crearTabla();
          
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
                 volver();
            }
        }); 
    }
    
}
