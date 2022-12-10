package moe.queery.needle;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public interface Copyable<C extends Copyable<C>> {
    @SuppressWarnings("rawtypes")
    Class[] EMPTY_DATA = new Class[0];
    Object[] EMPTY_PARAMS = new Object[0];

    @SuppressWarnings("unchecked")
    default @Nullable C copy() {
        final Class<C> clazz = (Class<C>) this.getClass();

        final Constructor<C> constructor;
        try {
            constructor = clazz.getDeclaredConstructor(this.getDataTypes());
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }

        final C object;
        try {
            object = constructor.newInstance(this.getParams());
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }

        for (final Field field : clazz.getFields()) {
            if (Modifier.isStatic(field.getModifiers())) continue;
            try {
                field.set(object, field.get(this));
            } catch (final Throwable t) {
                t.printStackTrace();
                return null;
            }
        }

        return object;
    }

    /**
     * @return the constructors data-types in the correct order for proper object-copying
     */
    @SuppressWarnings("rawtypes")
    default @NotNull Class[] getDataTypes() {
        return EMPTY_DATA;
    }

    /**
     * @return the constructor params in the correct order for proper object-copying
     */
    default @NotNull Object[] getParams() {
        return EMPTY_PARAMS;
    }
}
