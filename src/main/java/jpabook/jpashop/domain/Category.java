package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id @GeneratedValue
    private Long id;
    private String name;

    //자신의 상속관계를 위해서임. 카테고리 밑에 카테고리 쭉 있는거처럼
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;
    @OneToMany (mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany//실무에서 절대 안씀
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )//중간 테이블이 있다 치고 중간테이블을 만드는 과정임
    private List<Item> items = new ArrayList<>();



}