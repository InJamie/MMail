package pers.jamie.service;

import pers.jamie.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
public interface ProductService extends IService<Product> {
    public List<Product> findByLevle(Integer level, Integer levelId);
}
