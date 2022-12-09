package moe.queery.needle.iface;

public interface Service extends Nameable {
    void start();
    void stop();
    boolean isPre();
}
