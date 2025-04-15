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
 * 
 * </p>
 *
 * @author Nick~scq
 * @since 2025-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("car_reservation")
public class CarReservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 预约车型
     */
    private String car;

    /**
     * 顾客姓名
     */
    private String consumerName;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 4s店位置
     */
    private String location;

    /**
     * 备注
     */
    private String remark;


}
