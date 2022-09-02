//...
//
//@Service
//public class OrderService {
//    ...
//
//    public Order updateOrder(Order order) { // // updateOrder() 메서드 추가
//        Order findOrder = findVerifiedOrder(order.getOrderId());
//
//        Optional.ofNullable(order.getOrderStatus())
//                .ifPresent(orderStatus -> findOrder.setOrderStatus(orderStatus));
//        findOrder.setModifiedAt(LocalDateTime.now());
//        return orderRepository.save(findOrder);
//    }
//
//    public Order findOrder(long orderId) {
//        return findVerifiedOrder(orderId);
//    }
//
//    public Page<Order> findOrders(int page, int size) {
//        return orderRepository.findAll(PageRequest.of(page, size,
//                Sort.by("orderId").descending()));
//    }
//
//    public void cancelOrder(long orderId) {
//        Order findOrder = findVerifiedOrder(orderId);
//        int step = findOrder.getOrderStatus().getStepNumber();
//
//        if (step >= 2) {
//            throw new BusinessLogicException(ExceptionCode.CANNOT_CHANGE_ORDER);
//        }
//        findOrder.setOrderStatus(Order.OrderStatus.ORDER_CANCEL);
//        findOrder.setModifiedAt(LocalDateTime.now());
//        orderRepository.save(findOrder);
//    }
//
//    private Order findVerifiedOrder(long orderId) {
//        Optional<Order> optionalOrder = orderRepository.findById(orderId);
//        Order findOrder =
//                optionalOrder.orElseThrow(() ->
//                        new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));
//        return findOrder;
//    }
//}