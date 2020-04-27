package interfaces;

import netscape.security.UserTarget;

public interface Commands {

    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;
    int PRINT_POST = 3;
    int PRINT_BY_KEYWORD = 4;


    // user commands

    int LOGOUT = 0;
    int ADD_POSTS = 1;
    int DELETE_POST = 2;


    static void command() {
        System.out.println("please input " + EXIT + " for exit");
        System.out.println("please input " + LOGIN + " for login");
        System.out.println("please input " + REGISTER + " for register");
        System.out.println("please input " + PRINT_POST + " for print post");
        System.out.println("please input " + PRINT_BY_KEYWORD + " for print post by keyword");
    }

    static void userCommand(){
        System.out.println("please input " + LOGOUT + " for logout");
        System.out.println("please input " + ADD_POSTS + " for add post");
        System.out.println("please input " + DELETE_POST + " for delete post");
    }

}
