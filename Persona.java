package proyectoMedioTerminoPOO;

public class Persona {
	private String nombre, 
		   rfc;
	private Ingresos ingresos;
	private Gastos gastos;
	private int nivelEd; // 0->Ninguno 1->Primaria 2->Secundaria 3->Preparatoria

	public Persona() {
		this.nombre = "someName";
		this.rfc = "THS!23";
		this.ingresos = new Ingresos();
		this.gastos = new Gastos();
		this.nivelEd = 0;
	}

	public Persona(String nombre, String rfc, Ingresos ingresos, Gastos gastos, int nivelEd) {
		this.nombre = nombre;
		this.rfc = rfc;
		this.ingresos = ingresos;
		this.gastos = gastos;
		this.nivelEd = nivelEd;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public Ingresos getIngresos() {
		return ingresos;
	}

	public void setIngresos(Ingresos ingresos) {
		this.ingresos = ingresos;
	}

	public Gastos getGastos() {
		return gastos;
	}

	public void setGastos(Gastos gastos) {
		this.gastos = gastos;
	}

	public int getNivelEd() {
		return nivelEd;
	}

	public void setNivelEd(int nivelEd) {
		this.nivelEd = nivelEd;
	}

	public String toString() {
	
		// Format:
		// name,rfc,estudios,ingresosData,gastosData
		
		String auxStr = "";

		auxStr += this.nombre + ",";
		auxStr += this.rfc + ",";
		
		//ingresosData
		auxStr += this.ingresos.toString() + ",";

		//dastosData	
		auxStr += this.gastos.toString();

		return auxStr;
	}


//	 public static void main(String[] args) {

//		 System.out.println(new Deduccion(new Persona("Pedro Pérez Pepito", "PEPP800910", new Ingresos(20000, 20000, 10000), new Gastos(5000, 0, 5000, 0, 0, 6000, 0, 8000, 1), 1)));
//		 System.out.println(new Deduccion(new Persona("Pedro Pérez Pepito", "PEPP800910", new Ingresos(25000, 30000, 6000), new Gastos(50000, 0, 30000, 20000, 0, 5000, 0, 25000, 3), 3)));
//		 System.out.println(new Deduccion(new Persona("Pedro Pérez Pepito", "PEPP800910", new Ingresos(150000, 100000, 10000), new Gastos(7000, 3000, 25000, 120000, 800, 20000, 7000, 120000, 3), 3)));
//	}
}
