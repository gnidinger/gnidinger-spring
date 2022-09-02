//package com.gnidinger.order.controller;
//
//import com.gnidinger.coffee.service.CoffeeService;
//import com.gnidinger.order.entity.Order;
//import com.gnidinger.order.service.OrderService;
//import com.gnidinger.order.dto.OrderPostDto;
//import com.gnidinger.order.dto.OrderPatchDto;
//import com.gnidinger.order.dto.OrderResponseDto;
//import com.gnidinger.order.mapper.OrderMapper;
//import com.gnidinger.response.MultiResponseDto;
//import com.gnidinger.response.SingleResponseDto;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.validation.constraints.Positive;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/v11/orders")
//@Validated
//public class OrderController {
//    private final OrderService orderService;
//    private final OrderMapper mapper;
//    private final CoffeeService coffeeService;
//
//    public OrderController(OrderService orderService,
//                           OrderMapper mapper,
//                           CoffeeService coffeeService) {
//        this.orderService = orderService;
//        this.mapper = mapper;
//        this.coffeeService = coffeeService;
//    }
//
//    @PostMapping
//    public ResponseEntity postOrder(@Valid @RequestBody OrderPostDto orderPostDto) {
//        Order order = orderService.createOrder(mapper.orderPostDtoToOrder(orderPostDto));
//
//        // TODO JPA에 맞춰서 커피 정보 변경 필요
//        // List<Coffee> coffees = coffeeService.findOrderedCoffees(order);
//        return new ResponseEntity<>(
//                new SingleResponseDto<>(mapper.orderToOrderResponseDto(order, null)),
//                HttpStatus.CREATED);
//    }
//
//    @PatchMapping("/{order-id}")
//    public ResponseEntity patchOrder(@PathVariable("order-id") @Positive long orderId,
//                                     @Valid @RequestBody OrderPatchDto orderPatchDto) {
//        orderPatchDto.setOrderId(orderId);
//        Order order = orderService.updateOrder(mapper.orderPatchDtoToOrder(orderPatchDto));
//
//        return new ResponseEntity<>(
//                new SingleResponseDto<>(mapper.orderToOrderResponseDto(order, null)), HttpStatus.OK);
//    }
//
//    @GetMapping("/{order-id}")
//    public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId) {
//        Order order = orderService.findOrder(orderId);
//
//        // TODO JPA에 맞춰서 변경 필요
//        // List<Coffee> coffees = coffeeService.findOrderedCoffees(order);
//        return new ResponseEntity<>(
//                new SingleResponseDto<>(mapper.orderToOrderResponseDto(order, null)),
//                HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity getOrders(@Positive @RequestParam int page,
//                                    @Positive @RequestParam int size) {
//        Page<Order> pageOrders = orderService.findOrders(page - 1, size);
//        List<Order> orders = pageOrders.getContent();
//
//        // TODO JPA에 맞춰서 주문 커피 정보 추가 필요
//        return new ResponseEntity<>(
//                new MultiResponseDto<>(mapper.ordersToOrderResponseDtos(orders), pageOrders),
//                HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{order-id}")
//    public ResponseEntity cancelOrder(@PathVariable("order-id") @Positive long orderId) {
//        orderService.cancelOrder(orderId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}