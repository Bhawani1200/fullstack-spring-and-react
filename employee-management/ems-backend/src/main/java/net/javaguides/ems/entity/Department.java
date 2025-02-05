package net.javaguides.ems.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="departments")
public class Department {


    @Id
    @GeneratedValue(strategy =GeneratedValue.IDENTITY)
    private Long  id;

    @Column(name="department_name")
    private String departmentName;

    @Column(name="department_description")
    private String departmentDescription;

}
