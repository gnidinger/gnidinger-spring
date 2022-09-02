package com.gnidinger.order.mapper;

import com.gnidinger.coffee.entity.Coffee;
import com.gnidinger.order.dto.OrderPatchDto;
import com.gnidinger.order.dto.OrderPostDto;
import com.gnidinger.order.dto.OrderResponseDto;
import com.gnidinger.order.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order orderPostDtoToOrder(OrderPostDto orderPostDto);
    Order orderPatchDtoToOrder(OrderPatchDto orderPatchDtoDto);
    OrderResponseDto orderToOrderResponseDto(Order order, List<Coffee> coffees);
    List<OrderResponseDto> ordersToOrderResponseDtos(List<Order> orders);
}