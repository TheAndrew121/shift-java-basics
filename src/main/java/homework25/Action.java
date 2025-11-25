package homework25;

interface Action {

    void fire();
    void charge();

    default void run() {
        System.out.println("Бежит");
    }
}
