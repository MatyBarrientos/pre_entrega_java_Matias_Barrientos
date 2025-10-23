package crud;

public class Servicio extends Producto {

    private int tiempoHoras;

    public Servicio(String nombre, double precio, int tiempoHoras) {
        super(nombre, precio);
        this.tiempoHoras = tiempoHoras;
    }

    public int getTiempoHoras() {
        return this.tiempoHoras;
    }

    public void setTiempoHoras(int horas) {
        this.tiempoHoras = horas;
    }

    @Override
    public double calcDescuento() {
        return super.getPrecio() * 0.80;
    }

    @Override
    public String toString() {
        return super.toString() + " duración: " + this.tiempoHoras + "hs/h";
    }

}
