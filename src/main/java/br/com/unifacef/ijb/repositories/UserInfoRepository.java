package br.com.unifacef.ijb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacef.ijb.models.entities.User;
import br.com.unifacef.ijb.models.entities.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, User> {
    
}
