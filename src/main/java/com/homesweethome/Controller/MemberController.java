package com.homesweethome.Controller;

import com.homesweethome.Domain.CustomUserDetail;
import com.homesweethome.Domain.JwtResponse;
import com.homesweethome.Dto.MemberMasterDto;
import com.homesweethome.Security.JwtHelper;
import com.homesweethome.Service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homeSweetHome")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("/saveMember")
    public ResponseEntity<String> saveMember(@RequestBody MemberMasterDto memberMasterDto){
        String response = memberService.saveMember(memberMasterDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getTokenByRefreshToken")
    public ResponseEntity<JwtResponse> getTokenByRefreshToken(HttpServletRequest request) {
        String requestHeader = request.getHeader("Authorization");
        String token1 = requestHeader.substring(7);
        String loginId = this.jwtHelper.getLoginIdFromToken(token1);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginId);
        String token = this.jwtHelper.generateToken(userDetails);
        String refreshToken = this.jwtHelper.generateRefreshToken(userDetails);
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .refreshToken(refreshToken)
                .loginId(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
