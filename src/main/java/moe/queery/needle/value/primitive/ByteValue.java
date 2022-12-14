package moe.queery.needle.value.primitive;

import it.unimi.dsi.fastutil.bytes.ByteArrayList;
import moe.queery.needle.Nameable;
import moe.queery.needle.type.consumer.bi.primitive.Byte2ByteBiConsumer;
import moe.queery.needle.value.IValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ByteValue implements IValue, Nameable {
    // @formatter:off
    private static final Byte2ByteBiConsumer EMPTY_CHANGE = (empty1, empty2) -> {};
    // @formatter:on
    private final Byte2ByteBiConsumer change; // left: previous ; right: new
    private final @NotNull ByteArrayList values;

    private final @NotNull String name;

    private byte value;

    // @formatter:off
    ByteValue() { this("Empty", (byte) 0); }
    // @formatter:on

    public ByteValue(final @NotNull String name, final byte value,
                     final byte @NotNull ... values) {
        this(name, value, null, values);
    }

    public ByteValue(final @NotNull String name, final byte value,
                     final @Nullable Byte2ByteBiConsumer change,
                     final byte @NotNull ... values) {
        this.name = name;
        this.value = value;
        this.change = change == null ? EMPTY_CHANGE : change;
        this.values = new ByteArrayList(values);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    public byte getValue() {
        return this.value;
    }

    public void setValue(final byte value) {
        this.change.acceptByte(this.value, this.value = value);
    }

    public @NotNull ByteArrayList getValues() {
        return this.values;
    }
}
