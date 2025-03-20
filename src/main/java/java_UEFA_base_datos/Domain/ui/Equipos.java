package java_UEFA_base_datos.Domain.ui;

import java.util.Scanner;

import java_UEFA_base_datos.Main;
import java_UEFA_base_datos.Application.Usecase.Equipos.EquipostUseCase;
import java_UEFA_base_datos.Domain.Repository.ClientRespository;
import java_UEFA_base_datos.infrastructure.Database.ConnectionFactory;
import java_UEFA_base_datos.infrastructure.persistence.Equipo.EquipoRepositoryImpl;

public class Equipos {
    public static void main(String[] args) {
        ClientRespository repositorio = new EquipoRepositoryImpl(ConnectionFactory.crearConexion());
        EquipostUseCase clienteCasoUso = new EquipostUseCase(repositorio);

        try(Scanner sc = new Scanner(System.in)){
            String menuEquipos; 
            do {
                
                System.out.println("Menus de Equipos");
                System.out.println("1.)Registrar equipos");
                System.out.println("2.)Buscar equipos");
                System.out.println("3.)Actualizar datos de un equipos");
                System.out.println("4.)Mostrar todos los equipos ");
                System.out.println("5.)Eliminar equipos");
                System.out.println("6.)Salir");
                System.out.print("Elige una opcion = ");
                menuEquipos = sc.nextLine();
                System.out.println("");
                switch (menuEquipos) {
                    case "1":
                        try {
                            int id = 0;
                            System.out.print("Ingrese Nombre del equipo: ");
                            String nombre = sc.nextLine();
                            System.out.print("Ingrese la fecha de creacion del equipo: ");
                            int año_fundacion = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Ingrese el nombre del entrenador: ");
                            String entrenador = sc.nextLine();
                            clienteCasoUso.registrarEquipo(id, nombre, año_fundacion, entrenador);
                            
                        } catch (Exception e) {
                            System.out.println("error vuelve a intentarlo");
                        }

                        break;
                    case "2":
                        try {
                            System.out.print("Ingrese el Id del equipo = ");
                            int idBuscar = sc.nextInt();
                            sc.nextLine();
                            clienteCasoUso.obtenerEquipos(idBuscar);
                            System.out.println("");
                        } catch (Exception e) {
                            System.out.println("error vuelve a intentarlo");
                            System.out.println("");
                        }

                        break;
                    case "3":
                        try {
                            System.out.print("Ingrese el ID del equipo a editar: ");
                            int idNuevo1 = sc.nextInt();
                            sc.nextLine(); 
                            System.out.print("Ingrese el nuevo nombre del equipo: ");
                            String nombreNuevo = sc.nextLine();
                            System.out.print("Ingrese el nuevo año de fundación: ");
                            int añoFundacionNuevo = sc.nextInt();
                            sc.nextLine();  
                            System.out.print("Ingrese el nuevo nombre del entrenador: ");
                            String entrenadorNuevo = sc.nextLine();
                            System.out.println("");
                            System.out.println("Datos anteriores:");
                            clienteCasoUso.obtenerEquipos(idNuevo1);
                            System.out.println("");
                            clienteCasoUso.actualizarEquipos(idNuevo1, nombreNuevo, añoFundacionNuevo, entrenadorNuevo);
                            System.out.println("Datos actualizados:");
                            clienteCasoUso.obtenerEquipos(idNuevo1);
                            System.out.println("");
                        } catch (Exception e) {
                            System.out.println("error vuelve a intentarlo");
                            System.out.println("");
                        }

                        break;
                    case "4":
                        try {
                            clienteCasoUso.listarClientes();
                            System.out.println("");
                        } catch (Exception e) {
                            System.out.println("error vuelve a intentarlo");
                            System.out.println("");
                        }

                        break;
                    case "5":
                        try {
                            System.out.print("Ingrese el Id de la persona a eliminar = ");
                            int idEliminar = sc.nextInt();
                            sc.nextLine();
                            clienteCasoUso.eliminarCliente(idEliminar);
                            System.out.println("");
                        } catch (Exception e) {
                            System.out.println("error vuelve a intentarlo");
                            System.out.println("");
                        }

                        break;
                    case "6":
                        System.out.println("Saliendo.......");
                        Main.main(args);

                        break;
                    default:
                        System.out.println("Dato seleccionado no existe, volviendo a menu........");
                        System.out.println();
                        break;
                    }
                } while (!menuEquipos.equals("6"));            
            } catch (Exception e) {
                System.out.println("Error volviendo a menu");        
        }
    }
}
