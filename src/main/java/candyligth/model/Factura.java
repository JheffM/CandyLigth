package candyligth.model;

import jakarta.persistence.*;

@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private String fechaEmision;
    private double totalFinal;
    private String metodoPago;
    private String estadoPago;

    public Factura() {
    }

    public Factura(int id,
                   Pedido pedido,
                   String fechaEmision,
                   double totalFinal,
                   String metodoPago,
                   String estadoPago) {

        this.id = id;
        this.pedido = pedido;
        this.fechaEmision = fechaEmision;
        this.totalFinal = totalFinal;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
}