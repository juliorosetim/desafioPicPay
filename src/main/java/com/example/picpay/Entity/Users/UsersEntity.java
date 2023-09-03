package com.example.picpay.Entity.Users;

import com.example.picpay.Entity.wallet.WalletEntity;
import com.example.picpay.Enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    @Column(name = "firstname")
    String firstName;
    @NonNull
    @Column(name = "lastname")
    String lastName;
    @NonNull
    @Column(name = "cpfcnpj", unique = true)
    String cpfCnpj;
    @NonNull
    @Column(name = "email", unique = true)
    String email;
    @NonNull
    @Column(name = "password")
    String password;
    @NonNull
    @Column(name = "usertype")
    UserType userType;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private WalletEntity wallet;

}
