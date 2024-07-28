package com.wayne.utils;

import com.google.common.collect.Maps;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Map;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExtensionFields implements Serializable {

    /**
     * 特殊欄位，使用時需先與各方約定
     */
    @Singular
    protected Map<String, String> extras = Maps.newHashMap();
}
