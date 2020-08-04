package pers.jamie.vo;

import lombok.Data;

@Data
public class OrderDetailVo {

    /**
     * 名称
     */
    private String name;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 价格
     */
    private Float price;
    /**
     * 消费
     */
    private Float cost;


}
