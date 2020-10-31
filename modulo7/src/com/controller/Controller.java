package com.controller;

import com.domain.User;
import com.domain.Video;

import java.util.*;

public class Controller {

    public static int showUserOptions() throws InputMismatchException{
        Scanner sc = new Scanner(System.in);
        boolean correctInput = false;
        int userOption = 0;
        do {
            System.out.println("Please, choose one option. " +
                    "\n1. Create user." +
                    "\n2. Create video." +
                    "\n3. Show my videos." +
                    "\n4. Exit application");

            //check if input data is correct
            if (sc.hasNextInt()) {
                userOption = sc.nextInt();
                correctInput = true;
            } else {
                throw new InputMismatchException();
            }
        } while (!correctInput);
        return userOption;
    }

    public static User createUser() throws RuntimeException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please insert your name: ");
        String newUserName = sc.nextLine();
        if(newUserName == null || newUserName.isEmpty()){
            throw new RuntimeException();
        }

        System.out.println("Please insert your surname: ");
        String newUserSurname = sc.nextLine();
        if(newUserSurname == null || newUserSurname.isEmpty()){
            throw new RuntimeException();
        }

        System.out.println("Please insert your password: ");
        String newUserPassword = sc.nextLine();
        if(newUserPassword == null || newUserPassword.isEmpty()){
            throw new RuntimeException();
        }

        Date newRegistrationDate = new Date();
        User newUser = new User(newUserName,newUserSurname,newUserPassword,newRegistrationDate);
        return newUser;
    }

    public static User passwordController(List<User> users) throws RuntimeException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please insert your user name: ");
        String userName = sc.nextLine();
        System.out.println("Please insert your password: ");
        String password = sc.nextLine();
        User currentUser = null;
        for(User u: users) {
            if(u.getName().equals(userName)) {
                if(u.getPassword().equals(password)) {
                    currentUser = u;
                }
            } else {
                System.out.println("Your name and password did not match, please try again.");
            }
        }
        return currentUser;
    }

    public static Video createVideo(User currentUser) throws RuntimeException{
        Scanner sc = new Scanner(System.in);
        List<String> tags = new ArrayList<String>();
        String tagOrNot;
        boolean addTags = false;

        System.out.println("Please insert a tittle for your video: ");
        String tittle = sc.nextLine();
        if(tittle.equals("")) {
            throw new RuntimeException();
        }

        System.out.println("Please insert the videos url: ");
        String url = sc.nextLine();
        if(url.equals("")) {
            throw new RuntimeException();
        }

        do {
            System.out.println("If you wish to add a tag type 'yes', otherwise type 'no':");
            tagOrNot = sc.nextLine();
            if(tagOrNot.equalsIgnoreCase("yes")) {
                System.out.println("Please insert tag: ");
                String tag = sc.nextLine();
                tags.add(tag);
                addTags = true;
            } else if (!tagOrNot.equalsIgnoreCase("no")){
                System.out.println("Incorrect input,please answer 'yes or 'no.");
            }
        }while(!tagOrNot.equalsIgnoreCase("no"));

        Video newVideo;
        if(addTags) {
            newVideo = new Video(tittle,url,tags);
        }else {
            newVideo = new Video(tittle,url);
        }
        return newVideo;
    }

    public static void seeUserVideos(User currentUser) throws NullPointerException{
        List userVideos = null;
        userVideos = currentUser.getVideos();
        System.out.println("Here is the list of video you have uploaded until now " + userVideos.toString());
    }
}
