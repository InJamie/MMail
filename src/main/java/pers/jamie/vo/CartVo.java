package pers.jamie.vo;

import lombok.Data;

@Data
public class CartVo {
    private Integer id;
    private String name;
    private String fileName;
    private Float price;

    private Integer productId;
    private Integer quantity;
    private Float cost;

    /**
     * 库存
     */
    private Integer stock;
}
