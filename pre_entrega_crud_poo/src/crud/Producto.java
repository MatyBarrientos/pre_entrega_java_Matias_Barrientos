package crud;

public abstract class Producto implements Ivendible {

    private int id;
    private String nombreProducto;
    private double precioProducto;

    private static int contador = 0;

    public Producto(String nombreProducto, double precioProducto) {

        this.id = ++contador;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return this.precioProducto;
    }

    public String getNombre() {
        return this.nombreProducto;
    }

    public void setNombre(String nombreProducto) {
        this.nombreProducto = nombreProducto.trim().toUpperCase();
    }

    public void setprecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public abstract double calcDescuento();

    @Override
    public String toString() {
        return "ID: " + this.id + " || Nombre: " + this.nombreProducto + " || precio: $"
                + this.precioProducto + " || ";
    }
}
