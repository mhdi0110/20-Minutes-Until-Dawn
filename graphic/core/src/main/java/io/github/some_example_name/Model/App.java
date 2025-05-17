package io.github.some_example_name.Model;

import java.util.ArrayList;

public class App {
    private static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUser(User user) {
        users.add(user);
    }

    public static boolean isUserRegistered(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
