package com.cleevio.task.eshop.common.enums;

import com.cleevio.task.eshop.common.interfaces.WithDbKey;
import com.cleevio.task.eshop.common.interfaces.WithI18nMessage;
import lombok.Getter;

public enum WatchType implements WithDbKey, WithI18nMessage {
    ANALOG("analog", "Analog Watch"),
    DIGITAL("digital", "Digital Watch"),
    DIVING("diving", "Diving Watch"),
    CHRONOGRAPH("chrono", "Chronograph Watch"),
    FOUNTAIN("fountain", "Fountain Watch"),

    ;

    @Getter
    private String i18nMessage;

    @Getter
    private String dbKey;

    WatchType(String dbKey, String i18nMessage) {
        this.dbKey = dbKey;
        this.i18nMessage = i18nMessage;
    }
}
