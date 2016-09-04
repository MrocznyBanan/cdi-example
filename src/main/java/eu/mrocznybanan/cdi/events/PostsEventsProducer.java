package eu.mrocznybanan.cdi.events;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import eu.mrocznybanan.cdi.extension_eager.Eager;

@Eager
@ApplicationScoped
public class PostsEventsProducer {

    @Inject @Created
    Event<Post> createdEvent;

    @Inject @Updated
    Event<Post> updatedEvent;

    @Inject @Deleted
    Event<Post> deletedEvent;
    
    //
    
    @Inject
    Event<Post> postEvent;

    @PostConstruct
    public void init() {
        fireQualifiedEvents();
        //
        fireEventWithSelector();
    }

    private void fireQualifiedEvents() {
        Post post1 = new Post(1L, "Title 1" , "Content 1");
        Post post2 = new Post(2L, "Title 2" , "Content 2");
        Post post3 = new Post(3L, "Title 3" , "Content 3");
        //
        createdEvent.fire(post1);
        createdEvent.fire(post2);
        createdEvent.fire(post3);
        //
        updatedEvent.fire(new Post(3L, "Title 3 - UPDATED" , "Content 3 - UPDATED"));
        //
        deletedEvent.fire(post2);
    }
    
    @SuppressWarnings("serial")
    private void fireEventWithSelector() {
        postEvent.select(new AnnotationLiteral<Created>() {
        }).fire(new Post(4L, "Title 4", "Content 4"));
    }
}
