public class Persona {
	String nombre, 
		   rfc;
	Ingresos ingresos;
	Gastos gastos;
	int nivelEd; // 0->Ninguno 1->Primaria 2->Secundaria 3->Preparatoria

	public Persona() {
		this.nombre = "";
		this.rfc = "";
		this.ingresos = null;
		this.gastos = null;
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
		return this.nombre;
	}

	public String getRfc() {
		return this.rfc;
	}

	public Ingresos getIngresos() {
		return this.ingresos;
	}

	public Gastos getGastos() {
		return this.gastos;
	}

	public String getNivelEd() {
		return this.nivelEd;
	}
}