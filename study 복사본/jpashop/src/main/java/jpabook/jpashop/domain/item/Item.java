package jpabook.jpashop.domain.item;


import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name ="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //business logic

    //stock increasing
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    //stock decreasing
    public void removeStock(int quantity) {
        int restStockQuantity = this.stockQuantity - quantity;
        if(restStockQuantity < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStockQuantity;
    }
}
