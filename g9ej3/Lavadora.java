/**
 *
 *
 * Los métodos que se implementara serán:
 *
 *
 * 
 */
package g9ej3;

import mislibrerias.Consola;

/**
 * @author Carlos Ferrando
 */
public class Lavadora extends Electrodomestico {
    //* A continuación se debe crear una subclase llamada Lavadora, con el atributo
    //* carga, además de los atributos heredados.

    private int carga;
   

    //* Los constructores que se implementarán serán:
    //* • Un constructor vacío.
    //* • Un constructor con la carga y el resto de atributos heredados. Recuerda que
    //* debes llamar al constructor de la clase padre.
    public Lavadora() {

    }

    public Lavadora(int carga, double precio, String color, char consumoEnergetico, int peso, String marca) {
        super(precio, color, consumoEnergetico, peso,marca);
        this.carga = carga;
    }
    //* • Método get y set del atributo carga.

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        if (carga>0) {
          this.carga = carga;
        }
    }

       
    
    //* • Método crearLavadora (): este método llama a crearElectrodomestico() de la
    //* clase padre, lo utilizamos para llenar los atributos heredados del padre y
    //* después llenamos el atributo propio de la lavadora.

    public Lavadora crearLavadora(Lavadora l) {
        
        Consola.escribir("Vamos a cargar los datos de la lavadora");
        super.crearElectrodomestico();
        Consola.escribir("Ingresar la capacidad de carga de la lavadora en Kg");
        setCarga(Consola.leerEntero());
        
        return l;
    }
   //• Método precioFinal(): este método será heredado y se le sumará la siguiente
   //* funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500,
   //* si la carga es menor o igual, no se incrementará el precio. Este método debe
   //* llamar al método padre y añadir el código necesario. Recuerda que las
   //* condiciones que hemos visto en la clase Electrodoméstico también deben
   //* afectar al precio.
    
    @Override
    public void precioFinal(){
        super.precioFinal();
        if(this.carga>30){
            double precioActual=super.getPrecio();
            super.setPrecio(precioActual+500);
        }
    }

    @Override
    public String toString() {
        return "Lavadora " +super.toString()+" carga: " + carga +" Kg";
    }
    
}
