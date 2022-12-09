package moe.queery.needle.iface;

public interface IService extends INameable {
    void start();
    void stop();
    boolean isPre();
}
