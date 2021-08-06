package com.cleevio.task.eshop.converter;

import com.cleevio.task.eshop.common.interfaces.WithDbKey;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public abstract class AbstractEnumConverter <T extends WithDbKey> implements AttributeConverter<T, String> {
    final private T[] values;

    public AbstractEnumConverter(T[] values) {
        this.values = values;
    }

    @Override
    public String convertToDatabaseColumn(T attribute) {
        if (attribute == null) {
            return null;
        }

        return attribute.getDbKey();
    }

    @Override
    public T convertToEntityAttribute(String dbKey) {
        if (dbKey == null) {
            return null;
        }

        for (T value : values) {
            if (Objects.equals(value.getDbKey(), dbKey)) return value;
        }

        // DbKey not found
        throw new IllegalStateException("Unknown dbKey '" + dbKey + "' for class '" + this.getClass().getSimpleName() + "'");
    }
}
