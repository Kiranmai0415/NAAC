package com.adiverse.erp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adiverse.erp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
  
  @Modifying
  @Transactional
  @Query(value="select u.* from users u,user_roles ur,roles r where u.id = ur.user_id and ur.role_id = r.id and r.name != 'ROLE_QUALITYADVISOR'",nativeQuery=true)
   List<User> userInfo();
  
}
