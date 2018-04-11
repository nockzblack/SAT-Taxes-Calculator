package proyectoMedioTerminoPOO;

public class Ingresos {
    private double sueldoMensual,
                   aguinaldo,
                   primaVacacional;

    public Ingresos() {
        this.sueldoMensual = 0;
        this.aguinaldo = 0;
        this.primaVacacional = 0;
    }


    public Ingresos(double newSueldoMensual, double newAguinaldo, double newPrimaVacional) {
        this.sueldoMensual = newSueldoMensual;
        this.aguinaldo = newAguinaldo;
        this.primaVacacional = newPrimaVacional;
    }

    public void setSueldoMensual(double newSueldoMensual) {
        this.sueldoMensual = newSueldoMensual;
    }

    public double getSueldoMensual() {
        return this.sueldoMensual;
    }

    public void setAguinaldo(double newAguinaldo) {
        this.aguinaldo = newAguinaldo;
    }

    public double getAguinaldo() {
        return this.aguinaldo;
    }

    public void setPrimaVacacional(double newPrimaVacacional) {
        this.primaVacacional = newPrimaVacacional;
    }

    public double getPrimaVacacional() {
        return this.primaVacacional;
    }

    public String toString() {

        // Format
        // sueldoMensual,sueldoAnual,aguinaldo,aguinaldoExcento,aguinaldoGravado, 
    		// primaVacacional,primaVacacionalExcenta,primaVacacionalGravada,
    		// totalIngresosGravados
    	

        String auxStr = "";
        auxStr += this.sueldoMensual + ",";
        auxStr += this.sueldoMensual*12 + ",";
        auxStr += this.aguinaldo + ",";
        auxStr += this.getAguinaldoExcento() + ",";
        auxStr += this.getAguinaldoGravado() + ",";
        auxStr += this.primaVacacional + ",";
        auxStr += this.getPrimaVacacionalExcenta() + ",";
        auxStr += this.getPrimaVacacionalGravada() + ",";
        auxStr += this.getTotalIngresosGravados();

        return auxStr;
    }
    
    
    private double getPrimaVacacionalExcenta() {
    		return this.primaVacacional <= 1209?  this.primaVacacional:1209;
    }
    
    private double getPrimaVacacionalGravada() {
    		return this.primaVacacional - this.getPrimaVacacionalExcenta();	
    }
    
    private double getAguinaldoExcento() {
    		return this.sueldoMensual/2;
    }
    
    private double getAguinaldoGravado() {
    		return this.aguinaldo - this.getAguinaldoExcento();
    }
    
    public double getTotalIngresosGravados() {
    		return (this.sueldoMensual*12) + this.getPrimaVacacionalGravada() + this.getAguinaldoGravado();
    }

}