package twittersort;

import java.util.Comparator;

public class meuComparadorUser implements Comparator<Post> {
    
    public int compare(Post o1, Post o2) {
        Post c1 = (Post) o1;
        Post c2 = (Post) o2;

        return c1.getUser().compareTo(c2.getUser());
    }
}