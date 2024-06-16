package com.homesweethome.Repo;

import com.homesweethome.Domain.MemberMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberMasterRepo extends JpaRepository<MemberMaster, Integer> {

    public Optional<MemberMaster> findByLoginId(String loginId);

//    public Boolean existByLoginId(String loginId);
}
