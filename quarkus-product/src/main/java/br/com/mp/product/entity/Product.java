package br.com.mp.product.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends PanacheEntity {

    @Column(name = "Name may not be blank")
    private String name;

    @Column(name = "Brand may not be blank")
    private String brand;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "created_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    @Column(name = "price")
    private double price;

    public String getPriceFormatted() {
        Locale ptBR = new Locale("pt", "BR");
        NumberFormat formatador = NumberFormat.getCurrencyInstance(ptBR);
        return formatador.format(price);
    }
}

