package moe.queery.needle;

public interface Service extends Nameable {
    void start();
    void stop();
    boolean isPre();
}
