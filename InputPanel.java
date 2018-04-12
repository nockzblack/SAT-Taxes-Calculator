package proyectoMedioTerminoPOO;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	
	private JRadioButton rbNinguno,
						 rbPrimaria,
						 rbSecundaria,
						 rbPreparatoria;
	
	private Persona auxPersona;
	
	public InputPanel() {
		super();
		this.setPreferredSize(new Dimension(800,350));
		tfPersonalList = new ArrayList<JTextField>();
		auxPersona = new Persona();
		this.setLayout(new BorderLayout());
		
		
		
		
		JPanel personalData =  new JPanel(new SpringLayout());
		personalData.setPreferredSize(new Dimension(300,400));
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
		
		
		this.rbNinguno = new JRadioButton("Ninguno");
		this.rbPrimaria = new JRadioButton("Primaria");
		this.rbSecundaria = new JRadioButton("Secundaria");
		this.rbPreparatoria = new JRadioButton("Preparatoria");
		JPanel rbNivelEducativo = new JPanel(new SpringLayout());
		rbNivelEducativo.setPreferredSize(new Dimension(150,250));
		rbNivelEducativo.add(new JLabel("Nivel de Colegiatura:"));
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
					
				}
			}
			
		});
	}
	

}
