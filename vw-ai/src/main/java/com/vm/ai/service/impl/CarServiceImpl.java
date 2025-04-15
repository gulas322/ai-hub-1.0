package com.vm.ai.service.impl;

import com.vm.ai.entity.po.Car;
import com.vm.ai.mapper.CarMapper;
import com.vm.ai.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车型表 服务实现类
 * </p>
 *
 * @author Nick~scq
 * @since 2025-04-02
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

}
