package pt.bmo.list4uee.model;

import lombok.Data;
import pt.bmo.list4uee.enums.Supermarket;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Supermarket supermarket;

    @Column
    private LocalDate createdAt;

    @OneToMany
    private List<Item> items;
}
