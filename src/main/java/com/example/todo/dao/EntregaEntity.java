package com.example.todo.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "entrega")
@Entity
public class EntregaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer entrega_id ;
    @Column
    private Date fecha;
    @Column
    private double total;
    @Column
    private String propietario;
    @Column
    private Date fecha_entrega;
    @Column(name = "usuario_user_id")
    private Integer usuario_user_id;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    name="mueble_has_entrega",
    joinColumns= {@JoinColumn(name="entrega_entrega_id")},
    inverseJoinColumns = {@JoinColumn(name="mueble_mueble_id")}
    )
    private List<MuebleEntity> muebles;

    public EntregaEntity(Integer entrega_id, Date fecha, double total, String propietario, Date fecha_entrega,
            Integer usuario_user_id, List<MuebleEntity> muebles) {
        this.entrega_id = entrega_id;
        this.fecha = fecha;
        this.total = total;
        this.propietario = propietario;
        this.fecha_entrega = fecha_entrega;
        this.usuario_user_id = usuario_user_id;
        this.muebles = muebles;
    }

    public EntregaEntity(Date fecha, double total, String propietario, Date fecha_entrega,
            Integer usuario_user_id, List<MuebleEntity> muebles) {
        this.fecha = fecha;
        this.total = total;
        this.propietario = propietario;
        this.fecha_entrega = fecha_entrega;
        this.usuario_user_id = usuario_user_id;
        this.muebles = muebles;
    }
    public Integer getEntrega_id() {
        return entrega_id;
    }
    public void setEntrega_id(Integer entrega_id) {
        this.entrega_id = entrega_id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public String getPropietario() {
        return propietario;
    }
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    public Date getFecha_entrega() {
        return fecha_entrega;
    }
    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
    public Integer getUsuario_user_id() {
        return usuario_user_id;
    }
    public void setUsuario_user_id(Integer usuario_user_id) {
        this.usuario_user_id = usuario_user_id;
    }
    public List<MuebleEntity> getMuebles() {
        return muebles;
    }
    public void setMuebles(List<MuebleEntity> muebles) {
        this.muebles = muebles;
    }


}

