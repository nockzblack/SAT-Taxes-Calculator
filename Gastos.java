

public class Gastos {
	private double medicos,
				   funerarios,
				   sgmm,
				   hipotecarios,
				   donativos,
				   transporte,
				   colegiatura,
				   totalGastos;
	
	public Gastos() {
		this.medicos = 0;
		this.funerarios = 0;
		this.sgmm = 0;
		this.hipotecarios = 0;
		this.donativos = 0;
		this.transporte = 0;
		this.colegiatura = 0;
		this.totalGastos = 0;
	}
	
	public Gastos (double medicos, double funerarios, double sgmm, double hipotecarios, double donativos, double transporte, double colegiatura) {
		this.medicos = medicos;
		this.funerarios = funerarios;
		this.sgmm = sgmm;
		this.hipotecarios = hipotecarios;
		this.donativos = donativos;
		this.transporte = transporte;
		this.colegiatura = colegiatura;
		this.totalGastos = this.medicos + this.funerarios + this.sgmm + this.hipotecarios + this.donativos + this.transporte + this.colegiatura;
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

	public double getColegiatura() {
		return colegiatura;
	}

	public void setColegiatura(double colegiatura) {
		this.colegiatura = colegiatura;
	}

	public double getTotalGastos() {
		return totalGastos;
	}

	public void setTotalGastos(double totalGastos) {
		this.totalGastos = totalGastos;
	}

	public String toString() {
		String auxStr = "";

		// Format
		// gMedicos,gFunerarios,SGMM,Hipoteca,donativos,transporte,colegiatura,totalGastos

		auxStr += this.medicos + ",";
		auxStr += this.sgmm + ",";
		auxStr += this.hipotecarios + ",";
		auxStr += this.donativos + ",";
		auxStr += this.transporte + ",";
		auxStr += this.colegiatura + ",";
		auxStr += this.totalGastos;
		
		return auxStr;
	}
}