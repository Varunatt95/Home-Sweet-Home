package com.homesweethome.Service;

import com.homesweethome.Domain.CustomUserDetail;
import com.homesweethome.Domain.MemberMaster;
import com.homesweethome.Repo.MemberMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private MemberMasterRepo memberMasterRepo;
    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Optional<MemberMaster> user = memberMasterRepo.findByLoginId(loginId);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User does not exists!");
        }
        return new CustomUserDetail(user.get());
    }
}
