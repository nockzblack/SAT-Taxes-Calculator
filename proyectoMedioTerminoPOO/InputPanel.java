package proyectoMedioTerminoPOO;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class InputPanel extends JPanel {
	private final static String[] PERSONAL_LABELS = {"Nombre:", "RCF:","Sueldo Mensual:", "Aguinaldo:", "Prima Vacacional:"};
	
	private final static String[] GASTOS_LABELS = {"Medicos y Hospitalarios:", "Gastos Funenrarios:", "SGMM:", "Hipoteca:",
			"Donativos:", "Subcuenta de retiro:","Transporte Escolar:", "Colegiatura:"};
	
	private ArrayList<JTextField> tfPersonalList;
	
	private JButton btCalcular;
	private JButton btLimpiar;
	
	private ButtonGroup rbGroup;
	private JRadioButton rbNinguno,
						 rbPrimaria,
						 rbSecundaria,
						 rbPreparatoria;
	
	private Deduccion auxDeduccion;
	
	private MainWindow principalWindow;
	
	public InputPanel(MainWindow mainWindow) {
		super();
		this.setPreferredSize(new Dimension(800,350));
		this.principalWindow = mainWindow;
		this.tfPersonalList = new ArrayList<JTextField>();
		this.auxDeduccion = new Deduccion();
		this.setLayout(new BorderLayout());
		
		
		
		JPanel personalData =  new JPanel(new SpringLayout());
		personalData.setPreferredSize(new Dimension(300,200));
		for (int i = 0; i < PERSONAL_LABELS.length; i++) {
		      JLabel auxLabel = new JLabel(PERSONAL_LABELS[i], JLabel.TRAILING);
		      personalData.add(auxLabel);
		      JTextField auxTextField = new JTextField(10);
		      auxLabel.setLabelFor(auxTextField);
		      personalData.add(auxTextField);
		      tfPersonalList.add(auxTextField);    
		}
		
		SpringUtilities.makeCompactGrid(personalData, PERSONAL_LABELS.length, 2, //rows, cols
		        6, 25, //initX, initY
		        1, 4); //xPad, yPad
		
		this.add(personalData, BorderLayout.WEST);
		
		JPanel gastosData =  new JPanel(new SpringLayout());
		for (int i = 0; i < GASTOS_LABELS.length; i++) {
		      JLabel auxLabel = new JLabel(GASTOS_LABELS[i], JLabel.TRAILING);
		      gastosData.add(auxLabel);
		      JTextField auxTextField = new JTextField(10);
		      auxLabel.setLabelFor(auxTextField);
		      gastosData.add(auxTextField);
		      tfPersonalList.add(auxTextField);    
		}
		
		SpringUtilities.makeCompactGrid(gastosData, GASTOS_LABELS.length, 2, //rows, cols
		        6, 25, //initX, initY
		        1, 4); //xPad, yPad
		
		this.add(gastosData, BorderLayout.CENTER);
		
		
		this.rbNinguno = new JRadioButton("Ninguno",true);
		this.rbPrimaria = new JRadioButton("Primaria");
		this.rbSecundaria = new JRadioButton("Secundaria");
		this.rbPreparatoria = new JRadioButton("Preparatoria");
		JPanel rbNivelEducativo = new JPanel(new SpringLayout());
		rbNivelEducativo.setPreferredSize(new Dimension(150,250));
		rbNivelEducativo.add(new JLabel("Nivel de Colegiatura:"));
		rbGroup = new ButtonGroup();
		rbGroup.add(rbNinguno);
		rbGroup.add(rbPrimaria);
		rbGroup.add(rbSecundaria);
		rbGroup.add(rbPreparatoria);
		rbNivelEducativo.add(rbNinguno);
		rbNivelEducativo.add(rbPrimaria);
		rbNivelEducativo.add(rbSecundaria);
		rbNivelEducativo.add(rbPreparatoria);
		SpringUtilities.makeCompactGrid(rbNivelEducativo, 5, 1, //rows, cols
		        6, 30, //initX, initY
		        1, 4); //xPad, yPad
		this.add(rbNivelEducativo,BorderLayout.EAST);
		
		btCalcular = new JButton("Calcular");
		btLimpiar = new JButton("Limpiar");
		JPanel botonesPanel = new JPanel();
		botonesPanel.add(btCalcular,BorderLayout.WEST);
		botonesPanel.add(btLimpiar,BorderLayout.EAST);
		this.add(botonesPanel, BorderLayout.SOUTH);
		
		
		btLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i=0; i<tfPersonalList.size(); i++) {
					JTextField auxTextField = tfPersonalList.get(i);
					auxTextField.setText("");
				}
				InputPanel.this.rbGroup.clearSelection();
				InputPanel.this.rbNinguno.setSelected(true);
			}
			
		});
		
		btCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String auxStr = "";
				for (int i=0; i<tfPersonalList.size(); i++) {
					JTextField auxTextField = tfPersonalList.get(i);
					if (auxTextField.getText().equals("")) {
						auxStr += "0,";
					} else {
						auxStr += auxTextField.getText() + ",";
					}
				}
				auxStr = auxStr.substring(0, auxStr.length() - 1);
	            InputPanel.this.auxDeduccion = makeCalculo(auxStr);
	            InputPanel.this.principalWindow.setDeduccion(InputPanel.this.auxDeduccion);
	            InputPanel.this.principalWindow.getContentPane().removeAll();
	            InputPanel.this.principalWindow.add(InputPanel.this.principalWindow.getResults());
	            InputPanel.this.principalWindow.revalidate();
	            InputPanel.this.principalWindow.repaint();
			}
			
		
		});
	}
	
	
	
	private Deduccion makeCalculo(String auxStr) {
		StringTokenizer st = new StringTokenizer(auxStr);
	    	String nombre = st.nextToken(",");
	    	String rfc = st.nextToken();
	    	double sueldo = Double.parseDouble(st.nextToken());
	    	double aguinaldo = Double.parseDouble(st.nextToken());
	    	double prima = Double.parseDouble(st.nextToken());
	    	double medicos = Double.parseDouble(st.nextToken());
	    	double funerarios = Double.parseDouble(st.nextToken());
	    	double sgmm = Double.parseDouble(st.nextToken());
	    	double hipotecarios = Double.parseDouble(st.nextToken());
	    	double donativos = Double.parseDouble(st.nextToken());
	    	double subcuenta = Double.parseDouble(st.nextToken());
	    	double transporte = Double.parseDouble(st.nextToken());
	    	double colegiatura = Double.parseDouble(st.nextToken());
	    	int nivelEd;
	    	if (InputPanel.this.rbPrimaria.isSelected()) {
	    		nivelEd = 1;
	    	} else if (InputPanel.this.rbSecundaria.isSelected()) {
	    		nivelEd = 2;
	    	} else if (InputPanel.this.rbPreparatoria.isSelected()) {
	    		nivelEd = 3;
	    	} else {
	    		nivelEd = 0;
	    	}
		return new Deduccion(new Persona(nombre, rfc, new Ingresos(sueldo, aguinaldo, prima), 
    			new Gastos(medicos, funerarios, sgmm, hipotecarios, donativos, subcuenta, transporte,
    					colegiatura,nivelEd), nivelEd));
	}
	

}
