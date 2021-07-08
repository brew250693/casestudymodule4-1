package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
    @Query (value = "select * from app_user join friend on app_user.id=friend.to_id where friend.from_id=?;",nativeQuery = true)
    List<AppUser> getListFriend(Long id);
}
