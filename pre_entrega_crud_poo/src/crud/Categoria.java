package crud;

public class Categoria {
    private int idCategoria;
    private String nombreCategoria;
    private static int contador = 0;

    public Categoria(String nombreCategoria) {
        this.idCategoria = ++contador;
        this.nombreCategoria = nombreCategoria;
    }

    public int getId() {
        return this.idCategoria;
    }

    public String getNombre() {
        return this.nombreCategoria;
    }

    public void setNombre(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria.trim().toUpperCase();
    }

    @Override
    public String toString() {
        return "  Categoria : " + this.nombreCategoria + " || ID " + this.idCategoria;
    }

}
