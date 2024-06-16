package com.homesweethome.Controller;

import com.homesweethome.Dto.MemberMasterDto;
import com.homesweethome.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homeSweetHome")
public class MemberController {

    @Autowired
    private MemberService memberService;
    @PostMapping("/saveMember")
    public ResponseEntity<String> saveMember(@RequestBody MemberMasterDto memberMasterDto){
        String response = memberService.saveMember(memberMasterDto);
        return ResponseEntity.ok(response);
    }
}
