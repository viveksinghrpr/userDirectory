package xtracap.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xtracap.users.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from users.public.user limit  :limit offset  :offset ",nativeQuery = true)
    List<User> getUserList(@Param("offset") int offset, @Param("limit") int limit);
    @Query(value = "select count(*) from users.public.user ",nativeQuery = true)
    int getUsersCount();

}
