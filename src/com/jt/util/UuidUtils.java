package com.jt.util;

import javax.validation.constraints.NotNull;
import java.util.Locale;
import java.util.UUID;

/**
 * @author com.jt
 * @date 2024/8/3 23:37
 */
public class UuidUtils {

    /**
     * 生成UUID
     *
     * @return UUID String
     */
    public static @NotNull
    String randomUUID(boolean uppercase) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uppercase ? uuid.toUpperCase(Locale.ROOT) : uuid;
    }

    /**
     * 生成UUID
     *
     * @return UUID String
     */
    public static @NotNull
    String randomUUID() {
        return randomUUID(false);
    }
}
