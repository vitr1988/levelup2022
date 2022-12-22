package ru.levelup.lesson8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "department")
//    private List<Employee> employeeList;
}
