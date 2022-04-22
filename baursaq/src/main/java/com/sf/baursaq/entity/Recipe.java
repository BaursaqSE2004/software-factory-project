package com.sf.baursaq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="recipe")
@Data
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipe_id;
    private String recipe_title;
    private String recipe_content;
    private String recipe_inst;
    private Date recipe_timestamp;
    private Long recipe_likes;
    @OneToMany (cascade=CascadeType.ALL)
    private List<Comm> comments;
}
