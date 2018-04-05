

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

}