package org.example.user.sevice;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.common.service.BaseService;
import org.example.user.entity.User;
import org.example.user.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserBaseService implements BaseService<User, UUID> {
    private static UserBaseService userService = new UserBaseService();
    private static UserRepository userRepository = new UserRepository();
    @Override
    public User findById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public User add(User user) {
        return userRepository.add(user);
    }

    public static UserBaseService getUserService(){
        return userService;
    }

    public User findByUsername(String userName, String password){
        User byUserName = userRepository.findByUserName(userName);
        if (byUserName!=null){
            String userPassword = byUserName.getPassword();
            if (userPassword.equals(password)){
                return byUserName;
            }
        }
        return null;
    }
}
