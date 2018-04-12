package proyectoMedioTerminoPOO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class ResultsPanel extends JPanel {
	
	private final static String[] INGRESOS_LABELS = {"Sueldo Mensual:", "Ingreso Anual:", "Aguinaldo: ", "Aguinaldo Excento:", 
			"Aguinaldo Gravado:", "Prima Vacacional:", "Prima Vacacional Excento:", "Prima Vacacional Gravada:",
			"Total Ingresos Gravados:"};
	
	private final static String[] DEDUCCIONES_LABELS = {"Medicos y Hosipalarios:", "Gastos Funerarios:", "SGMM:", "Hipotecarios",
			"Donativos:", "Subcuente de Retiro:", "Tranporte Escolar:", "Nivel Educativo:", "Maximo Deducible Colegiatura:",
			"Colegiatura Pagada:", "Total Deducciones (sin retiro):"};
	
	private final static String[] BALANCE_LABELS = {"Nombre:","RFC:","Deducciones Perimitdas:", "Monto ISR:", "Cuota Fija:","Porcentaje Excedente:","Pago Excedente:", "Total a Pagar:"};
	
	
	
	private ArrayList<JTextField> tfPIngresosList;
	private ArrayList<JTextField> tfPGastosList;
	private ArrayList<JTextField> tfBalanceList;
	
	private JPanel resultsPanel;
	
	private Deduccion deduccionAMostrar;
	
	public ResultsPanel(Deduccion newDeduccion) {
		super();
		this.deduccionAMostrar = newDeduccion;
		this.setPreferredSize(new Dimension(1000, 700));
		initResults();
	}
	
	public void setDeduccion(Deduccion newDeduccion) {
		this.deduccionAMostrar = newDeduccion;
		this.showResults();
	}
	
	
	private void initResults() {
		this.resultsPanel = new JPanel();
		resultsPanel.setLayout(new BorderLayout());
		resultsPanel.add(new JLabel("                                 				                     ********RESULTADOS********"), BorderLayout.NORTH);
		
		tfPIngresosList = new ArrayList<JTextField>();
		Dimension auxDimension = new Dimension(300,500);
		JPanel jpIngresos = initMiniPanel(INGRESOS_LABELS, tfPIngresosList, auxDimension, false);
		jpIngresos.setBackground(Color.LIGHT_GRAY);
		jpIngresos.add(new JLabel("                 ************INGRESOS************"));
		resultsPanel.add(jpIngresos, BorderLayout.WEST);
		
		tfPGastosList = new ArrayList<JTextField>();
		JPanel jpGastos = initMiniPanel(DEDUCCIONES_LABELS, tfPGastosList,auxDimension, false);
		jpGastos.setBackground(Color.LIGHT_GRAY);
		jpGastos.add(new JLabel("                 ************GASTOS************"));
		resultsPanel.add(jpGastos, BorderLayout.EAST);
		this.add(resultsPanel, BorderLayout.WEST);
		
		
		
		Dimension balanceDimension = new Dimension(400,280);
		tfBalanceList = new ArrayList<JTextField>();
		JPanel jpBalance = initMiniPanel(BALANCE_LABELS, tfBalanceList, balanceDimension, false);
		jpBalance.setBackground(Color.LIGHT_GRAY);
		jpBalance.add(new JLabel("                          ************BALANCE************"));
		this.add(jpBalance, BorderLayout.EAST);
		
	}
	
	private void showResults() {
		String auxStr = this.deduccionAMostrar.toString();
		//System.out.println(auxStr);
		StringTokenizer st = new StringTokenizer(auxStr);
		//Nombre	RFC	Sueldo mensual	Ingreso anual	Aguinaldo	Aguinaldo exento	Aguinaldo gravado	Prima vacacional	Prima vacacional excenta	Prima vacacional gravada	Total ingresos gravan	Medicos y hospitales	Gastos funerarios	SGMM	 Hipotecarios	Donativos	Subcuenta retiro	 Transporte escolar	Nivel educativo	Maximo a deducir colegiatura	Colegiatura pagada	Total deducciones (sin retiro)	Deduccion permitida 10%	Monto ISR	Cuota fija	Porcentaje excedente	Pago excedente	Total a pagar
		JTextField personalData = this.tfBalanceList.get(0);
		personalData.setText(st.nextToken(","));
		personalData = this.tfBalanceList.get(1);
		personalData.setText(st.nextToken());
		
		for (int i=0; i<this.tfPIngresosList.size(); i++) {
			JTextField auxTextField = this.tfPIngresosList.get(i);
			auxTextField.setText(st.nextToken());
		}
		
		for (int i=0; i<this.tfPGastosList.size(); i++) {
			JTextField auxTextField = this.tfPGastosList.get(i);
			auxTextField.setText(st.nextToken());
		}
		for (int i=2; i<this.tfBalanceList.size(); i++) {
			JTextField auxTextField = this.tfBalanceList.get(i);
			auxTextField.setText(st.nextToken());
		}
		
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
