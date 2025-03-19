package java_UEFA_base_datos;

import java.util.Scanner;

import java_UEFA_base_datos.Application.Usecase.Basedatos.BasedatosUseCase;
import java_UEFA_base_datos.Application.Usecase.Client.EquipostUseCase;
import java_UEFA_base_datos.Application.Usecase.Product.ProductUseCase;
import java_UEFA_base_datos.Domain.Repository.ClientRespository;
import java_UEFA_base_datos.Domain.Repository.ProductResposity;
import java_UEFA_base_datos.Domain.Repository.basedatos;
import java_UEFA_base_datos.infrastructure.Database.ConnMySql.UEFA;
import java_UEFA_base_datos.infrastructure.Database.ConnectionFactory;
import java_UEFA_base_datos.infrastructure.persistence.Equipo.EquipoRepositoryImpl;
import java_UEFA_base_datos.infrastructure.persistence.Product.ProductRepositoryImpl;
import java_UEFA_base_datos.infrastructure.persistence.baseDatos.BaseDeDatosRepositoryimpl;

public class Main {
    public static void main(String[] args) {
        ClientRespository repositorio = new EquipoRepositoryImpl(ConnectionFactory.crearConexion());
        EquipostUseCase clienteCasoUso = new EquipostUseCase(repositorio);
        ProductResposity repositorioProduc = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
        ProductUseCase productoCasoUso = new ProductUseCase(repositorioProduc);
        basedatos basedatos = new BaseDeDatosRepositoryimpl(ConnectionFactory.crearConexion());
        BasedatosUseCase basedatosUseCase = new BasedatosUseCase(basedatos);
        try (Scanner sc = new Scanner(System.in)){
            String menu;
            do {
                basedatosUseCase.creardatos();
                basedatosUseCase.crearTabla();
                UEFA.UEFA = "UEFA";
                String menuEquipos; 
                String menuProductos; 
                System.out.println("1.) Entrar a menu de Equipos");
                System.out.println("2.) Entrar a menu de Producto");
                System.out.println("3.) salir....");
                System.out.print("Elige una opcion = ");
                menu = sc.nextLine();
                System.out.println("");
                switch (menu) {
                    case "1":
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
                                        int idNuevo = sc.nextInt();
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
                                        clienteCasoUso.obtenerEquipos(idNuevo);
                                        clienteCasoUso.actualizarEquipos(idNuevo, nombreNuevo, añoFundacionNuevo, entrenadorNuevo);
                                        System.out.println("Datos actualizados:");
                                        clienteCasoUso.obtenerEquipos(idNuevo);
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
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("Dato seleccionado no existe, volviendo a menu........");
                                    System.out.println();
                                    break;
                            }
                        } while (!menuEquipos.equals("6"));
                        break;

                    // productos

                    case "2":
                        do {
                            System.out.println("Menus de productos");
                            System.out.println("1.)Registrar Productos");
                            System.out.println("2.)Buscar producto");
                            System.out.println("3.)Actualizar datos de un producto");
                            System.out.println("4.)Mostrar todos los productos ");
                            System.out.println("5.)Eliminar producto");
                            System.out.println("6.)Salir");
                            System.out.print("Elige una opcion = ");
                            menuProductos = sc.nextLine();
                            System.out.println("");
                            switch (menuProductos) {
                                case "1":
                                    try {
                                        int id = 0;
                                        System.out.print("Ingrese Nombre: ");
                                        String nombre = sc.nextLine();
                                        System.out.print("Ingrese el stock: ");
                                        int stock = sc.nextInt();
                                        sc.nextLine();
                                        if (stock >= 0) {
                                            productoCasoUso.registrarProducto(id, nombre, stock);
                                            System.out.println("Producto registrado exitosamente.");     
                                            System.out.println("");
                                        }else{
                                            System.out.println("No esta permitido STOCK negativo");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
           
                                break;
                                case "2":
                                    try {
                                        System.out.print("Ingrese el Id del producto = ");
                                        int idBuscarProducto = sc.nextInt();
                                        sc.nextLine();
                                        productoCasoUso.obtenerProducto(idBuscarProducto);
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
                 
                                break;
                                case "3":
                                    try {
                                        System.out.print("Ingrese el Id del producto a editar = ");
                                        int idProductonuuevo = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Ingrese el nuevo nombre del Producto = ");
                                        String NuevoProducto = sc.nextLine();
                                        System.out.print("Ingrese el nuevo Stock = ");
                                        int NuevoStock = sc.nextInt();
                                        sc.nextLine();
                                        if (NuevoStock >= 0) {
                                            System.out.println("");
                                            System.out.println("Datos anteriores = ");
                                            productoCasoUso.obtenerProducto(idProductonuuevo);
                                            productoCasoUso.actualizarProducto(idProductonuuevo, NuevoProducto, NuevoStock);
                                            System.out.println("");
                                            System.out.println("Datos actualizados = ");
                                            productoCasoUso.obtenerProducto(idProductonuuevo);
                                            System.out.println("");
                                        }else{
                                            System.out.println("No esta permitido STOCK negativo");
                                        }
                                     

                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
                                    break;
                                case "4":
                                    try {
                                        productoCasoUso.listarProducts();
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }

                                    break;
                                case "5":
                                    try {
                                        System.out.print("Ingrese el Id del producto a eliminar = ");
                                        int idEliminarProducto = sc.nextInt();
                                        sc.nextLine();
                                        productoCasoUso.eliminarProducto(idEliminarProducto);
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
                         
                                    break;
                                case "6":
                                    System.out.println("Saliendo.......");
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("Dato seleccionado no existe, volviendo a menu........");
                                    System.out.println();
                                    break;
                            }
                        } while (!menuProductos.equals("6"));
                        break;

                    case "3":
                        System.out.println("Saliendo.......");
                        System.out.println();
                        break;
                    default:
                        System.out.println("Dato seleccionado no existe, volviendo a menu........");
                        System.out.println();
                    break;
                }   
            }while(!menu.equals("3"));
        }catch(Exception e) {
            System.out.println("Error por favor vuelve a iniciar el programa");
        }
    }
}