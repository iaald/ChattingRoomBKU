import com.csc1004.chattingroom.client.ClientMenu;

public class testerMain{
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
        System.out.println("Test Start");
    }
}
class Cat extends Thread{
    @Override
    public void run(){
        ClientMenu clientMenu = new ClientMenu();
        clientMenu.showMainMenu();
    }
}
