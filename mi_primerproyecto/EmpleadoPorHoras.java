package mi_primerproyecto;
public class EmpleadoPorHoras extends Empleado {

    private int horas;
    private double valorHora;

    public EmpleadoPorHoras(int documento, String nombre, double salarioBase,
                            int horas, double valorHora) {

        super(documento, nombre, salarioBase);

        if (horas < 0 || valorHora < 0) {
            throw new IllegalArgumentException("Datos inválidos");
        }

        this.horas = horas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return horas * valorHora;
    }

    @Override
    public double calcularBono() {
        return horas > 160 ? 200 : 0;
    }
}