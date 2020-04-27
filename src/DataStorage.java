import model.Post;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {


    private List<Post> posts;
    private Map<String, User> userMap = new HashMap<>();

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

    public void deletPostByIndex(int index) {
        posts.remove(index);
    }

    public List<Post> getPost(String title) {
        for (Post post : posts) {
            if (post.getTitle().equals(title)) {
                return posts;
            }
        }
        return null;
    }
}
