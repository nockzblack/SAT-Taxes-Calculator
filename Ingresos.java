

public class Ingresos {
    private double sueldoMensual,
                   aguinaldo,
                   primaVacional;

    public Ingresos() {
        this.sueldoMensual = 0;
        this.aguinaldo = 0;
        this.primaVacional = 0;
    }


    public Ingresos(double newSueldoMensual, double newAguinaldo, double newPrimaVacional) {
        this.sueldoMensual = newSueldoMensual;
        this.aguinaldo = newAguinaldo;
        this.primaVacional = newPrimaVacional;
    }

    public void setSueldoMensual(double newSueldoMensual) {
        this.sueldoMensual = newSueldoMensual;
    }

    public double lgetSueldoMensual() {
        return this.sueldoMensual;
    }

    public void setAguinaldo(double newAguinaldo) {
        this.aguinaldo = newAguinaldo;
    }

    public double getAguinaldo() {
        return this.aguinaldo;
    }

    public void setPrimaVacacional(double newPrimaVacacional) {
        this.primaVacional = newPrimaVacacional;
    }

    public double getPrimaVacacional() {
        return this.primaVacional;
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
        auxStr += this.primaVacional + ",";
        auxStr += this.getAguinaldoExcento() + ",";
        auxStr += this.getAguinaldoGravado() + ",";
        auxStr += this.getTotalIngresosGravados();

        return auxStr;
    }
    
    
    private double getPrimaVacionalExcenta() {
    		return this.primaVacional <= 1209?  this.primaVacional:1209;
    }
    
    private double getPrimaVacacionalGravada() {
    		return this.primaVacional - this.getPrimaVacionalExcenta();	
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