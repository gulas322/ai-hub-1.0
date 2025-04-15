package com.vm.ai.tools;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.vm.ai.entity.po.Car;
import com.vm.ai.entity.po.CarReservation;
import com.vm.ai.entity.po.Location;
import com.vm.ai.entity.query.CarQuery;
import com.vm.ai.service.ICarReservationService;
import com.vm.ai.service.ICarService;
import com.vm.ai.service.ILocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarTools {

    private final ICarService carService;
    private final ILocationService locationService;
    private final ICarReservationService reservationService;

    @Tool(description = "根据条件查询汽车信息")
    public List<Car> queryCar(@ToolParam(description = "查询条件") CarQuery query) {
        if (query == null) {
//            当用户输入的查询为空的时候，可以考虑返回空列表 List.of()或者是把数据库里所有的车型都返回了carService.list()
            return carService.list();
        }
        QueryChainWrapper<Car> wrapper = carService.query()
                .eq(query.getType() != null, "type", query.getType()) // type = 'SUV'
                .eq(query.getPrince_level() != null, "prince_level", query.getPrince_level());// Prince_level <= 2
        if (query.getSorts() != null && !query.getSorts().isEmpty()) {
            for (CarQuery.Sort sort : query.getSorts()) {
                wrapper.orderBy(true, sort.getAsc(), sort.getField());
            }
        }
        return wrapper.list();
    }


    @Tool(description = "查询所有地点")
    public List<Location> queryLocation() {
        return locationService.list();
    }


    @Tool(description = "生成预约单，返回预约单号")
    public Integer createCarReservation(
            @ToolParam(description = "预约车型") String car,
            @ToolParam(description = "4s店位置") String location,
            @ToolParam(description = "顾客姓名") String consumerName,
            @ToolParam(description = "联系电话") String contactInfo,
            @ToolParam(description = "备注", required = false) String remark) {
        CarReservation reservation = new CarReservation();
        reservation.setCar(car);
        reservation.setLocation(location);
        reservation.setConsumerName(consumerName);
        reservation.setContactInfo(contactInfo);
        reservation.setRemark(remark);
        reservationService.save(reservation);

        return reservation.getId();
    }
}
