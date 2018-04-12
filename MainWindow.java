package proyectoMedioTerminoPOO;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		this.pack();
		this.setVisible(true);
		
	
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("Archivos");
		JMenuItem selectFile = new JMenuItem("Seleccionar Archivo");
		fileMenu.add(selectFile);
		selectFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String auxStr = "";
				String path = "";
				try {
					JFileChooser chooser = new JFileChooser();
				    FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(MainWindow.this);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				       path = chooser.getSelectedFile().getName();
				    }
	                BufferedReader auxBuffer = new BufferedReader(new FileReader(path));
	                auxStr = auxBuffer.readLine();
	                System.out.println(auxStr);
	                //TODO HEte
	                auxBuffer.close();
	            } catch (FileNotFoundException ex) {
	                JOptionPane.showMessageDialog(MainWindow.this, ex.getMessage());
	            } catch (IOException ex) {
	                JOptionPane.showMessageDialog(MainWindow.this, ex.getMessage());
	            }
			}
		});
		
		
		
		
		JMenu individualMenu = new JMenu("Por persona");
		JMenuItem getData = new JMenuItem("Capturar Datos");
		individualMenu.add(getData);
		getData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				input = new InputPanel();
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
				results = new ResultsPanel();
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
	
	public static void main(String[] args) {
		MainWindow auxWindow = new MainWindow();
		auxWindow.revalidate();
		auxWindow.repaint();
	}
	
}
