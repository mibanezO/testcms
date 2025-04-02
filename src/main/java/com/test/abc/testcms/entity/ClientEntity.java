package com.test.abc.testcms.entity;

import com.test.abc.testcms.builder.ClientEntityBuilder;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer age;

    @Column
    private LocalDate birthDate;

    public static ClientEntity from(ClientEntityBuilder builder) {
        return builder.build();
    }

}
