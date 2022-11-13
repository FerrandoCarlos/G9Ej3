/**
 * * Se debe crear también una subclase llamada Televisor con los siguientes
 *
 * Los métodos que se implementara serán:
 *
 *
 */
package g9ej3;

import mislibrerias.Consola;

/**
 * @author Carlos Ferrando
 */
public class Televisor extends Electrodomestico {

    //* atributos: resolución (en pulgadas) y sintonizador TDT (booleano), además de los
    //* atributos heredados.
    private String marca;
    private int resolucion;
    private boolean sintonizadorTDT;

    //  * Los constructores que se implementarán serán:
    //  * • Un constructor vacío.
    //  * • Un constructor con la resolución, sintonizador TDT y el resto de atributos
    //  * heredados. Recuerda que debes llamar al constructor de la clase padre.
    public Televisor() {
    }

    public Televisor(int resolucion, boolean sintonizadorTDT, double precio, String color, char consumoEnergetico, int peso,String marca) {
        super(precio, color, consumoEnergetico, peso, marca);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    //  * • Método get y set de los atributos resolución y sintonizador TDT.
    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        if (resolucion > 0) {
            this.resolucion = resolucion;
        }
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }
//  * • Método crearTelevisor(): este método llama a crearElectrodomestico() de la
//  * clase padre, lo utilizamos para llenar los atributos heredados del padre y
//  * después llenamos los atributos del televisor.

    public Televisor crearTelevisor(Televisor t) {
        
        Consola.escribir("Vamos a cargar los datos del televisor");
        super.crearElectrodomestico();
        Consola.escribir("Ingresar la resolución del TV en pulgadas");
        setResolucion(Consola.leerEntero());
        Consola.escribir("Ingresar si la TV posee sintonzador TDT");
        String tieneSinto = Consola.leer("Si/No");
        while (!tieneSinto.equalsIgnoreCase("Si") && !tieneSinto.equalsIgnoreCase("No")) {
            Consola.escribir("Debe ingresar Si o No!!!");
            tieneSinto = Consola.leer("Si/No");
        }
        setSintonizadorTDT((tieneSinto.equalsIgnoreCase("Si")));

        return t;
    }
//  * • Método precioFinal(): este método será heredado y se le sumará la siguiente
//  * funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
//  * incrementará el precio un 30% y si tiene un sintonizador TDT incorporado,
//  * aumentará $500. Recuerda que las condiciones que hemos visto en la clase
//  * Electrodomestico también deben afectar al precio.

    @Override
    public void precioFinal() {
        super.precioFinal();
        double precioAct = super.getPrecio();
        if (this.resolucion > 40) {
            super.setPrecio(precioAct + (precioAct * 0.3));
        }
        if (this.sintonizadorTDT) {
            super.setPrecio(precioAct + 500);
        }
    }

    @Override
    public String toString() {
        return "Televisor "+ super.toString()
                + " resolucion: " + resolucion + " pulgadas"
                + ", sintonizadorTDT:" + ((sintonizadorTDT) ? " Tiene sintonizador" : " No tiene sintonizador");
    }

}
