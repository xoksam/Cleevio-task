package com.cleevio.task.eshop.converter;

import com.cleevio.task.eshop.common.enums.WatchType;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class WatchTypeEnumConverter extends AbstractEnumConverter<WatchType> {
    public WatchTypeEnumConverter() {
        super(WatchType.values());
    }
}
