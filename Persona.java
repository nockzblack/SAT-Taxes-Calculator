
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
		String[] nivelDeEstudios = {"Ninguno","Primaria", "Secundaria", "Preparatoria"};
		// Personal Data
		auxStr += this.nombre + ",";
		auxStr += this.rfc + ",";
		auxStr += nivelDeEstudios[this.nivelEd] + ",";

		// Ingresos
		auxStr += this.ingresos.toString() + ",";

		// Gastos
		auxStr += this.gastos.toString();

		return auxStr;
	}


	 public static void main(String[] args) {
		//System.out.println(new Persona());
		 System.out.println(new Persona());
	}
}


