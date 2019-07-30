package com.samples.other.buildsql;

import com.samples.other.buildsql.annotation.Column;
import com.samples.other.buildsql.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * User: lanxinghua
 * Date: 2019/7/30 17:09
 * Desc:
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("floor")
public class Floor implements Serializable {

    @Column("id")
    private String id;

    @Column("mall_entity_id")
    private String entityId;

    @Column("floor_name")
    private String floorName;

    @Column("building_id")
    private String buildingId;

    @Column("is_valid")
    private Boolean isValid;
}
