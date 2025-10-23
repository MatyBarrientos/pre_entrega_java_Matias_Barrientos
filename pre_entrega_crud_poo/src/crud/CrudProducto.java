package crud;

import java.util.ArrayList;
import java.util.Iterator;

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
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            Producto producto = it.next();
            if (producto.getId() == idProducto) {
                it.remove();
                banderaEliminado = true;
                break;
            }
        }
        System.out.println(banderaEliminado ? " Producto eliminado" : "Producto no encontrado");
    }

    // lo mismo que en crud categorias, para no arrancar en cero, cargo un par de
    // Productos
    public static ArrayList<Producto> cargarProductos() {

        ArrayList<Producto> arrayProductos = new ArrayList<>();
        ArrayList<Categoria> categoria = CrudCategoria.cargarCategorias();

        // 1 - "Electrodomestico"
        // 2 - "Herramienta Electrica"
        // 3 - "Jardin"
        // 4 - "Herramientas manual"
        // 5 - "Construcción"
        // 6 - "Muebles",
        // 7 - "Plomeria"

        String nombreArticulo[] = {
                "Taladro percutor 750W", // cat 2
                "Amoladora angular 4 1/2\"", // cat 2
                "Atornillador inalámbrico 12V", // cat 2
                "Martillo carpintero", // cat 4
                "Juego de destornilladores x6", // cat 4
                "Llave francesa 10\"", // cat 4
                "Cortacésped eléctrico 1400W", // cat 2
                "Manguera reforzada 15 m", // cat 3
                "Kit de riego por goteo (20 pzs)", // cat 3
                "Aspiradora ciclónica 1200W", // cat 1
                "Licuadora 700W vaso de vidrio", // cat 1
                "Toma corriente doble con USB", // cat 1
                "Cinta aisladora premium", // cat 5
                "Sifón de cocina universal", // cat 5
                "Kit anclaje para TV 32–55\"" // cat 5
        };

        double[] preciosArticulos = { 89999.00, 74999.00, 55999.00, 8599.00, 12999.00, 9999.00, 139999.00, 15999.00,
                24999.00, 119999.00, 69999.00, 8999.00, 2499.00, 10999.00, 14999.00 };

        int indiceCategoria1[] = { 2, 2, 2, 4, 4, 4, 2, 3, 3, 1, 1, 1, 5, 5, 5 };

        for (int i = 0; i < nombreArticulo.length; i++) {
            arrayProductos
                    .add(new Articulo(nombreArticulo[i], preciosArticulos[i], categoria.get(indiceCategoria1[i])));
        }

        String nombreServicio[] = {
                "Instalación de TV en pared",
                "Colocación de lámpara de techo",
                "Cableado de punto de red",
                "Armado de mueble modular",
                "Colocación de cortinas y barral",
                "Reparación de canilla que gotea",
                "Destapación de sifón de cocina",
                "Colocación de puerta placa",
                "Impermeabilización de filtración menor",
                "Mantenimiento de jardín (corte y bordeado)"
        };
        double[] preciosServicios = { 35000.00, 15000.00, 22000.00, 28000.00, 17000.00, 12000.00, 14000.00, 48000.00,
                45000.00, 20000.00 };

        int tiempoServicio[] = { 1, 1, 3, 4, 2, 3, 2, 4, 6, 3 };

        for (int j = 0; j < nombreServicio.length; j++) {
            arrayProductos.add(new Servicio(nombreServicio[j], preciosServicios[j], tiempoServicio[j]));
        }

        return arrayProductos;
    }
}
