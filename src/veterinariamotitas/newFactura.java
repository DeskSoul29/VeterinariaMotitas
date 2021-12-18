package veterinariamotitas;

import Conexion.Conectar;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class newFactura extends JFrame {
    
    private JPanel panel;
    private JComboBox caja2;
    public static JTextField caja5= new JTextField();
    
    public static JTextField caja = new JTextField();
    public static JTextField caja4 = new JTextField();
    private JTextField caja6;
    public static String valorAnadi, item;
    
    public newFactura(){
        main();
    }
    
    private String validarProm(String item){
        String data = "";
        try{  
            Conectar conecta = new Conectar();
            Connection con = (Connection) conecta.getConexion();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT tipo FROM tipo_valor WHERE id_tiva = "+item+"");


            while(rs.next())  {
                 data = rs.getString(1);
            }
        con.close();  
        }catch(Exception e){ 
             System.out.println(e);
        } 
        
        return data;
            
    }
    
    public int validarTipo(int item){
        int data = 0; // [rows][columns]
	
          try{  
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();

               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("SELECT valor_tiva FROM tipo_valor WHERE id_tiva = "+item+"");
               
               
               while(rs.next())  {
                    data = rs.getInt(1);
               }
          con.close();  
          }catch(Exception e){ 
               System.out.println(e);
          } 

          return data;
    }
    
    public  String[] my_db_select(String item) {
          String[] data = new String[10]; // [rows][columns]
	
          try{  
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();

               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("SELECT * FROM "+item+"");
               
               int i=0;
               
               while(rs.next())  {
                    data[i]=rs.getString(2);
                    i=i+1;
               }
          con.close();  
          }catch(Exception e){ 
               System.out.println(e);
          } 

          return data;
     }
    
    public void main(){
        this.setSize(800,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Nueva Factura");
        this.setLocationRelativeTo(null);
        
        panel =new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        JLabel text=new JLabel();
        text.setText("Nueva Factura");
        text.setBounds(200, 50, 400, 60);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Broadway",Font.BOLD,30));
        panel.add(text);
        
        
        
        JLabel text0=new JLabel();
        text0.setText("Cliente: ");
        text0.setBounds(100, 100, 200, 60);
        text0.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text0);
        
        caja.setBounds(250,110,260,40);
        caja.setFont(new Font("Broadway",Font.BOLD,15));
        caja.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja.setBackground(Color.WHITE);
        caja.setEnabled(false);
        panel.add(caja);
        
        JButton boton1 = new JButton();
        boton1.setText("Buscar");
        boton1.setBounds(510,110,120,40);
        boton1.setFont(new Font("Broadway",Font.BOLD,15));
        panel.add(boton1);
        
        boton1.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                caja.setText("");
                clienFactu alumn = new clienFactu();
                alumn.setVisible(true);
            }
        });
             
        
        
        JLabel text1=new JLabel();
        text1.setText("Tipo: ");
        text1.setBounds(100, 150, 200, 60);
        text1.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text1);
        
        String country[]={"Servicio","Producto"};        
        caja2=new JComboBox(country);    
        caja2.setBounds(250,159,260,40); 
        caja2.setFont(new Font("Broadway",Font.BOLD,15));
        caja2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja2.setBackground(Color.WHITE);
        panel.add(caja2);
        
        
        
        JLabel text2=new JLabel();
        text2.setText("Descripción: ");
        text2.setBounds(100, 200, 152, 60);
        text2.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text2);
        
        TextArea caja3 = new TextArea();
        caja3.setBounds(253,220,300,100);
        caja3.setFont(new Font("Broadway",Font.BOLD,15));
        caja3.setBackground(Color.WHITE);
        panel.add(caja3);
        
        
        
        JLabel text3=new JLabel();
        text3.setText("Valor Añadido: ");
        text3.setBounds(65, 310, 190, 60);
        text3.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text3);
        
        caja4.setBounds(250,330,260,40);
        caja4.setFont(new Font("Broadway",Font.BOLD,15));
        caja4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja4.setBackground(Color.WHITE);
        caja4.setEnabled(false);
        panel.add(caja4);
        
        JButton boton2 = new JButton();
        boton2.setText("Buscar");
        boton2.setBounds(510,330,120,40);
        boton2.setFont(new Font("Broadway",Font.BOLD,15));
        panel.add(boton2);
        
        boton2.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                caja4.setText("");
                valorAnadido alumn = new valorAnadido();
                alumn.setVisible(true);
            }
        });
        
        
        
        JLabel text4=new JLabel();
        text4.setText("Agregar Items:");
        text4.setBounds(65, 360, 190, 60);
        text4.setFont(new Font("Broadway",Font.BOLD,20));
        panel.add(text4);
        
        caja5.setBounds(250,380,260,40);
        caja5.setFont(new Font("Broadway",Font.BOLD,15));
        caja5.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja5.setBackground(Color.WHITE);
        caja5.setEnabled(false);
        panel.add(caja5);
        
        JButton boton3 = new JButton();
        boton3.setText("Añadir");
        boton3.setBounds(510,380,120,40);
        boton3.setFont(new Font("Broadway",Font.BOLD,15));
        panel.add(boton3);
        
        boton3.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                caja6.setText("");
                item = (String) caja2.getItemAt(caja2.getSelectedIndex());
                addProduc alumn = new addProduc();
                alumn.setVisible(true);
            }
        });
        
        
        
        JButton boton4 = new JButton();
        boton4.setText("Total");
        boton4.setBounds(510,430,120,40);
        boton4.setFont(new Font("Broadway",Font.BOLD,15));
        panel.add(boton4);
        
        caja6 = new JTextField();
        caja6.setBounds(250,430,260,40);
        caja6.setFont(new Font("Broadway",Font.BOLD,15));
        caja6.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        caja6.setBackground(Color.WHITE);
        caja6.setEnabled(false);
        panel.add(caja6);
        
        boton4.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                
                if(caja4.getText().equalsIgnoreCase("") || caja5.getText().equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(null, "Debe diligenciar los datos anteriores", "Error", JOptionPane.WARNING_MESSAGE);
                }else{
                    int in = Integer.parseInt(validarProm(valorAnadi));
                    if(in==1){
                        int n = Integer.parseInt(caja5.getText());//Valor Unitario(sin recargo)
                        int n2 = Integer.parseInt(valorAnadi);//Id Valor_Tipo elegido
                        int n3 = validarTipo(n2);//Valor del porcentaje a reducir
                        double n4 = ((n3*1.0)/100)+1;
                        int total = (int) (n*n4);
                        caja6.setText(""+total);
                    }else{
                        int n = Integer.parseInt(caja5.getText());//Valor Unitario(sin recargo)
                        int n2 = Integer.parseInt(valorAnadi);//Id Valor_Tipo elegido
                        int n3 = validarTipo(n2);//Valor del porcentaje a reducir 
                        double n4 = ((n3*1.0)/100)+1;
                        int total = (int) (n4/n);
                        caja6.setText(""+total);
                    }
                }
                
            }
        });
        
        
        
        JButton boton=new JButton();
        boton.setText("Registrar");
        boton.setBounds(500, 520, 130, 30);
        boton.setFont(new Font("Broadway",Font.BOLD,15));
        panel.add(boton);
       
         

        JButton botonV=new JButton();
        botonV.setBounds(150, 500, 80, 80);
        botonV.setFont(new Font("Broadway",Font.BOLD,15));
        botonV.setBackground(Color.WHITE);
        botonV.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(botonV);
        
        ImageIcon back=new ImageIcon("imagenes/back.png");
        botonV.setIcon(new ImageIcon(back.getImage().getScaledInstance(80, 80,Image.SCALE_SMOOTH)));
        panel.add(botonV);
        
        botonV.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                factura alumn = new factura();
                alumn.setVisible(true);
                dispose();
            }
        });     
        
        
        
        ActionListener oyente = new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent ae) {
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();
               
               String numero1=caja.getText();
               String numero2=(String) caja2.getItemAt(caja2.getSelectedIndex());
               String numero3=caja3.getText();
               String numero4=caja6.getText();

              if(numero1.equalsIgnoreCase("") || numero2.equalsIgnoreCase("") || numero3.equalsIgnoreCase("") || numero4.equalsIgnoreCase("") || valorAnadi=="null"){
                  JOptionPane.showMessageDialog(null, "Debe diligenciar todos los datos", "Error", JOptionPane.WARNING_MESSAGE);
              }else {
                   try{
                         PreparedStatement ps = con.prepareStatement("INSERT INTO `facturacion`(`id_cliente`, `tipo_fact`, `descripcion_fact`, `tipo_valor_fact`) VALUES (?,?,?,?)");
                         ps.setString(1, numero1);
                         ps.setString(2, numero2);
                         ps.setString(3, numero3);
                         ps.setString(4, valorAnadi);

                         ps.executeUpdate();
                         
                         JOptionPane.showMessageDialog(null, "Agregado Correctamente");
                         caja.setText("");
                         caja3.setText("");
                         caja4.setText("");
                         caja5.setText("");
                         caja6.setText("");
                         factura alumn = new factura();
                         alumn.setVisible(true);
                         dispose();
                     }catch (Exception e){
                          System.out.println("Error al insertar ,"+e);

                     }
              }
                
            
            }
         
        };
        boton.addActionListener(oyente);
    }

   
    
    
}
