package com.distribuida.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "Factura")

public class Factura {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private int idFactura;
    @Column(name = "num_factura")
    private String NumFactura;
    @Column(name = "fecha")
    private Date Fecha;
    @Column(name = "total_neto")
    private Double TotalNeto;
    @Column(name = "iva")
    private Double Iva;
    @Column(name = "total")
    private Double Total;
    // private int idCliente; foreign key de BD
    //patron de inyeccion d dependencias
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Factura() {
    }

    public Factura(int idFactura, String numFactura, Date fecha, Double totalNeto, Double iva, Double total, Cliente cliente) {
        this.idFactura = idFactura;
        NumFactura = numFactura;
        Fecha = fecha;
        TotalNeto = totalNeto;
        Iva = iva;
        Total = total;
        cliente = cliente;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getNumFactura() {
        return NumFactura;
    }

    public void setNumFactura(String numFactura) {
        NumFactura = numFactura;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Double getTotalNeto() {
        return TotalNeto;
    }

    public void setTotalNeto(Double totalNeto) {
        TotalNeto = totalNeto;
    }

    public Double getIva() {
        return Iva;
    }

    public void setIva(Double iva) {
        Iva = iva;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", NumFactura='" + NumFactura + '\'' +
                ", Fecha=" + Fecha +
                ", TotalNeto=" + TotalNeto +
                ", Iva=" + Iva +
                ", Total=" + Total +
                ", Cliente=" + cliente +
                '}';
    }
}
