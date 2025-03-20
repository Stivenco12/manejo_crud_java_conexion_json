package java_UEFA_base_datos;

import java.util.Scanner;

import java_UEFA_base_datos.Application.Usecase.Basedatos.BasedatosUseCase;
import java_UEFA_base_datos.Application.Usecase.Estadisticas.EstadisticasUseCase;
import java_UEFA_base_datos.Domain.Repository.ProductResposity;
import java_UEFA_base_datos.Domain.Repository.basedatos;
import java_UEFA_base_datos.Domain.ui.Equipos;
import java_UEFA_base_datos.infrastructure.Database.ConnMySql.UEFA;
import java_UEFA_base_datos.infrastructure.Database.ConnectionFactory;
import java_UEFA_base_datos.infrastructure.persistence.baseDatos.BaseDeDatosRepositoryimpl;
import java_UEFA_base_datos.infrastructure.persistence.estadistiacas.EstadisticasRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        ProductResposity repositorioProduc = new EstadisticasRepositoryImpl(ConnectionFactory.crearConexion());
        EstadisticasUseCase productoCasoUso = new EstadisticasUseCase(repositorioProduc);
        basedatos basedatos = new BaseDeDatosRepositoryimpl(ConnectionFactory.crearConexion());
        BasedatosUseCase basedatosUseCase = new BasedatosUseCase(basedatos);
        try (Scanner sc = new Scanner(System.in)){
            String menu;
            do {
                basedatosUseCase.creardatos();
                basedatosUseCase.crearTabla();
                UEFA.UEFA = "UEFA";
                String menuProductos; 
                System.out.println("");
                System.out.println("Menu principal");
                System.out.println("1.) Entrar a menu de Equipos");
                System.out.println("2.) Entrar a menu de Producto");
                System.out.println("3.) salir....");
                System.out.print("Elige una opcion = ");
                menu = sc.nextLine();
                System.out.println("");
                switch (menu) {
                    case "1":
                            Equipos.main(args);
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