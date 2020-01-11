package br.com.itss.SysParkingManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "parking")
public class ParkingRegistration {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_time", nullable = false)
    private Date entryTime;

    @Column(name = "exit_time")
    private Date exitTime;

    @Column(name = "amount_to_be_paid")
    private BigDecimal amountToBePaid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patio_id", nullable = false)
    @JsonIgnore
    private Patio patio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    @JsonIgnore
    private Vehicle vehicle;

    public ParkingRegistration() { }

    public ParkingRegistration(Date entryTime, Date exitTime, BigDecimal amountToBePaid, Patio patio, Vehicle vehicle) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.amountToBePaid = amountToBePaid;
        this.patio = patio;
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public BigDecimal getAmountToBePaid() {
        return amountToBePaid;
    }

    public void setAmountToBePaid(BigDecimal amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }

    public Patio getPatio() {
        return this.patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public Vehicle getVehicle() { return this.vehicle; }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
