package ru.levelup.lesson8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_generator")
//    @SequenceGenerator(name = "employee_id_generator", sequenceName = "employee_id_sequence")
    private Integer empId;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    public String toString() {
        return "Employee(empId=" + this.getEmpId() + ", name=" + this.getName() + ", salary=" + this.getSalary() + ", department=" + this.getDepartment() + ")";
    }
}
