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

        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===\n"
                    + "1) CRUD de Productos\n"
                    + "2) CRUD de Categorías\n"
                    + "0) Salir\n");
            int linea = crudCategoria.leerInt("Seleccione una opción: ");
            opcion = linea;
            int opcionCrud;
            switch (opcion) {
                case 1 -> {

                    do {
                        crudProducto.mostrarOpciones();
                        opcionCrud = crudProducto.leerInt("");
                        switch (opcionCrud) {
                            case 1 -> crudProducto.create();
                            case 2 -> crudProducto.read();
                            case 3 -> crudProducto.update();
                            case 4 -> crudProducto.delete();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (opcionCrud != 0);
                }
                case 2 -> {

                    do {
                        crudCategoria.mostrarOpciones();
                        opcionCrud = crudCategoria.leerInt("");
                        switch (opcionCrud) {
                            case 1 -> crudCategoria.create();
                            case 2 -> crudCategoria.read();
                            case 3 -> crudCategoria.update();
                            case 4 -> crudCategoria.delete();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (opcionCrud != 0);
                }
                case 0 -> {
                    System.out.println("¡Hasta luego!");
                    break;
                }
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }
}
