package com.homesweethome.Domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {
    private String loginId;
    private String jwtToken;
    private String refreshToken;
}
