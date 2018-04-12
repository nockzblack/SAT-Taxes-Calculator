package proyectoMedioTerminoPOO;

public class Gastos {
	private double medicos,
				   funerarios,
				   sgmm,
				   hipotecarios,
				   donativos,
				   subcuenta,
				   transporte,
				   colegiaturaPagada,
				   colegiaturaMaxDeducir,
				   totalGastos;
	private int nivelEd;
	private static final double colegiaturaDeducir[] = {0, 12900.00, 19900.00, 24500.00};
	
	
	public Gastos() {
		this.medicos = 0;
		this.funerarios = 0;
		this.sgmm = 0;
		this.hipotecarios = 0;
		this.donativos = 0;
		this.subcuenta = 0;
		this.transporte = 0;
		this.colegiaturaPagada = 0;
		this.colegiaturaMaxDeducir = 0;
		this.nivelEd = 0;
		this.totalGastos = 0;
	}
	
	public Gastos (double medicos, double funerarios, double sgmm, double hipotecarios, double donativos, double subcuenta, double transporte, double colegiaturaPagada, int nivelEd) {
		this.medicos = medicos;
		this.funerarios = funerarios;
		this.sgmm = sgmm;
		this.hipotecarios = hipotecarios;
		this.donativos = donativos;
		this.subcuenta = subcuenta;
		this.transporte = transporte;
		this.nivelEd = nivelEd;
		this.colegiaturaPagada = colegiaturaPagada;
		this.colegiaturaMaxDeducir = Gastos.colegiaturaDeducir[this.nivelEd];
		this.totalGastos = this.medicos + this.funerarios + this.sgmm + this.hipotecarios + this.donativos + this.transporte + (this.colegiaturaPagada > this.colegiaturaMaxDeducir ? this.colegiaturaMaxDeducir : this.colegiaturaPagada);
	}

	public double getMedicos() {
		return medicos;
	}

	public void setMedicos(double medicos) {
		this.medicos = medicos;
	}

	public double getFunerarios() {
		return funerarios;
	}

	public void setFunerarios(double funerarios) {
		this.funerarios = funerarios;
	}

	public double getSgmm() {
		return sgmm;
	}

	public void setSgmm(double sgmm) {
		this.sgmm = sgmm;
	}

	public double getHipotecarios() {
		return hipotecarios;
	}

	public void setHipotecarios(double hipotecarios) {
		this.hipotecarios = hipotecarios;
	}

	public double getDonativos() {
		return donativos;
	}

	public void setDonativos(double donativos) {
		this.donativos = donativos;
	}

	public double getSubcuenta() {
		return subcuenta;
	}

	public void setSubcuenta(double subcuenta) {
		this.subcuenta = subcuenta;
	}

	public double getTransporte() {
		return transporte;
	}

	public void setTransporte(double transporte) {
		this.transporte = transporte;
	}

	public double getColegiaturaPagada() {
		return colegiaturaPagada;
	}

	public void setColegiaturaPagada(double colegiaturaPagada) {
		this.colegiaturaPagada = colegiaturaPagada;
	}

	public double getTotalGastos() {
		return totalGastos;
	}

	public void setTotalGastos(double totalGastos) {
		this.totalGastos = totalGastos;
	}
	
	public int getNivelEd() {
		return nivelEd;
	}

	public void setNivelEd(int nivelEd) {
		this.nivelEd = nivelEd;
	}

	public double getColegiaturaMaxDeducir() {
		return colegiaturaMaxDeducir;
	}

	public void setColegiaturaMaxDeducir(double colegiaturaMaxDeducir) {
		this.colegiaturaMaxDeducir = colegiaturaMaxDeducir;
	}
	
	public String toString() {
		String auxStr = "";
		String[] nivelDeEstudios = {"ninguno","primaria", "secundaria", "preparatoria"};
		// Format
		// gMedicos,gFunerarios,SGMM,Hipoteca,donativos,subcuenta,transporte,colegiaturaPagada,colegiaturaADeducir,totalGastos

		auxStr += this.medicos + ",";
		auxStr += this.funerarios + ",";
		auxStr += this.sgmm + ",";
		auxStr += this.hipotecarios + ",";
		auxStr += this.donativos + ",";
		auxStr += this.subcuenta + ",";
		auxStr += this.transporte + ",";
		auxStr += nivelDeEstudios[this.nivelEd] + ",";
		auxStr += this.colegiaturaMaxDeducir + ",";
		auxStr += this.colegiaturaPagada + ",";
		auxStr += this.totalGastos;
		
		return auxStr;
	}

}