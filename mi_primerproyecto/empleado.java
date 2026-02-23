package mi_primerproyecto;

public abstract class Empleado {

    private final int documento;
    private final String nombre;
    private final double salarioBase;

    public Empleado(int documento, String nombre, double salarioBase) {
        if (nombre == null || nombre.trim().isBlank()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        if (salarioBase < 0) {
            throw new IllegalArgumentException("Salario base inválido");
        }

        this.documento = documento;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public int getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public abstract double calcularSalario();

    public abstract double calcularBono();

    public double salarioFinal() {
        return calcularSalario() + calcularBono();
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre +
               " | Documento: " + documento +
               " | Salario Final: " + salarioFinal();
    }
}
