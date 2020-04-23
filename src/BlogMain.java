import enums.Category;
import interfaces.Commands;
import model.Post;
import model.User;

import java.util.*;

public class BlogMain implements Commands {

    public static Scanner scanner = new Scanner(System.in);
    static List<Post> posts = new ArrayList<>();
    static Map<String, User> users = new HashMap<>();
    static User us = null;
    static Post po = null;


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
                    System.out.println(posts);
                    break;
                case PRINT_BY_KEYWORD:
                    printByKeyword();
                    break;
                default:
                    System.out.println("wrong command");
            }
        }
    }

    private static void printByKeyword() {
        System.out.println("please input keyword for search post");
        String s = scanner.nextLine();
        if (s.contains(po.getText())){
            System.out.println(po);
        }
        else {
            System.out.println(String.format("Post with %s does not exist",s));
        }
    }

    private static void login() {
        if (users.isEmpty()) {
            System.out.println("no user");
        } else {
            String s = scanner.nextLine();
            if (s.equals(us.getPassword())) {
                users.get(us.getPassword());
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
                    posts.clear();
                default:
                    System.out.println("wrong command");
            }
        }
    }



    private static void registerUser() {
        System.out.println("please input name, surname, email, password  for register");
        try {
            String s = scanner.nextLine();
            String[] arr = s.split(",");
            User user = new User();
            user.setName(arr[0]);
            user.setSurname(arr[1]);
            user.setEmail(arr[2]);
            user.setPassword(arr[3]);
            users.put(user.getPassword(), user);
            System.out.println("registration completed successfully");
            us = user;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("please input valid data");
        }
    }


    public static void addPost() {
        System.out.println("please input title, text, category for add post");
        try {
            String s = scanner.nextLine();
            String[] str = s.split(",");
            Post post = new Post();
            post.setTitle(str[0]);
            post.setText(str[1]);
            post.setCategory(Category.valueOf(str[2].toUpperCase()));
            post.setUser(us);
            posts.add(post);
            po = post;
            System.out.println("post was added");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("please input valid data");
        }
    }
}
