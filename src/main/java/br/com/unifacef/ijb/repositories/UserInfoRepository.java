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

    @Query("SELECT ui FROM UserInfo ui " +
           "INNER JOIN User u ON (u.id = ui.id)" +
           "WHERE u.email = :email")
    Optional<UserInfo> findByUserEmail(@Param("email") String email);

    @Query("SELECT ui FROM UserInfo ui " +
           "INNER JOIN User u ON (u.id = ui.id)" +
           "WHERE u.email = :emailOrCPF OR u.cpf = :emailOrCPF")
    Optional<UserInfo> findByUserEmailOrCPF(@Param("emailOrCPF") String emailOrCPF);
}
