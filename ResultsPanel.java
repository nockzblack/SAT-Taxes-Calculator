package proyectoMedioTerminoPOO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class ResultsPanel extends JPanel {
	
	private final static String[] INGRESOSLABELS = {"Sueldo Mensual:", "Ingreso Anual:", "Aguinaldo: ", "Aguinaldo Excento:", 
			"Aguinaldo Gravado:", "Prima Vacacional:", "Prima Vacacional:", "Prima Vacacional Excento:", "Prima Vacacional Gravada:",
			"Total Ingresos Gravados:"};
	
	private final static String[] DEDUCCIONESLABELS = {"Medicos y Hosipalarios:", "Gastos Funerarios:", "SGMM:", "Hipotecarios",
			"Donativos:", "Subcuente de Retiro:", "Tranporte Escolar:", "Nivel Educativo:", "Maximo Deducible Colegiatura:",
			"Colegiatura Pagada:", "Total Deducciones (sin retiro):"};
	
	private final static String[] BALANCE_LABELS = {"Deducciones Perimitdas: ", "Monto ISR:", "Cuota Fija:","Porcentaje Excedente:","Pago Excedente:", "Total a Pagar:"};
	
	
	
	private ArrayList<JTextField> tfPIngresosList;
	private ArrayList<JTextField> tfPGastosList;
	private ArrayList<JTextField> tfBalanceList;
	
	JPanel resultsPanel;
	
	public ResultsPanel() {
		super();
		this.setPreferredSize(new Dimension(1000, 700));
		initResults();
	}
	
	
	private void initResults() {
		this.resultsPanel = new JPanel();
		resultsPanel.setLayout(new BorderLayout());
		resultsPanel.add(new JLabel("                                 				                     ********RESULTADOS********"), BorderLayout.NORTH);
		
		tfPIngresosList = new ArrayList<JTextField>();
		Dimension auxDimension = new Dimension(300,500);
		JPanel jpIngresos = initMiniPanel(INGRESOSLABELS, tfPIngresosList, auxDimension, false);
		jpIngresos.setBackground(Color.LIGHT_GRAY);
		jpIngresos.add(new JLabel("                 ************INGRESOS************"));
		resultsPanel.add(jpIngresos, BorderLayout.WEST);
		
		tfPGastosList = new ArrayList<JTextField>();
		JPanel jpGastos = initMiniPanel(DEDUCCIONESLABELS, tfPGastosList,auxDimension, false);
		jpGastos.setBackground(Color.LIGHT_GRAY);
		jpGastos.add(new JLabel("                 ************GASTOS************"));
		resultsPanel.add(jpGastos, BorderLayout.EAST);
		this.add(resultsPanel, BorderLayout.WEST);
		
		
		
		Dimension balanceDimension = new Dimension(400,150);
		tfBalanceList = new ArrayList<JTextField>();
		JPanel jpBalance = initMiniPanel(BALANCE_LABELS, tfBalanceList, balanceDimension, false);
		jpBalance.setBackground(Color.LIGHT_GRAY);
		jpBalance.add(new JLabel("                          ************BALANCE************"));
		this.add(jpBalance, BorderLayout.EAST);
		
	}
	
	
	
	private JPanel initMiniPanel(String[] lbTitles, ArrayList<JTextField> tfauxList, Dimension auxDimension, boolean editable) {
		JPanel auxPanel = new JPanel(new SpringLayout());
		auxPanel.setPreferredSize(auxDimension);
		int numberOfParis = lbTitles.length;
		for (int i = 0; i < numberOfParis; i++) {
		      JLabel auxLabel = new JLabel(lbTitles[i], JLabel.TRAILING);
		      auxPanel.add(auxLabel);
		      JTextField auxTextField = new JTextField(5);
		      auxTextField.setEditable(false);
		      auxLabel.setLabelFor(auxTextField);
		      auxPanel.add(auxTextField);
		      tfauxList.add(auxTextField);    
		}
		SpringUtilities.makeCompactGrid(auxPanel, numberOfParis, 2, //rows, cols
		        6, 25, //initX, initY
		        1, 4); //xPad, yPad
		
		return auxPanel; 
	}
	
	
}
