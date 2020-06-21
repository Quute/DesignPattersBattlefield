package IteratorCrusade;
class Notification{
    String notification;
    public Notification(String notification){
        this.notification = notification;
    }
    public String getNotification() {
        return notification;
    }
}
interface Collection{
    public Iterator createIterator();
}
interface Iterator{
    //indicates wheter there are more elements to iterator over
    boolean hasNext();
    Object next();
}
class NotificationCollection implements Collection{
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    Notification[] notifications;
    public NotificationCollection(){
        notifications = new Notification[MAX_ITEMS];
        addItem("Notification 1");
        addItem("Notification 2");
        addItem("Notification 3");
    }
    public void addItem(String str){
        Notification notification = new Notification(str);
        if(numberOfItems >= MAX_ITEMS)
            System.out.println("Full");
        else{
            notifications[numberOfItems] = notification;
            numberOfItems = numberOfItems+1;
        }
    }
    public Iterator createIterator(){
        return new NotificationIterator(notifications);
    }

}
class NotificationIterator implements Iterator{
    Notification[] notifications;
    //maintains current position of iterator over the array
    int pos = 0;
    public NotificationIterator(Notification[] notifications){
        this.notifications = notifications;
    }
    public Object next(){
        Notification notification = notifications[pos];
        pos += 1;
        return notification;

    }
    public boolean hasNext(){
        if(pos >= notifications.length || notifications[pos] == null){
            return false;
        }else
            return true;
    }
}
class NotificationBar{
    NotificationCollection notifications;
    public NotificationBar(NotificationCollection notifications){
        this.notifications = notifications;
    }
    public void printNotifications(){
        Iterator iterator = notifications.createIterator();
        System.out.println("---Notification Bar---");
        while(iterator.hasNext()){
            Notification n = (Notification)iterator.next();
            System.out.println(n.getNotification());
        }
    }
}

public class IteratorCrusade {
    public static void main(String[] args) {

        NotificationCollection nc = new NotificationCollection();
        NotificationBar nb = new NotificationBar(nc);
        nb.printNotifications();
    }
}
