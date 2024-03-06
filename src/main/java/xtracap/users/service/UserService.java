package xtracap.users.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xtracap.users.entity.User;
import xtracap.users.exception.NoUsersFoundException;
import xtracap.users.repository.UserRepository;

import java.util.List;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(int offset, int limit) throws NoUsersFoundException {
        List<User> users = userRepository.getUserList(offset, limit);
        if (users.isEmpty()) {
            throw new NoUsersFoundException();
        }
        return users;
    }


    public int getTotalUsers(int size) {
        int totalUsers = userRepository.getUsersCount();
        if(totalUsers == 0){
            throw new NoUsersFoundException();
        }
        int totalPages = (totalUsers/size) + 1;
        return totalPages;
    }

    public void saveUser(User user) {
        // Add any additional business logic here (e.g., validation)
        userRepository.save(user);
        log.info("User saved successfully: {}", user);
    }
}
