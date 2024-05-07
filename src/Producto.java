public class Producto {
    private String nombre;
    private double precio;
    private double kg;
    private String tienda;
    public Producto(String nombre, double precio, double kg, String tienda) {
        this.nombre = nombre;
        this.precio = precio;
        this.kg = kg;
        this.tienda = tienda;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getKg() {
        return kg;
    }
    public void setKg(double kg) {
        this.kg = kg;
    }
    public String getTienda() {
        return tienda;
    }
    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
    @Override
    public String toString() {
        return "Producto " + nombre + ", con precio: " + precio + ", kg: " + kg + ", en tienda: " + tienda;
    }

    public double PrecioFinal(){
        return this.precio * this.kg;
    }
}
