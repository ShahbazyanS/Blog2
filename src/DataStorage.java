import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.geometry.Pos;
import model.Post;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {


    private List<Post> posts;
    private Map<String, User> userMap = new HashMap<>();
    private Object Exception;

    DataStorage(int lenght) {
        posts = new ArrayList<>(lenght);
    }

    DataStorage() {
        posts = new ArrayList<>();
    }


    public void addPost(Post post) {
        posts.add(post);
    }

    public void addUser(User user) {
        userMap.put(user.getEmail(), user);
    }

    public void printPost() {
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    public void printUser() {
        for (Post post : posts) {
            System.out.println(post.getUser());
        }
    }

    public Post getPostByIndex(int index) {
        return posts.get(index);
    }

    public int getPostsize() {
        return posts.size();
    }

    public int getsizeUser() {
        return userMap.size();
    }

    public boolean isEmptyPost() {
        return posts.isEmpty();
    }

    public boolean isEmptyUser() {
        return userMap.isEmpty();
    }

    public void printPostsByCategory(String category) {
        for (Post post : posts) {
            if (post.getCategory().equals(category)) ;
            System.out.println(post);
        }
    }

    public void printPostByKeyword(String keyword) {
        for (Post post : posts) {
            if (post.getTitle().contains(keyword) || post.getText().contains(keyword)) {
                System.out.println(post);
            } else {
                System.out.println(String.format("post was %s keyword does not exist", keyword));
            }
        }
    }

    public void deletPostByIndex(String title) {
       for (Post post : posts){
           if (post.getTitle().equals(title)){
               posts.remove(post);
           }
       }
    }


    public User getUserByEmailAndPassword(String email, String password) throws Exception {
        for (String s : userMap.keySet()) {
            User user = userMap.get(s);
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new Exception("wrong email or password");
    }
}
