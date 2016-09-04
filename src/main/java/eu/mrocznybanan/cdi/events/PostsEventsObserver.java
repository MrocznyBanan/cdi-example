package eu.mrocznybanan.cdi.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class PostsEventsObserver {
    
    @Inject
    Logger log;

    private List<Post> posts;

    @PostConstruct
    public void init() {
        posts = new ArrayList<>();
    }

    public void addPost(@Observes @Created Post post) {
        posts.add(post);
        printPosts();
    }

    public void updatePost(@Observes @Updated Post post) {
        Optional<Post> postOpt = posts.stream()
                .filter(p -> post.getId().equals(p.getId()))
                .findFirst();
        if (postOpt.isPresent()) {
            posts.remove(postOpt.get());
            posts.add(post);
        } else {
            throw new RuntimeException("Post not found");
        }
        printPosts();
    }

    public void removePost(@Observes @Deleted Post post) {
        posts.remove(post);
        printPosts();
    }
    
    private void printPosts() {
        posts.forEach(p -> log.info(p.toString()));
        log.info("---");
    }

}
