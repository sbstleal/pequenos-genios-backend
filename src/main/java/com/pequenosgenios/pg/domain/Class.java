package com.pequenosgenios.pg.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_classes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Class implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer grade;

    @OneToMany(mappedBy="classe")
    private List<Student> students = new ArrayList<>();

    @OneToOne(mappedBy="classe", cascade=CascadeType.ALL)
    private Teacher teacher;

    public Class(Integer id, Integer grade) {
        this.id = id;
        this.grade = grade;
    }
}
