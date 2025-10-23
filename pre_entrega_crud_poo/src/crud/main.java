package crud;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        final ArrayList<Producto> arrayProductos = new ArrayList<Producto>();
        final ArrayList<Categoria> arrayCategorias = new ArrayList<Categoria>();

        String nombresCategorias[] = { "Tecno", "Blanqueria", "Textil", "Jardin", "Herramientas", "Libros", "Muebles",
                "Herramientas" };
        for (String c : nombresCategorias) {
            arrayCategorias.add(new Categoria(c));
        }

        CrudCategoria crudCategoria = new CrudCategoria(arrayCategorias);
        CrudProducto crudProducto = new CrudProducto(arrayProductos, arrayCategorias);
        // crudCategoria.read();
        while (true) {
            System.out.println("\n=== Menú Principal ===\n"
                    + "1) CRUD de Productos\n"
                    + "2) CRUD de Categorías\n"
                    + "0) Salir\n");
            int opcion = crudCategoria.leerInt("Seleccione una opción");
            if (opcion == 0)
                break;

            switch (opcion) {
                case 1 -> {

                    do {
                        crudProducto.mostrarOpciones();
                        opcion = crudProducto.leerInt("");
                        switch (opcion) {
                            case 1 -> crudProducto.create();
                            case 2 -> crudProducto.read();
                            case 3 -> crudProducto.update();
                            case 4 -> crudProducto.delete();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (opcion != 0);
                }
                case 2 -> {

                    do {
                        crudCategoria.mostrarOpciones();
                        opcion = crudCategoria.leerInt("");
                        switch (opcion) {
                            case 1 -> crudCategoria.create();
                            case 2 -> crudCategoria.read();
                            case 3 -> crudCategoria.update();
                            case 4 -> crudCategoria.delete();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (opcion != 0);
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }

        }
    }
}
