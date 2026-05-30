package observer;

public class InventoryObserver implements Observer {

    @Override
    public void update(Event event){
        System.out.println("Event : " + event.getEvent() + " on entity : " + event.getBook().getTitle());
    }
}