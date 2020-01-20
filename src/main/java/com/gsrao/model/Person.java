package com.gsrao.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;


@Table("person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    public static final long serialVersionUID = 1L;
    @PrimaryKey
    @Column("id")
    private @NonNull String id;
    @Column("firstName")
    private @NonNull String firstName;
    @Column("lastName")
    private @NonNull String lastName;
    @Column("phone")
    private @NonNull String phone;
    @Column("email")
    private @NonNull String email;
    @Column("address")
    private @NonNull String address;
    @Column("creatDtTime")
    private @NonNull Date creatdttime = new Date();

}
