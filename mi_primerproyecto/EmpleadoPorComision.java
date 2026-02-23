package mi_primerproyecto;

public class EmpleadoPorComision extends Empleado {

    private double montoVentas;
    private double porcentajeComision;

    public EmpleadoPorComision(int documento, String nombre,
                               double salarioBase,
                               double montoVentas,
                               double porcentajeComision) {

        super(documento, nombre, salarioBase);

        if (montoVentas < 0 || porcentajeComision < 0) {
            throw new IllegalArgumentException("Datos inválidos");
        }

        this.montoVentas = montoVentas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (montoVentas * porcentajeComision);
    }

    @Override
    public double calcularBono() {

        if (montoVentas > 10000) {
            return montoVentas * 0.15;
        }

        return 0;
    }
}