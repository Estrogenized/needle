package moe.queery.needle.value.primitive.number.limited;

import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import moe.queery.needle.iface.consumer.bi.number.DoubleBiConsumer;
import moe.queery.needle.iface.consumer.bi.number.ShortBiConsumer;
import moe.queery.needle.value.primitive.number.ShortValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LShortValue extends ShortValue {
    private final short min, max;

    // @formatter:off
    LShortValue() { this("Empty", (short) 0, (short) 0, (short) 0); }
    // @formatter:on

    public LShortValue(final @NotNull String name, final short value,
                       final short min, final short max,
                       final short @NotNull ... values) {
        this(name, value, min, max, null, values);
    }

    public LShortValue(final @NotNull String name, final short value,
                       final short min, final short max,
                       final @Nullable ShortBiConsumer change,
                       final short @NotNull ... values) {
        super(name, value, change, values);
        this.min = min;
        this.max = max;
    }

    public short getMin() {
        return this.min;
    }

    public short getMax() {
        return this.max;
    }
}
