package pt.bmo.list4uee.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 150)
    private String name;

    @Column
    private Double price;

    @Column
    private Integer quantity;

    @Column
    private Boolean picked;
}
