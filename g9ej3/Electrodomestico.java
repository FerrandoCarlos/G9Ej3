package g9ej3;

import mislibrerias.Consola;

/**
 * @author Carlos Ferrando
 */
public abstract class Electrodomestico {
    //superclase llamada Electrodoméstico con los siguientes atributos:
    // precio, color, consumo energético (letras entre A y F) y peso.

    private double precio;
    private String color;
    private char consumoEnergetico;
    private int peso;
    private Color colores;
    private String marca;

    //* Los constructores que se deben implementar son los siguientes:
    // • Un constructor vacío.
    public Electrodomestico() {
    }

    // • Un constructor con todos los atributos pasados por parámetro.
    public Electrodomestico(double precio, String color, char consumoEnergetico, int peso, String marca) {
        this.precio = precio;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
        this.marca = marca;
        this.colores = colores;
    }

    //* Los métodos a implementar son:
    //* • Métodos getters y setters de todos los atributos.
    //Getters
    public double getPrecio() {
        return precio;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public int getPeso() {
        return peso;
    }
    //Setters

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        }
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public void setPeso(int peso) {
        if (peso > 0) {
            this.peso = peso;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    

    // • Método comprobarConsumoEnergetico(char letra): comprueba que la letra
    //* es correcta, sino es correcta usara la letra F por defecto. Este método se debe
    //* invocar al crear el objeto y no será visible.
    private void comprobarConsumoEnergetico(char letra) {

        if (letra != 'A' && letra != 'B' && letra != 'C' && letra != 'D' && letra != 'E' && letra != 'F') {
            this.consumoEnergetico = 'F';
        } else {
            this.consumoEnergetico = letra;
        }
    }

    //* • Método comprobarColor(String color): comprueba que sel color es correcto, y
    //* si no lo es, usa essssssssssssl color blanco por defecto. Los colores disponibles para los
    //* electrodomésticos son blanco, negro, rojo, azul y gris. No importa si el nombre
    //* está en mayúsculas o en minúsculas. Este método se invocará al crear el
    //* objeto y no será visible.
    private void comprobarColor(String color) {
        Color[] col = Color.values();

        for (int i = 0; i < col.length; i++) {
            if (col[i].name().equalsIgnoreCase(color)) {
                this.color = col[i].name();
                break;
            } else {
                this.color = col[0].name();
            }
        }
    }

    //* • Metodo crearElectrodomestico(): le pide la información al usuario y llena el
    //* electrodoméstico, también llama los métodos para comprobar el color y el
    //* consumo. Al precio se le da un valor base de $1000.  
    public void crearElectrodomestico() {

        setPrecio(1000);
        setMarca(Consola.leer("Ingresar la marca: "));
        Consola.escribir("Vamos a ingresar un color!!!");
        Consola.escribir("Los colores disponibles son: ");
        Consola.escribir("Blanco/Negro/Rojo/Azul/Gris");
        comprobarColor(Consola.leer("Ingrese el color para el producto: "));
        Consola.escribir("Vamos a ingresar la eficiencia energetica!!!");
        Consola.escribir("Los opciones disponibles son: ");
        Consola.escribir("A/B/C/D/E/F");
        comprobarConsumoEnergetico(Consola.leerCaracter("Ingrese la eficiencia energetica del producto: "));
        Consola.escribir("Vamos a ingresar el peso del producto!!!");
        setPeso(Consola.leerEntero("Ingrese el peso en Kg: "));

        
    }

//    * • Método precioFinal(): según el consumo energético y su tamaño, aumentará
//    * el valor del precio. Esta es la lista de precios:
//    * * LETRA PRECIO      PESO PRECIO
//    * A $1000           Entre 1 y 19 kg $100
//    * B $800            Entre 20 y 49 kg $500
//    * C $600            Entre 50 y 79 kg $800
//    * D $500            Mayor que 80 kg $1000
//    * E $300
//    * F $100
    public void precioFinal() {
        char opcion = this.consumoEnergetico;
        switch (opcion) {
            case 'A':
                this.precio += 1000;
                break;
            case 'B':
                this.precio += 800;
                break;
            case 'C':
                this.precio += 600;
                break;
            case 'D':
                this.precio += 500;
                break;
            case 'E':
                this.precio += 300;
                break;
            case 'F':
                this.precio += 100;
                break;
        }
        if (this.peso >= 1 && this.peso <= 19) {
            this.precio += 100;
        } else if (this.peso >= 20 && this.peso <= 49) {
            this.precio += 500;
        } else if (this.peso >= 50 && this.peso <= 79) {
            this.precio += 800;
        } else if (this.peso > 80) {
            this.precio += 1000;
        }
    }

    @Override
    public String toString() {
        return "marca: "+marca+" precio: " + precio + " color: " + color + " consumoEnergetico: " + consumoEnergetico + " peso: " + peso + " Kg";
    }

}
