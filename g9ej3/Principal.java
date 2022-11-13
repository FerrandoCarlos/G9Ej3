/**
 * 3. Siguiendo el ejercicio anterior, en el main vamos a crear un ArrayList de
 * Electrodomésticos para guardar 4 electrodomésticos, ya sean lavadoras o
 * televisores, con valores ya asignados.
 * Luego, recorrer este array y ejecutar el método precioFinal() en cada
 * electrodoméstico. Se deberá también mostrar el precio de cada tipo de objeto,
 * es decir, el precio de todos los televisores y el de las lavadoras. Una vez hecho
 * eso, también deberemos mostrar, la suma del precio de todos los
 * Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de 2000
 * y un televisor de 5000, el resultado final será de 7000 (2000+5000) para
 * electrodomésticos, 2000 para lavadora y 5000 para televisor.
 */
package g9ej3;

import java.util.ArrayList;
import java.util.List;
import mislibrerias.Consola;

/**
 * @author Carlos Ferrando
 */
public class Principal {

    public static void main(String[] args) {
        List<Electrodomestico> electrodomesticos = new ArrayList<>();

        menu(electrodomesticos);
    }

    private static void menu(List<Electrodomestico> electrodomesticos) {
        int option;
        int cont = 0;
        final int FIN = 4;
        boolean OUT = false;
        Lavadora l = new Lavadora();
        Televisor t = new Televisor();
        while (!OUT && cont != FIN) {
            System.out.println("---------------------------------------------------");
            System.out.println("-                      MENU                       -");
            System.out.println("---------------------------------------------------");
            System.out.println("-        1)INGRESAR LAVADORA                      -");
            System.out.println("-        2)INGRESAR TELEVISOR                     -");
            System.out.println("-        3)MOSTRAR ELECTRODOMESTICOS              -");
            System.out.println("-        4)MOSTRAR PRECIOS TOTALES                -");
            System.out.println("-        5)SALIR                                  -");
            System.out.println("---------------------------------------------------");
            System.out.println("");
            option = Consola.leerEntero("Ingresar una opción: ");
            switch (option) {
                case 1:
                    l = l.crearLavadora(l);
                    l.precioFinal();
                    electrodomesticos.add(l);
                    break;
                case 2:
                    t = t.crearTelevisor(t);
                    t.precioFinal();
                    electrodomesticos.add(t);
                    break;
                case 3:
                    if (!electrodomesticos.isEmpty()) {
                        mostrarLista(electrodomesticos);
                    } else {
                        Consola.escribir("Lista vacia!!!");
                    }
                    break;
                case 4:
                    sumartotales(electrodomesticos);
                    break;
                case 5:
                    System.out.println("Saliendo del Sistema.......");
                    OUT = true;
                    break;
                default:
                    System.out.println("La opción ingresada no esta en el menu");
            }
            if (option == 1 || option == 2) {
                cont++;
            }

            if (cont == FIN) {
                Consola.escribir("Ya se cargaron cuatro productos");
            }
        }
    }

    private static void sumartotales(List<Electrodomestico> electrodomesticos) {
        double preciosTotales = 0.0;
        for (Electrodomestico var : electrodomesticos) {
            preciosTotales += var.getPrecio();
        }
        Consola.escribir("El precio total de los productos es: "+preciosTotales);
    }

    private static void mostrarLista(List<Electrodomestico> electrodomesticos) {
        for (Electrodomestico electrodomestico : electrodomesticos) {
            Consola.escribir(electrodomestico);
        }
    }

}
