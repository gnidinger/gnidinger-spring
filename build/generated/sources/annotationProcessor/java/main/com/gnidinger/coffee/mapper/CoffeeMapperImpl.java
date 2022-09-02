package com.gnidinger.coffee.mapper;

import com.gnidinger.coffee.dto.CoffeePatchDto;
import com.gnidinger.coffee.dto.CoffeePostDto;
import com.gnidinger.coffee.dto.CoffeeResponseDto;
import com.gnidinger.coffee.entity.Coffee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-30T19:52:39+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class CoffeeMapperImpl implements CoffeeMapper {

    @Override
    public Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto) {
        if ( coffeePostDto == null ) {
            return null;
        }

        String korName = null;
        String engName = null;
        int price = 0;
        String coffeeCode = null;

        korName = coffeePostDto.getKorName();
        engName = coffeePostDto.getEngName();
        price = coffeePostDto.getPrice();
        coffeeCode = coffeePostDto.getCoffeeCode();

        long coffeeId = 0L;

        Coffee coffee = new Coffee( coffeeId, korName, engName, price, coffeeCode );

        return coffee;
    }

    @Override
    public Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto) {
        if ( coffeePatchDto == null ) {
            return null;
        }

        long coffeeId = 0L;
        String korName = null;
        String engName = null;
        int price = 0;

        coffeeId = coffeePatchDto.getCoffeeId();
        korName = coffeePatchDto.getKorName();
        engName = coffeePatchDto.getEngName();
        price = coffeePatchDto.getPrice();

        String coffeeCode = null;

        Coffee coffee = new Coffee( coffeeId, korName, engName, price, coffeeCode );

        return coffee;
    }

    @Override
    public CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee) {
        if ( coffee == null ) {
            return null;
        }

        long coffeeId = 0L;
        String korName = null;
        String engName = null;
        int price = 0;

        coffeeId = coffee.getCoffeeId();
        korName = coffee.getKorName();
        engName = coffee.getEngName();
        price = coffee.getPrice();

        CoffeeResponseDto coffeeResponseDto = new CoffeeResponseDto( coffeeId, korName, engName, price );

        return coffeeResponseDto;
    }

    @Override
    public List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees) {
        if ( coffees == null ) {
            return null;
        }

        List<CoffeeResponseDto> list = new ArrayList<CoffeeResponseDto>( coffees.size() );
        for ( Coffee coffee : coffees ) {
            list.add( coffeeToCoffeeResponseDto( coffee ) );
        }

        return list;
    }
}
