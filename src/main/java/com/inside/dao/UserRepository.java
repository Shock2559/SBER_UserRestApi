package com.inside.dao;

import com.inside.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1, "Oleg"));
        userList.add(new User(2, "Olga"));
        userList.add(new User(3, "Anna"));
        userList.add(new User(4, "Sergey"));
        userList.add(new User(5, "Maxim"));
        userList.add(new User(6, "Artem"));
        userList.add(new User(7, "Nikita"));
    }

    public UserRepository() {
    }

    public List<User> getAllUsers() {
        return this.userList;
    }

    public User getUserById(final int id) {

        for(User item: userList) {
            if(item.getId() == id)
                return item;
        }

        return null;
    }

    public boolean saveUser(User newUser) {

        if(getUserById(newUser.getId()) != null) {
            return false;
        }

        this.userList.add(newUser);
        return true;
    }

    public boolean updateUser(User user) {

        boolean flag = false;

        for(int i = 0; i < this.userList.size(); i++) {
            if(this.userList.get(i).getId() == user.getId()) {
                this.userList.get(i).setName(user.getName());
                flag = true;
                break;
            }
        }

        return flag;
    }

    public boolean deleteUser(int id) {

        int index = -1;

        for(int i = 0; i < this.userList.size(); i++) {
            if(this.userList.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if(index != -1)
            this.userList.remove(index);

        return true;
    }


}
