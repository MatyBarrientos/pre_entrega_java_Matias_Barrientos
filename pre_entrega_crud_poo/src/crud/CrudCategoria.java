package crud;

import java.util.ArrayList;
import java.util.Iterator;

public class CrudCategoria extends CrudConsola<Categoria> {

    private final ArrayList<Categoria> categorias;

    public CrudCategoria(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public void create() {
        // throw new UnsupportedOperationException("Unimplemented method 'crete'");
        String nombreCategoria = super.leerTxt("Ingrese el nombre de la nueva 'Categoria': ");
        Categoria categoria = new Categoria(nombreCategoria);
        if (categorias.contains(categoria)) {
            System.out.println("Categoria ya ingresada");
        } else {

            categorias.add(categoria);
            System.out.println("Categoria con éxito.");
        }
    }

    @Override
    public void read() {
        // throw new UnsupportedOperationException("Unimplemented method 'read'");
        if (categorias.isEmpty())
            System.out.println("Sin categorias");
        else {
            for (Categoria categoria : categorias) {
                System.out.println(categoria);
            }
        }
    }

    @Override
    public void update() {
        // throw new UnsupportedOperationException("Unimplemented method 'update'");
        int idCategoria = super.leerInt("Id de la categoria a modificar: ");
        for (Categoria categoria : categorias) {
            if (categoria.getId() == idCategoria) {
                String nuevoNombre = super.leerTxt("Ingrese el nuevo nombre de la 'Categoria': ");
                categoria.setNombre(nuevoNombre);
                System.out.println("Actualización exitosa. " + categoria.toString());
                return;
            }
            System.out.println("ID: " + idCategoria + " no encontrado en el almacen de 'Categorias'");
        }

    }

    @Override
    public void delete() {
        // throw new UnsupportedOperationException("Unimplemented method 'delete'");
        int idCategoria = super.leerInt("Ingrese el 'ID' de la categoria a eliminar: ");
        boolean banderaEliminado = false;
        Iterator<Categoria> it = categorias.iterator(); // los iterator conozco y se me es familiar, puedo borrar
                                                        // elementos mientras recorro.
        while (it.hasNext()) {
            Categoria categoria = it.next();
            if (categoria.getId() == idCategoria) {
                it.remove();
                banderaEliminado = true;
                break;
            }
        }
        System.out.println(banderaEliminado ? " Categoria Eliminada" : "Categoria no encontrada");
    }

    // método extra, para no comenzar en cero vamos a cargar un par de categorias
    // por defecto

    public static ArrayList<Categoria> cargarCategorias() {

        ArrayList<Categoria> arrayCategorias = new ArrayList<>();
        String nombresCategorias[] = { "Electrodomestico", "Herramienta Electrica", "Jardin", "Herramientas manual",
                "Construcción", "Muebles" };
        for (String c : nombresCategorias) {
            Categoria categoria = new Categoria(c);
            if (!arrayCategorias.contains(categoria)) {
                arrayCategorias.add(categoria);
            }
        }
        return arrayCategorias;
    }

}
