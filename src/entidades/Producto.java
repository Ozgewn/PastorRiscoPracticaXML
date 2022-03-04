package entidades;

public class Producto {
    //Atributos
    private int id;
    private String descripcion;
    private int stock;
    private double precio;

    //Constructores
    public Producto(){

    }
    public Producto(int id, String descripcion,int stock, double precio){
        this.id = id;
        this.descripcion = descripcion;
        this.stock =stock;
        this.precio = precio;
    }


    //Getters & Setters
    public int getId() {return id;}
    public void setId(int id) {
        this.id = id;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
