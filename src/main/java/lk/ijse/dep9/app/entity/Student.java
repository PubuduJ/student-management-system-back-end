package lk.ijse.dep9.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student implements SuperEntity {
    @Id
    @Column(columnDefinition = "VARCHAR(10)")
    private String nic;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;
    @Column(nullable = false, columnDefinition = "VARCHAR(150)")
    private String address;
    @Column(nullable = false, columnDefinition = "VARCHAR(11)")
    private String contact;
}
