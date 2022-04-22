package com.sf.baursaq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comm")
@Data
@NoArgsConstructor
public class Comm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
    private String comment_author;
    private String comment_content;
    private Date comment_timestamp;
}
