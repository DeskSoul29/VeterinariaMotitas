package veterinariamotitas;

import Conexion.Conectar;
import com.mysql.jdbc.Connection;
import java.awt.Container;
import java.awt.color.CMMException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class addProduc extends JFrame implements ActionListener {
	
	private Container contenedor;
	private JButton agregar, eliminar, borrar, volver, volver2;
	private JLabel labelTitulo, mensaje;
	private JComboBox campo;
	private JList listaNombres;
	private DefaultListModel modelo;
	private JScrollPane scrollLista;
        
        public addProduc(){
		iniciarComponentes();
		setTitle("Agrega tus Items");
		setSize(280,330);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void iniciarComponentes() {
		contenedor=getContentPane();
		contenedor.setLayout(null);
		
                String country2[]=my_db_select(newFactura.item);    
		campo= new JComboBox(country2);
		campo.setBounds(20, 80, 160, 23);
                
		agregar= new JButton();
		agregar.setText("Agregar");
		agregar.setBounds(180, 80, 80, 23);
		agregar.addActionListener(this);
		
		eliminar= new JButton();
		eliminar.setText("Eliminar");
		eliminar.setBounds(20, 210, 80, 23);
		eliminar.addActionListener(this);
		
		borrar= new JButton();
		borrar.setText("Borrar Lista");
		borrar.setBounds(120, 210, 120, 23);
		borrar.addActionListener(this);
                
                volver= new JButton();
		volver.setText("Terminar");
		volver.setBounds(130, 250, 100, 23);
		volver.addActionListener(this);
                
                volver2 = new JButton();
		volver2.setText("Volver");
		volver2.setBounds(20, 250, 80, 23);
		volver2.addActionListener(this);
		
		labelTitulo= new JLabel();
		labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 28));
		labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelTitulo.setText("Agregar Items");
		labelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		labelTitulo.setBounds(30, 20, 200, 43);
		
		mensaje= new JLabel();
		mensaje.setBounds(20, 250, 280, 23);
		
		listaNombres = new JList();
		listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		
		modelo = new DefaultListModel();
	   	
        	scrollLista = new JScrollPane();
		scrollLista.setBounds(20, 120,220, 80);
                scrollLista.setViewportView(listaNombres);
		
		contenedor.add(labelTitulo);
		contenedor.add(campo);
		contenedor.add(agregar);
		contenedor.add(eliminar);
		contenedor.add(borrar);
                contenedor.add(volver);
                contenedor.add(volver2);
		contenedor.add(mensaje);
		contenedor.add(scrollLista);
	}


	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource()==agregar){
			agregarNombre();
		}
		if (evento.getSource()==eliminar){
			eliminarNombre(listaNombres.getSelectedIndex() );
		}
		if (evento.getSource()==borrar){
			borrarLista();
		}
                if (evento.getSource()==volver){
                    String[] myArray = new String[50];
                    int num = 0;
                    for (int i = 0; i < listaNombres.getModel().getSize(); i++) {
                            myArray[i] = String.valueOf(listaNombres.getModel().getElementAt(i));
                            Long n = facturar(newFactura.item, myArray[i]);
                            num += n;
                            System.out.println(n);
                            
                    }
                    newFactura.caja5.setText(""+num);
                    dispose();
		}
                if (evento.getSource()==volver2){
			dispose();
		}
                
	}
        
        private String[] my_db_select(String item) {
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
        
        public Long facturar(String item, String item2){
            Long data = null;
            try{  
               Conectar conecta = new Conectar();
               Connection con = (Connection) conecta.getConexion();

               Statement st = con.createStatement();
               ResultSet rs = null;
               
               if(item == "Servicio"){
                   rs = st.executeQuery("SELECT precio_serv FROM servicio WHERE nombre_serv = '"+item2+"'");
               }else{
                   rs = st.executeQuery("SELECT precio_prod FROM producto WHERE nombre_prod = '"+item2+"'");
               }
               
               while(rs.next())  {
                    data=rs.getLong(1);
               }
               
          con.close();  
          }catch(Exception e){ 
               System.out.println(e);
          } 
            return data;
        }

	private void agregarNombre() {
		String nombre=(String) campo.getItemAt(campo.getSelectedIndex());;
		modelo.addElement(nombre);
		listaNombres.setModel(modelo);
	}
	
	private void eliminarNombre(int indice) {
		if (indice>=0) {
			modelo.removeElementAt(indice);	
		}else{
			JOptionPane.showMessageDialog(null, "Debe seleccionar un indice"
					,"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void borrarLista() {
		modelo.clear();
	}

}

