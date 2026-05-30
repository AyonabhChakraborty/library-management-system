package observer;
public class PatronObserver implements Observer {

    @Override
    public void update(Event event){
        System.out.println("User : " + event.getUser().getName() + " performed : " + event.getEvent() + " on entity : " + event.getBook().getTitle());
    }
    
}
