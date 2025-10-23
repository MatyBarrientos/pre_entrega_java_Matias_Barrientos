package crud;

import java.util.Scanner;

public abstract class CrudConsola<T> {

    protected final Scanner scan = new Scanner(System.in); // vamos a definir el scanner a usar toda la partida

    // los abstractos CRUD
    public abstract void create();

    public abstract void read();

    public abstract void update();

    public abstract void delete();

    // soy de los que prefieren un solo String, si lo considera un mala práctica
    // hagamelo saver por favor Maty Barrientos
    public void mostrarOpciones() {
        System.out.println(
                "\n=== Menú CRUD ===\n" +
                        "1 - Crear\n" +
                        "2 - Listar\n" +
                        "3 - Actualizar\n" +
                        "4 - Eliminar\n" +
                        "0 - Volver/Salir");
        System.out.print("Opción: ");
    }

    protected int leerInt(String mjs) {
        while (true) {
            try {
                System.out.println(mjs);
                String linea = scan.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Solo números enteros, por favor");
                e.printStackTrace();
            }
        }
    }

    protected double leerDouble(String mjs) {
        while (true) {
            try {
                System.out.println(mjs);
                String linea = scan.nextLine();
                return Double.parseDouble(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("En decimal por favor, por favor");
                e.printStackTrace();
                ;
            }
        }
    }

    protected String leerTxt(String mjs) {
        System.out.println(mjs);
        return scan.nextLine();
    }

}
