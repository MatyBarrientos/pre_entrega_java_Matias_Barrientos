package crud;

import java.util.ArrayList;

public class CrudProducto extends CrudConsola<Producto> {

    private final ArrayList<Producto> productos;
    private final ArrayList<Categoria> categorias;

    public CrudProducto(ArrayList<Producto> productos, ArrayList<Categoria> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

    @Override
    public void create() {
        System.out.println("1 - Añadir Artículo \n"
                + "2 - Añadir Servicio");
        int opcion = super.leerInt("Elegí una opcionción: ");

        if (opcion == 1) {
            String nombre = super.leerTxt("Nombre del artículo: ");
            double precio = leerDouble("Precio: $ ");
            if (categorias.isEmpty()) {
                System.out.println("No hay categorías. Creá una primero.");
                return;
            }
            System.out.println("Categorías:");
            for (Categoria categoria : categorias) {
                System.out.println(categoria.getId() + ") " + categoria.getNombre());
            }
            int idCategoria = super.leerInt("Seleccione el id de categoría: ");
            Categoria seleccionada = null;
            for (Categoria categoria : categorias) {
                if (categoria.getId() == idCategoria) {
                    seleccionada = categoria;
                    break;
                }
            }
            if (seleccionada != null) {
                productos.add(new Articulo(nombre, precio, seleccionada));
                System.out.println("Artículo creado.");
            } else {
                System.out.println("Categoría inválida.");
            }
        } else if (opcion == 2) {
            String nombre = super.leerTxt("Nombre: ");
            double precio = leerDouble("Precio: ");
            int duracion = super.leerInt("Duración (horas): ");
            productos.add(new Servicio(nombre, precio, duracion));
            System.out.println("Servicio creado.");
        } else {
            System.out.println("opcionción inválida.");
        }
    }

    @Override
    public void read() {
        if (productos.isEmpty()) {
            System.out.println("(aú no hay productos)");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    @Override
    public void update() {
        int id = super.leerInt("Id del producto: ");
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                String nuevoNombre = super.leerTxt("Nuevo nombre: ");
                double nuevopcionrecio = leerDouble("Nuevo precio: ");
                producto.setNombre(nuevoNombre);
                producto.setprecioProducto(nuevopcionrecio);

                if (producto instanceof Articulo) {
                    System.out.println("¿Cambiar categoría? 1=Sí / 0=No");
                    int cam = super.leerInt("Ingrese selección: ");
                    if (cam == 1) {
                        for (Categoria categoria : categorias) {
                            System.out.println("ID: " + categoria.getId() + "-> Nombre: " + categoria.getNombre());
                        }
                        int idCategoria = super.leerInt("Ingrese el ID de la categoría: ");
                        for (Categoria categoria : categorias) {
                            if (categoria.getId() == idCategoria) {
                                ((Articulo) producto).setCategoria(categoria);
                                break;
                            }
                        }
                    }
                }

                if (producto instanceof Servicio) {
                    System.out.println("¿Cambiar duración (horas)? 1=Sí / 0=No");
                    int cam = super.leerInt("Ingrese selección: ");
                    if (cam == 1) {
                        int duracion = super.leerInt("Nueva duración (horas): ");
                        ((Servicio) producto).setTiempoHoras(duracion);
                    }
                }

                System.out.println("Actualizado: " + producto);
                return;
            }
        }
        System.out.println("No se encontró producto con id " + id);
    }

    @Override
    public void delete() {
        int idProducto = super.leerInt("Ingrese el 'ID' de la categoria a eliminar: ");
        boolean banderaEliminado = false;
        for (Producto producto : productos) {
            if (producto.getId() == idProducto)
                banderaEliminado = true;
            productos.remove(producto);
        }
        System.out.println(banderaEliminado ? " Producto eliminado" : "Producto no encontrado");
    }

}
