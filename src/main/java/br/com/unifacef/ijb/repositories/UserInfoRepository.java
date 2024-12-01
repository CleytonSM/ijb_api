package br.com.unifacef.ijb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacef.ijb.models.entities.User;
import br.com.unifacef.ijb.models.entities.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, User> {

    @Query("SELECT ui FROM UserInfo ui "+
           "WHERE ui.user.email = :email")
    Optional<UserInfo> findByUserEmail(@Param("email") String email);

    @Query("SELECT userInfo FROM UserInfo userInfo " +
           "WHERE userInfo.user.email = :emailOrCPF OR userInfo.user.cpf = :emailOrCPF")
    Optional<UserInfo> findByUserEmailOrCPF(@Param("emailOrCPF") String emailOrCPF);

    Optional<UserInfo> findByUser(User user);
}
