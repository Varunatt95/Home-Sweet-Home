package com.homesweethome.Dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class MemberMasterDto {

    String password;

    String loginId;

    String role;

    String memberName;

    Timestamp creationDate;

    Timestamp modifiedDate;
}
