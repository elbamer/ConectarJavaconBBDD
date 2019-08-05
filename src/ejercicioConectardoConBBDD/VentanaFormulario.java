package ejercicioConectardoConBBDD;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class VentanaFormulario {

	private JFrame frmDatosEmpleados;
	private JTextField textAPELLIDO;
	private JTextField textNOMBRE;
	private JTextField textPROFESION;
	private JTextField textSALARIO;
	private JTextField textCOMISION;
	private JTextField textNOMBREDEPARTAMETNO;
	private JTextField textPROVINCIA;
	private JButton btnGuardar;
	private JTextField textField;
	private JComboBox cNdepar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			Class.forName("org.sqlite.JDBC"); // carga el driver en memoria
			// DriverManager.registerDriver(new org.sqlite.JDBC());
			System.out.println("¡¡Conectado correctamente!!");

		} catch (Exception e) {
			e.printStackTrace();
		} //

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFormulario window = new VentanaFormulario();
					window.frmDatosEmpleados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	} 

	/**
	 * Create the application.
	 */
	public VentanaFormulario() {
		initialize();
	}	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatosEmpleados = new JFrame();
		frmDatosEmpleados.setTitle("Datos Empleados");
		frmDatosEmpleados.setBounds(100, 100, 717, 702);
		frmDatosEmpleados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDatosEmpleados.getContentPane().setLayout(null);

		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblApellido.setBounds(12, 72, 90, 36);
		frmDatosEmpleados.getContentPane().add(lblApellido);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(12, 150, 81, 27);
		frmDatosEmpleados.getContentPane().add(lblNombre);

		JLabel lblProfesion = new JLabel("PROFESION");
		lblProfesion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblProfesion.setBounds(14, 224, 88, 27);
		frmDatosEmpleados.getContentPane().add(lblProfesion);

		JLabel lblSalario = new JLabel("SALARIO");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSalario.setBounds(24, 275, 79, 27);
		frmDatosEmpleados.getContentPane().add(lblSalario);

		JLabel lblComision = new JLabel("COMISION");
		lblComision.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblComision.setBounds(12, 326, 90, 27);
		frmDatosEmpleados.getContentPane().add(lblComision);

		JLabel lblId_dept = new JLabel("ID_DEPARTAMENTO");
		lblId_dept.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblId_dept.setBounds(12, 380, 106, 16);
		frmDatosEmpleados.getContentPane().add(lblId_dept);

		JLabel lblDEPARTAMENTO = new JLabel("NOMBRE DEPEARTAMENOT");
		lblDEPARTAMENTO.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDEPARTAMENTO.setBounds(7, 431, 111, 16);
		frmDatosEmpleados.getContentPane().add(lblDEPARTAMENTO);

		JLabel lblPROVINCIA = new JLabel("PROVINCIA");
		lblPROVINCIA.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPROVINCIA.setBounds(7, 488, 95, 16);
		frmDatosEmpleados.getContentPane().add(lblPROVINCIA);

		textAPELLIDO = new JTextField();
		textAPELLIDO.setBounds(114, 80, 166, 22);
		frmDatosEmpleados.getContentPane().add(textAPELLIDO);
		textAPELLIDO.setColumns(10);

		textNOMBRE = new JTextField();
		textNOMBRE.setBounds(108, 153, 166, 22);
		frmDatosEmpleados.getContentPane().add(textNOMBRE);
		textNOMBRE.setColumns(10);

		textPROFESION = new JTextField();
		textPROFESION.setBounds(114, 227, 166, 22);
		frmDatosEmpleados.getContentPane().add(textPROFESION);
		textPROFESION.setColumns(10);

		textSALARIO = new JTextField();
		textSALARIO.setBounds(115, 278, 159, 22);
		frmDatosEmpleados.getContentPane().add(textSALARIO);
		textSALARIO.setColumns(10);

		textCOMISION = new JTextField();
		textCOMISION.setBounds(114, 329, 166, 22);
		frmDatosEmpleados.getContentPane().add(textCOMISION);
		textCOMISION.setColumns(10);

		textNOMBREDEPARTAMETNO = new JTextField();
		textNOMBREDEPARTAMETNO.setBounds(114, 429, 166, 22);
		frmDatosEmpleados.getContentPane().add(textNOMBREDEPARTAMETNO);
		textNOMBREDEPARTAMETNO.setColumns(10);

		textPROVINCIA = new JTextField();
		textPROVINCIA.setBounds(114, 486, 166, 22);
		frmDatosEmpleados.getContentPane().add(textPROVINCIA);
		textPROVINCIA.setColumns(10);
		
		cNdepar = new JComboBox();
		cNdepar.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "30", "40"}));
		cNdepar.setBounds(127, 378, 153, 22);
		frmDatosEmpleados.getContentPane().add(cNdepar);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection  con;
				try {
					con = DriverManager.getConnection("jdbc:sqlite:sqlite\\midatabase.db");
					String querySelect = "INSERT INTO EMPLEADO (APELLIDO,NOMBRE,ROL,SALARIO,COMISION,ID_DEPT) VALUES (?,?,?,?,?,?)";
					String querySelect1 = "INSERT INTO DEPARTAMENTO (NOMBRE,LOCALIZACION) VALUES (?,?)";					
					PreparedStatement pstmt;
					ResultSet rset;
					pstmt = con.prepareStatement(querySelect);
					String query=querySelect+querySelect1;
					pstmt.setString(1, textAPELLIDO.getText());
					pstmt.setString(2, textNOMBRE.getText());
					pstmt.setString(3, textPROFESION.getText());				     
					pstmt.setString(4, textSALARIO.getText());
					pstmt.setString(5, textCOMISION.getText());
					pstmt.setString(6,(String)cNdepar.getSelectedItem());
					int resultado1 = pstmt.executeUpdate();
					pstmt = con.prepareStatement(querySelect1);
					pstmt.setString(1, textNOMBREDEPARTAMETNO.getText());
					pstmt.setString(2, textPROVINCIA.getText()); 
					// rset = pstmt.executeUpdate();// R
					int resultado = pstmt.executeUpdate();
					if (resultado > 0) {
						JOptionPane.showMessageDialog(null, "Registros agregados");				

					} else {
						JOptionPane.showMessageDialog(null, "Registros no guardados");


					}
					con.close();
				} catch (Exception es) {
					es.printStackTrace();
				}

			}
		});
		btnGuardar.setBounds(152, 539, 153, 43);
		frmDatosEmpleados.getContentPane().add(btnGuardar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(89, 591, 97, 51);
		frmDatosEmpleados.getContentPane().add(btnSalir);
		
		JButton btnLipiar = new JButton("LIPIAR");
		btnLipiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAPELLIDO.setText("");
				textNOMBRE.setText("");
				textPROFESION.setText("");
				textSALARIO.setText("");
				textCOMISION.setText("");
				//cNdepar.setText("");	
				textNOMBREDEPARTAMETNO.setText("");
				textPROVINCIA.setText("");		
			}
		});
		btnLipiar.setBounds(5, 539, 97, 43);
		frmDatosEmpleados.getContentPane().add(btnLipiar);		
		textField = new JTextField();
		textField.setBounds(317, 441, 370, 113);
		frmDatosEmpleados.getContentPane().add(textField);
		textField.setColumns(10);		
	
		



	}
}
