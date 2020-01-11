package br.com.itss.SysParkingManagement.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "patio")
public class Patio {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "vacancies_number", nullable = false)
    private Long vacanciesNumber;

    @Column(name = "rate_hour", nullable = false)
    private BigDecimal rateHour;

    public Patio() { }

    public Patio(String description, Long vacanciesNumber, BigDecimal rateHour) {
        this.description = description;
        this.vacanciesNumber = vacanciesNumber;
        this.rateHour = rateHour;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getVacanciesNumber() {
        return vacanciesNumber;
    }

    public void setVacanciesNumber(Long vacanciesNumber) {
        this.vacanciesNumber = vacanciesNumber;
    }

    public BigDecimal getRateHour() {
        return rateHour;
    }

    public void setRateHour(BigDecimal rateHour) {
        this.rateHour = rateHour;
    }
}
