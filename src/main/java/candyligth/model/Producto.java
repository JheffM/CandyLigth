package candyligth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String tipoVela;
    private String aroma;
    private String color;
    private String tamanio;
    private double precio;
    private int categoriaId;
    private String descripcion;

    @OneToOne(mappedBy = "producto")
    private Inventario inventario;

    public Producto() {
    }

    public Producto(int id, String nombre, String tipoVela,
                    String aroma, String color,
                    String tamanio, double precio,
                    int categoriaId, String descripcion) {

        this.id = id;
        this.nombre = nombre;
        this.tipoVela = tipoVela;
        this.aroma = aroma;
        this.color = color;
        this.tamanio = tamanio;
        this.precio = precio;
        this.categoriaId = categoriaId;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoVela() {
        return tipoVela;
    }

    public void setTipoVela(String tipoVela) {
        this.tipoVela = tipoVela;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}