package pers.jamie.vo;

import lombok.Data;
import pers.jamie.entity.Product;

import java.util.List;

@Data
public class ProductVoCategory {
    private Integer id;


    private String name;


    private List<ProductVoCategory> child;

    private String bannerImg;
    private String TopImg;

    private List<Product> products;
}
