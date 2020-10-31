package com.view;
import com.domain.User;
import com.domain.Video;
import com.controller.Controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static com.controller.Controller.seeUserVideos;
import static com.controller.Controller.showUserOptions;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        Boolean exitApp = false;

        do {
            int option = 0;
            try {
                option = showUserOptions();
            } catch (InputMismatchException e) {
                System.out.println("Upps!");
            }
            switch (option) {
                case 1:
                    try {
                        User newUser = Controller.createUser();
                        users.add(newUser);
                    } catch (RuntimeException e) {
                        System.out.println("Fields cannot be let empty, please try again.");
                    }
                    break;
                case 2:
                    User currentUser = Controller.passwordController(users);
                    if (currentUser != null) {
                        try {
                            Video newVideo = Controller.createVideo(currentUser);
                            currentUser.addVideo(newVideo);
                        } catch (RuntimeException e) {
                            System.out.println("Fields cannot be let empty, please try again.");
                        }
                    } else {
                        System.out.println("No user registered under this name and password, please register firts.");
                    }
                    break;
                case 3:
                    currentUser = Controller.passwordController(users);
                    if (currentUser != null) {
                        try {
                            seeUserVideos(currentUser);
                        } catch (NullPointerException e) {
                            System.out.println("No user registered under this name and password, please register firts.");
                        }
                    }else {
                        System.out.println("No user registered under this name and password, please register firts.");
                    }
                    break;
                case 4:
                    System.out.println("You are exiting now the application. See you soon!");
                    exitApp = true;
                    break;
                default:
                    System.out.println("Incorrect input or invalid option, please try again.");
            }
        }while (!exitApp);
    }
}
