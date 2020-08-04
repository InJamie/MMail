package pers.jamie.service;

import pers.jamie.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.jamie.vo.ProductVoCategory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    public List<ProductVoCategory> getall();


}
