import enums.Category;
import enums.Gender;
import interfaces.Commands;
import model.Post;
import model.User;

import java.util.Scanner;

public class BlogMain implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static DataStorage dataStorage = new DataStorage();
    private static User us = null;

    public static void main(String[] args) {
        boolean isRun = true;
        int commands;
        while (isRun) {
            Commands.command();
            try {
                commands = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                commands = -1;
            }
            switch (commands) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    registerUser();
                    break;
                case PRINT_POST:
                    dataStorage.printPost();
                    break;
                case PRINT_BY_KEYWORD:
                    printByKeyword();
                    break;
                default:
                    System.out.println("wrong command");
            }
        }
    }

    private static void login() {
        if (dataStorage.isEmptyUser()) {
            System.out.println("no user");
        } else {
            System.out.println("please input email and password for login");
            String s = scanner.nextLine();
            String[] str = s.split(",");
            if (us.getEmail().equals(str[0]) && us.getPassword().equals(str[1])) {
                loginUser();
            }
        }
    }

    private static void loginUser() {
        boolean isRun = true;
        int command;
        while (isRun) {
            Commands.userCommand();
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_POSTS:
                    addPost();
                    break;
                case DELETE_POST:
                    deletePost();
                    break;
                default:
                    System.out.println("wrong command");
            }
        }
    }

    private static void deletePost() {
        System.out.println("please input title for delete post");
        String s = scanner.nextLine();
        dataStorage.getPost(s).clear();
        System.out.println("post dleted");
    }

    private static void addPost() {
        System.out.println("please input title, text, category for add post");
        try {
            String s = scanner.nextLine();
            String[] str = s.split(",");
            Post post = new Post();
            post.setTitle(str[0]);
            post.setText(str[1]);
            post.setCategory(Category.valueOf(str[2].toUpperCase()));
            post.setUser(us);
            dataStorage.addPost(post);
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("please input valid data");
        }

    }

    private static void printByKeyword() {
        if (dataStorage.isEmptyPost()) {
            System.out.println("no post");
        } else {
            System.out.println("please input keyword for search post");
            dataStorage.printPostByKeyword(scanner.nextLine());
        }
    }

    private static void registerUser() {
        System.out.println("please input name, surname,age, email, password, gender for register");
        try {
            String s = scanner.nextLine();
            String[] str = s.split(",");
            User user = new User();
            user.setName(str[0]);
            user.setSurname(str[1]);
            user.setAge(Integer.parseInt(str[2]));
            user.setEmail(str[3]);
            user.setPassword(str[4]);
            user.setGender(Gender.valueOf(str[5].toUpperCase()));
            dataStorage.addUser(user);
            System.out.println("registration completed successfully");
            us = user;
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("please input valid data");
        }
    }

}
