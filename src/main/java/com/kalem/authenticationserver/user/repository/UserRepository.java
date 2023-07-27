package com.kalem.authenticationserver.user.repository;

import com.kalem.authenticationserver.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rayan Aksu
 * @since 7/27/2023
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
