package com.gsrao.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;


@Table
@Data
public class Person {

    @PrimaryKey
    private @NonNull String id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String phone;
    private @NonNull String email;
    private @NonNull String address;
    private @NonNull Date creatdt;

}
