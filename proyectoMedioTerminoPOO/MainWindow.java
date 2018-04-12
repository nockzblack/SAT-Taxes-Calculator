package proyectoMedioTerminoPOO;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainWindow extends JFrame {
	
	private InputPanel input;
	private ResultsPanel results;
	
	public MainWindow() {
		super("Cálculo de Impuestos para el SAT");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1020,600));
		input = new InputPanel(this);
		results = new ResultsPanel(new Deduccion());
		this.pack();
		this.setVisible(true);
		
	
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("Cálculo Multiple (Archivos)");
		JMenuItem selectFile = new JMenuItem("Seleccionar Archivo");
		fileMenu.add(selectFile);
		selectFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String auxStr = "";
				File selectedFile = null;;
				StringTokenizer st;
				int nivelEd;
				try {
					JFileChooser chooser = new JFileChooser();
				    FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(MainWindow.this);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	 selectedFile = chooser.getSelectedFile();
				    }
	                BufferedReader auxBuffer = new BufferedReader(new FileReader(selectedFile));
	                PrintWriter pw = new PrintWriter(new FileWriter(selectedFile.getParent() + "/archivoDeResultados.csv"));
	                
	                pw.println("Nombre,RFC,Sueldo mensual,Ingreso anual,Aguinaldo,Aguinaldo exento,Aguinaldo gravado,Prima vacacional,Prima vacacional excenta,Prima vacacional gravada,Total ingresos gravan,Medicos y hospitales,Gastos funerarios,SGMM,Hipotecarios,Donativos,Subcuenta retiro,Transporte escolar,Nivel educativo,Maximo a deducir colegiatura,Colegiatura pagada,Total deducciones (sin retiro),Deduccion permitida 10%,Monto ISR,Cuota fija,Porcentaje excedente,Pago excedente,Total a pagar");
	                while ((auxStr = auxBuffer.readLine()) != null) {
	                	st = new StringTokenizer(auxStr);
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
	                	String nivelStr = st.nextToken();
	                	if (nivelStr.toLowerCase().equals("primaria")) {
	                		nivelEd = 1;
	                	} else if (nivelStr.toLowerCase().equals("secundaria")) {
	                		nivelEd = 2;
	                	} else if (nivelStr.toLowerCase().equals("preparatoria")) {
	                		nivelEd = 3;
	                	} else {
	                		nivelEd = 0;
	                	}
	                	double colegiatura = Double.parseDouble(st.nextToken());
	                	pw.println(new Deduccion(new Persona(nombre, rfc, new Ingresos(sueldo, aguinaldo, prima), 
	                			new Gastos(medicos, funerarios, sgmm, hipotecarios, donativos, subcuenta, transporte,
	                					colegiatura,nivelEd), nivelEd)));	                	
	                }
	                JOptionPane.showMessageDialog(MainWindow.this, "archivoDeResultados.csv generado correctamente, en el mismo directorio que el archivo de entrada");
	                auxBuffer.close();
	                pw.close();
	            } catch (FileNotFoundException ex) {
	                JOptionPane.showMessageDialog(MainWindow.this, ex.getMessage());
	            } catch (IOException ex) {
	                JOptionPane.showMessageDialog(MainWindow.this, ex.getMessage());
	            }
			}
		});
		
		
		
		
		JMenu individualMenu = new JMenu("Cálculo por Persona (sencillo)");
		JMenuItem getData = new JMenuItem("Capturar Datos");
		individualMenu.add(getData);
		getData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainWindow.this.getContentPane().removeAll();
				MainWindow.this.add(input);
				MainWindow.this.revalidate();
				MainWindow.this.repaint();
			}
			
		});
		
		JMenuItem showResults = new JMenuItem("Ver Resultados");
		individualMenu.add(showResults);
		showResults.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainWindow.this.getContentPane().removeAll();
				MainWindow.this.add(results);
				MainWindow.this.revalidate();
				MainWindow.this.repaint();
			}
		});
			
		
		
		menuBar.add(fileMenu);
		menuBar.add(individualMenu);
		this.setJMenuBar(menuBar);
	
	}

	
	public void setDeduccion(Deduccion newDeduccion) {
		this.results.setDeduccion(newDeduccion);
	}
	
	public ResultsPanel getResults() {
		return this.results;
	}
	
	public static void main(String[] args) {
		MainWindow auxWindow = new MainWindow();
		auxWindow.revalidate();
		auxWindow.repaint();
	}
	
}
