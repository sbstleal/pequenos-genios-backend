package com.pequenosgenios.pg.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private Integer grade;


    @JsonIgnore
    @OneToMany(mappedBy="classe", cascade = CascadeType.ALL)
    private Set<Student> students;

    @JsonIgnore
    @OneToOne(mappedBy="classe", cascade=CascadeType.ALL)
    private Teacher teacher;

    public Class(Integer grade) {
        this.grade = grade;
    }

}
