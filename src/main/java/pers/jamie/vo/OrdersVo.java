package pers.jamie.vo;

import lombok.Data;
import pers.jamie.entity.OrderDetail;

import java.util.List;
@Data
public class OrdersVo {

    private String loginName;

    /**
     * 订单号
     */
    private String serialnumber;
    /**
     * 用户地址
     */
    private String userAddress;
    /**
     * 总金额
     */
    private Float cost;
    /**
     * 订单详情
     */
    List<OrderDetailVo> orderDetails;
}
