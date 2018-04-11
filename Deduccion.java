package proyectoMedioTerminoPOO;

public class Deduccion {
												 // lowerLimit, fee, percentage
	private static final double tarifaCalc[][] = {{0.01, 0.00, 1.92}, 
												  {5952.85, 114.29, 6.40}, 
												  {50524.93, 2966.91, 10.88}, 
												  {88793.05, 7130.48, 16.00}, 
												  {103218.01, 9438.47, 17.92}, 
												  {123580.21, 13087.37, 21.36}, 
												  {249243.49, 39929.05, 23.52}, 
												  {392841.97, 73703.41, 30.00}, 
												  {750000.01, 180850.82, 32.00}, 
												  {1000000.01, 260850.81, 34.00}, 
												  {3000000.01, 940850.81, 35.00}};
	private Persona personaADeducir;
	private int fila;
	private double deduccionesPermitidas,
				   calculoISR,
				   cuotaFija,
				   porcentajeExcedente,
				   pagoExcedente;
	
	
	public Deduccion() {
		this.personaADeducir = new Persona();
		this.fila = 0;
		this.deduccionesPermitidas = 0;
		this.calculoISR = 0;
		this.cuotaFija = 0;
		this.porcentajeExcedente = 0;
		this.pagoExcedente = 0;
	}
	
	public Deduccion(Persona persona) {
		this.personaADeducir = persona;
		for(int i=0; i < tarifaCalc.length; i++) {
			try {
				if(personaADeducir.getIngresos().getTotalIngresosGravados() < Deduccion.tarifaCalc[i + 1][0]) {
					this.fila = i;
				}
			} catch (IndexOutOfBoundsException e) {
				this.fila = 10;
			}
		}
		this.deduccionesPermitidas = (this.personaADeducir.getIngresos().getSueldoMensual()) * (12) * (0.1);
		this.calculoISR = this.personaADeducir.getIngresos().getTotalIngresosGravados() - this.deduccionesPermitidas;
		this.cuotaFija = Deduccion.tarifaCalc[this.fila][1];
		this.porcentajeExcedente = Deduccion.tarifaCalc[this.fila][2];
		this.pagoExcedente = (this.calculoISR - Deduccion.tarifaCalc[fila][0])*this.porcentajeExcedente;
	}
	
	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public double getDeduccionesPermitidas() {
		return deduccionesPermitidas;
	}

	public void setDeduccionesPermitidas(double deduccionesPermitidas) {
		this.deduccionesPermitidas = deduccionesPermitidas;
	}

	public double getCalculoISR() {
		return calculoISR;
	}

	public void setCalculoISR(double calculoISR) {
		this.calculoISR = calculoISR;
	}

	public double getCuotaFija() {
		return cuotaFija;
	}

	public void setCuotaFija(double cuotaFija) {
		this.cuotaFija = cuotaFija;
	}

	public double getPorcentajeExcedente() {
		return porcentajeExcedente;
	}

	public void setPorcentajeExcedente(double porcentajeExcedente) {
		this.porcentajeExcedente = porcentajeExcedente;
	}

	public double getPagoExcedente() {
		return pagoExcedente;
	}

	public void setPagoExcedente(double pagoExcedente) {
		this.pagoExcedente = pagoExcedente;
	}
	
	public double getTotalPagar(){
		return this.pagoExcedente + this.cuotaFija;
	}
	
	public String toString() {
		String auxStr = "";
		
		//Format
		//deduccionesPermitidas,calculoISR,cuotaFija,pocentajeExcedente,pagoExcedente,totalPagar
		
		auxStr += this.deduccionesPermitidas + ",";
		auxStr += this.calculoISR + ",";
		auxStr += this.cuotaFija + ",";
		auxStr += this.porcentajeExcedente + ",";
		auxStr += this.pagoExcedente + ",";
		auxStr += this.getTotalPagar() + ",";
		
		return auxStr;
	}
}
