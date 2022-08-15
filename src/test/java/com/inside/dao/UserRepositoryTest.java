package com.inside.dao;

import com.inside.entity.User;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryTest extends TestCase {

    private UserRepository userRepository;
    private List<User> userList;

    public void setUp() throws Exception {
        super.setUp();

        userRepository = new UserRepository();

        userList = new ArrayList<>();
        userList.add(new User(1, "Oleg"));
        userList.add(new User(2, "Olga"));
        userList.add(new User(3, "Anna"));
        userList.add(new User(4, "Sergey"));
        userList.add(new User(5, "Maxim"));
        userList.add(new User(6, "Artem"));
        userList.add(new User(7, "Nikita"));
    }

    public void testSaveUser() {
        User user = new User(8, "Test");
        userList.add(user);

        userRepository.saveUser(user);

        Assert.assertEquals(userRepository.getAllUsers(), userList);

        Assert.assertFalse(userRepository.saveUser(user));
    }

    public void testGetAllUsers() {
        testSaveUser();

        List<User> testUserList = userRepository.getAllUsers();

        Assert.assertEquals(testUserList, userList);
    }

    public void testUpdateUser() {
        testSaveUser();

        User user = new User(2, "Oleg2");
        userList.set(1, user);

        userRepository.updateUser(user);
        Assert.assertEquals(userRepository.getAllUsers(), userList);

        Assert.assertFalse(userRepository.updateUser(new User(19, "Test")));
    }

    public void testDeleteUser() {
        userList.remove(1);

        userRepository.deleteUser(8);
        userRepository.deleteUser(2);
        Assert.assertEquals(userRepository.getAllUsers(), userList);
    }

    public void testGetUserById() {
        User userTest = userRepository.getUserById(4);
        User user = userList.get(3);

        Assert.assertEquals(userTest, user);

        Assert.assertNull(userRepository.getUserById(9));
    }
}