package mi_primerproyecto;

public class EmpleadoTC extends Empleado {

    private double evaluacion;

    public EmpleadoTC(int documento, String nombre, double salarioBase, double evaluacion) {
        super(documento, nombre, salarioBase);

        if (evaluacion < 0 || evaluacion > 5) {
            throw new IllegalArgumentException("Evaluación inválida");
        }

        this.evaluacion = evaluacion;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }

    @Override
    public double calcularBono() {
        if (evaluacion >= 4.5) {
            return getSalarioBase() * 0.20;
        } else if (evaluacion >= 4.0) {
            return getSalarioBase() * 0.10;
        }
        return 0;
    }
}