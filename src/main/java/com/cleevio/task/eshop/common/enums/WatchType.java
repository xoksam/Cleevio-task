package com.cleevio.task.eshop.common.enums;

import com.cleevio.task.eshop.common.interfaces.WithDbKey;
import lombok.Getter;

public enum WatchType implements WithDbKey {
    ANALOG("analog"),
    DIGITAL("digital"),
    DIVING("diving"),
    CHRONOGRAPH("chrono"),
    FOUNTAIN("fountain"),

    ;

    @Getter
    private String dbKey;

    WatchType(String dbKey) {
        this.dbKey = dbKey;
    }
}
