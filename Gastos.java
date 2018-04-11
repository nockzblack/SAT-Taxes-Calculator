package proyectoMedioTerminoPOO;

public class Gastos {
	private double medicos,
				   funerarios,
				   sgmm,
				   hipotecarios,
				   donativos,
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
		this.transporte = 0;
		this.colegiaturaPagada = 0;
		this.colegiaturaMaxDeducir = 0;
		this.nivelEd = 0;
		this.totalGastos = 0;
	}
	
	public Gastos (double medicos, double funerarios, double sgmm, double hipotecarios, double donativos, double transporte, double colegiaturaPagada, int nivelEd) {
		this.medicos = medicos;
		this.funerarios = funerarios;
		this.sgmm = sgmm;
		this.hipotecarios = hipotecarios;
		this.donativos = donativos;
		this.transporte = transporte;
		this.colegiaturaPagada = colegiaturaPagada;
		this.colegiaturaMaxDeducir = this.colegiaturaPagada > Gastos.colegiaturaDeducir[nivelEd] ? Gastos.colegiaturaDeducir[nivelEd] : this.colegiaturaPagada;
		this.totalGastos = this.medicos + this.funerarios + this.sgmm + this.hipotecarios + this.donativos + this.transporte + this.colegiaturaMaxDeducir;
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

		// Format
		// gMedicos,gFunerarios,SGMM,Hipoteca,donativos,transporte,colegiaturaPagada,colegiaturaADeducir,totalGastos

		auxStr += this.medicos + ",";
		auxStr += this.funerarios + ",";
		auxStr += this.sgmm + ",";
		auxStr += this.hipotecarios + ",";
		auxStr += this.donativos + ",";
		auxStr += this.transporte + ",";
		auxStr += this.colegiaturaPagada + ",";
		auxStr += this.colegiaturaMaxDeducir + ",";
		auxStr += this.totalGastos;
		
		return auxStr;
	}

}