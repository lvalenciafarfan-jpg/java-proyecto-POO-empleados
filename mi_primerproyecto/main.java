package mi_primerproyecto;


import java.util.Scanner;

public class main {

    public static void menu() {
        System.out.println("\n--- MENU EMPLEADOS ---");
        System.out.println("1. Registrar empleado por comisión");
        System.out.println("2. Registrar empleado tiempo completo");
        System.out.println("3. Registrar empleado por horas");
        System.out.println("4. Mostrar todos");
        System.out.println("5. Mostrar empleado con mejor salario");
        System.out.println("6. Mostrar promedio de salarios");
        System.out.println("7. Salir");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrganizacionMetodos organizacion = new OrganizacionMetodos();

        int opcion;

        do {
            menu();
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();

            try {

                switch (opcion) {

                    case 1:
                        System.out.print("Documento: ");
                        int docC = sc.nextInt();

                        System.out.print("Nombre: ");
                        String nomC = sc.next();

                        System.out.print("Salario base: ");
                        double baseC = sc.nextDouble();

                        System.out.print("Monto ventas: ");
                        double ventas = sc.nextDouble();

                        System.out.print("Porcentaje comisión (ej 0.10): ");
                        double porcentaje = sc.nextDouble();

                        EmpleadoPorComision empC =
                                new EmpleadoPorComision(docC, nomC, baseC, ventas, porcentaje);

                        organizacion.registrarEmpleado(empC);
                        System.out.println("Empleado registrado.");
                        break;

                    case 2:
                        System.out.print("Documento: ");
                        int docTC = sc.nextInt();

                        System.out.print("Nombre: ");
                        String nomTC = sc.next();

                        System.out.print("Salario base: ");
                        double baseTC = sc.nextDouble();

                        System.out.print("Evaluación (0-5): ");
                        double eval = sc.nextDouble();

                        EmpleadoTC empTC =
                                new EmpleadoTC(docTC, nomTC, baseTC, eval);

                        organizacion.registrarEmpleado(empTC);
                        System.out.println("Empleado registrado.");
                        break;

                    case 3:
                        System.out.print("Documento: ");
                        int docH = sc.nextInt();

                        System.out.print("Nombre: ");
                        String nomH = sc.next();

                        System.out.print("Salario base: ");
                        double baseH = sc.nextDouble();

                        System.out.print("Horas trabajadas: ");
                        int horas = sc.nextInt();

                        System.out.print("Valor por hora: ");
                        double valorHora = sc.nextDouble();

                        EmpleadoPorHoras empH =
                                new EmpleadoPorHoras(docH, nomH, baseH, horas, valorHora);

                        organizacion.registrarEmpleado(empH);
                        System.out.println("Empleado registrado.");
                        break;

                    case 4:
                        organizacion.mostrarTodos();
                        break;

                    case 5:
                        Empleado mejor = organizacion.mejorPagado();
                        System.out.println("Empleado mejor pagado:");
                        System.out.println(mejor);
                        break;

                    case 6:
                        double promedio = organizacion.promedioSalarios();
                        System.out.println("Promedio salarios: " + promedio);
                        break;

                    case 7:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 7);

        sc.close();
    }
}