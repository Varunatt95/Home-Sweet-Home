package com.homesweethome.Service;

import com.homesweethome.Config.AppConfig;
import com.homesweethome.Domain.MemberMaster;
import com.homesweethome.Dto.MemberMasterDto;
import com.homesweethome.Repo.MemberMasterRepo;
import com.homesweethome.Config.SecurityConfig;
import com.homesweethome.Util.ObjectMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    @Autowired
    MemberMasterRepo memberMasterRepo;

    @Autowired
    AppConfig appConfig;

    private static ModelMapper modelMapper = new ModelMapper();

    public String saveMember(MemberMasterDto member) {
        String output = new String();
        Optional<MemberMaster> user = memberMasterRepo.findByLoginId(member.getLoginId());
        MemberMaster memberMaster = new MemberMaster();
        if(user.isPresent()){
            memberMaster = user.get();
            memberMaster.setMemberName(member.getMemberName());
            memberMaster.setLoginId(member.getLoginId());
            memberMaster.setPassword(this.appConfig.passwordEncoder().encode(member.getPassword()));
//            memberMaster.setCreationDate(new Timestamp(System.currentTimeMillis()));
            memberMaster.setModifiedDate(new Timestamp(System.currentTimeMillis()));
            memberMaster.setRole(member.getRole());
        }
        else{
            memberMaster.setMemberName(member.getMemberName());
            memberMaster.setLoginId(member.getLoginId());
            memberMaster.setPassword(this.appConfig.passwordEncoder().encode(member.getPassword()));
            memberMaster.setCreationDate(new Timestamp(System.currentTimeMillis()));
            memberMaster.setModifiedDate(new Timestamp(System.currentTimeMillis()));
            memberMaster.setRole(member.getRole());
        }
//        modelMapper.map(member, MemberMaster.class);

        MemberMaster user1 = memberMasterRepo.save(memberMaster);

        if(user1!=null){
            output = "User Created!";
        }
        else{
            output = "Some issue occured!";
        }
        return output;
    }
}
