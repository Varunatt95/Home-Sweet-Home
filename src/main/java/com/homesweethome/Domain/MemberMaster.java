package com.homesweethome.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member_master", schema="home_sweet_home")
public class MemberMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    Integer memberId;

    @Column(name = "password")
    String password;

    @Column(name = "role")
    String role;

    @Column(name = "login_id")
    String loginId;

    @Column(name = "member_name")
    String memberName;

    @Column(name = "creation_date")
    Timestamp creationDate;

    @Column(name = "modified_date")
    Timestamp modifiedDate;
}
