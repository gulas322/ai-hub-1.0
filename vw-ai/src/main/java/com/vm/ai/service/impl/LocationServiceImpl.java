package com.vm.ai.service.impl;

import com.vm.ai.entity.po.Location;
import com.vm.ai.mapper.LocationMapper;
import com.vm.ai.service.ILocationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 4s店定位表表 服务实现类
 * </p>
 *
 * @author Nick~scq
 * @since 2025-04-02
 */
@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements ILocationService {

}
