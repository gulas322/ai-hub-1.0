package com.vm.ai.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 车型表
 * </p>
 *
 * @author Nick~scq
 * @since 2025-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("car")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 车型名称
     */
    private String name;

    /**
     * 车价类型：0-(0-10万)，1-(10-20万)，2-(20-30万)、3-(30-40万)、4-(40万以上)
     */
    private Integer princeLevel;

    /**
     * 汽车类型：轿车、SUV、Crozz、其它
     */
    private String type;

    /**
     * 汽车价格
     */
    private Long price;

    /**
     * 从预定到能提车的时长，单位: 天
     */
    private Integer duration;


}
