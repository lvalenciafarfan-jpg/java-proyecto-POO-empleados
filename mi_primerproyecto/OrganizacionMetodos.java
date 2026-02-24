package mi_primerproyecto;

import java.util.ArrayList;
import java.util.List;

public class OrganizacionMetodos {

    private final List<Empleado> empleados;

    public OrganizacionMetodos() {
        this.empleados = new ArrayList<>();
    }

    // Registrar empleado sin permitir documento duplicado
    public void registrarEmpleado(Empleado nuevo) {

        if (nuevo == null) {
            throw new IllegalArgumentException("El empleado no puede ser null");
        }

        for (Empleado e : empleados) {
            if (e.getDocumento() == nuevo.getDocumento()) {
                throw new IllegalArgumentException("Ya existe un empleado con ese documento");
            }
        }

        empleados.add(nuevo);
    }

    // Eliminar por documento 
    public void eliminarEmpleado(int documento) {

        Empleado encontrado = null;

        for (Empleado e : empleados) {
            if (e.getDocumento() == documento) {
                encontrado = e;
                break;
            }
        }

        if (encontrado == null) {
            throw new IllegalArgumentException("Empleado no encontrado");
        }

        empleados.remove(encontrado);
    }

    // Mostrar todos
    public void mostrarTodos() {

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        for (Empleado e : empleados) {
            System.out.println(e); // usa el toString()
        }
    }

    // Obtener empleado mejor pagado
    public Empleado mejorPagado() {

        if (empleados.isEmpty()) {
            throw new IllegalStateException("No hay empleados registrados");
        }

        Empleado mejor = empleados.get(0);

        for (Empleado e : empleados) {
            if (e.salarioFinal() > mejor.salarioFinal()) {
                mejor = e;
            }
        }

        return mejor;
    }

    // Calcular promedio de salarios finales
    public double promedioSalarios() {

        if (empleados.isEmpty()) {
            throw new IllegalStateException("No hay empleados registrados");
        }

        double suma = 0;

        for (Empleado e : empleados) {
            suma += e.salarioFinal();
        }

        return suma / empleados.size();
    }

    // Saber si está vacío
    public boolean estaVacio() {
        return empleados.isEmpty();
    }

    // Cantidad de empleados
    public int cantidadEmpleados() {
        return empleados.size();
    }
}