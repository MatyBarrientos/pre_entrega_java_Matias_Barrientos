package crud;

import java.util.ArrayList;

public class CrudCategoria extends CrudConsola<Categoria> {

    private final ArrayList<Categoria> categorias;

    public CrudCategoria(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public void create() {
        // throw new UnsupportedOperationException("Unimplemented method 'crete'");
        String nombreCategoria = super.leerTxt("Ingrese el nombre de la nueva 'Categoria'");
        categorias.add(new Categoria(nombreCategoria.toLowerCase()));
        System.out.println("Categoria con éxito.");
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
            } else {
                System.out.println("ID: " + idCategoria + " no encontrado en el almacen de 'Categorias'");
            }
        }

    }

    @Override
    public void delete() {
        // throw new UnsupportedOperationException("Unimplemented method 'delete'");
        int idCategoria = super.leerInt("Ingrese el 'ID' de la categoria a eliminar: ");
        boolean banderaEliminado = false;
        for (Categoria categoria : categorias) {
            if (categoria.getId() == idCategoria)
                banderaEliminado = true;
            categorias.remove(categoria.getId());
        }
        System.out.println(banderaEliminado ? " Categoria Eliminada" : "Categoria no encontrada");
    }

}
