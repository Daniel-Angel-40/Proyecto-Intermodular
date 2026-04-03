import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionPrincipal = -1;

        do {
            System.out.println("--------- ASIGNACION DE PROYECTOS ---------");
            System.out.println("1. Clientes");
            System.out.println("2. Proyectos");
            System.out.println("3. Desarrolladores");
            System.out.println("4. Asignacion de proyectos");
            System.out.println("0. Salir.");
            System.out.println("--------------------------------------------");
            System.out.println();
            System.out.print("Elige una opcion del menu: ");
            opcionPrincipal = sc.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    System.out.println("\nOPCION EN CONSTRUCCION\n");
                    break;
                case 2:
                    System.out.println("\nOPCION EN CONSTRUCCION\n");
                    break;


                case 3:
                    int opcionDesarrollador = -1;

                    do {
                        System.out.println("--------- MANTENIMIENTO TABLA DESARROLLADOR ---------");
                        System.out.println("1. Crear");
                        System.out.println("2. Consultar");
                        System.out.println("3. Modificar");
                        System.out.println("4. Eliminar");
                        System.out.println("0. Salir mantenimiento DESARROLLADOR.");
                        System.out.println("--------------------------------------------");
                        System.out.println();
                        System.out.print("Elige una opcion del menu: ");
                        opcionDesarrollador = sc.nextInt();

                        switch (opcionDesarrollador) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 0:
                                System.out.println("Saliendo...");
                                break;
                        }
                    } while (opcionDesarrollador != 0);

                    break;

                case 4:
                    System.out.println("\nOPCION EN CONSTRUCCION\n");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (opcionPrincipal != 0);

    }
}
