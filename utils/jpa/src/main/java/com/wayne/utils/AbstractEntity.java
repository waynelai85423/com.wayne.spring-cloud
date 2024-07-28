package com.wayne.utils;

import com.google.common.collect.Maps;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Parameter;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class AbstractEntity<U extends Serializable> implements Serializable {

    /**
     * id
     */
    @NotNull(groups = OnUpdate.class)
    @Id
    @GeneratedValue(generator = "pooled")
    @GenericGenerator(name = "pooled", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
            @Parameter(name = "table_name", value = "sequence_pooled"),
            @Parameter(name = "value_column_name", value = "sequence_next_hi_value"),
            @Parameter(name = "prefer_entity_table_as_segment_value", value = "true"),
            @Parameter(name = "optimizer", value = "pooled-lo"),
            @Parameter(name = "initial_value", value = "100001"),
            @Parameter(name = "increment_size", value = "100") })
    @Column(name = "id")
    protected Long id;

    /**
     * 建立時間
     */
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    protected LocalDateTime createdDate;

    /**
     * 建立人員
     */
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    protected U createdBy;

    /**
     * 最後修改時間
     */
    @LastModifiedDate
    @Column(name = "last_modified_date")
    protected LocalDateTime lastModifiedDate;

    /**
     * 最後修改人員
     */
    @LastModifiedBy
    @Column(name = "last_modified_by")
    protected U lastModifiedBy;

    /**
     * 是否刪除
     */
    @Column(name = "deleted")
    protected LocalDateTime deleted;

    /**
     * 資料儲存的版本
     */
    @Version
    @Column(name = "version")
    Long version;

    /**
     * 特殊欄位，使用時需先與各方約定
     */
//    @Convert(converter = JsonStringType.class)
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "extras", columnDefinition = "varchar(4000)")
    @Singular
    private Map<String, String> extras = Maps.newHashMap();
}

