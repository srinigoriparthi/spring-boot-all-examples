package com.gsrao.model;


import com.datastax.driver.core.LocalDate;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
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

}
