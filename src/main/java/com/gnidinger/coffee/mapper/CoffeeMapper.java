package com.gnidinger.coffee.mapper;

import com.gnidinger.coffee.dto.CoffeePatchDto;
import com.gnidinger.coffee.dto.CoffeePostDto;
import com.gnidinger.coffee.dto.CoffeeResponseDto;
import com.gnidinger.coffee.entity.Coffee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
    List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees);
}
