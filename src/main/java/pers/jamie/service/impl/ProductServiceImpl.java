package pers.jamie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseStatus;
import pers.jamie.entity.Product;
import pers.jamie.mapper.ProductMapper;
import pers.jamie.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {


    @Autowired
    private ProductService service;
    @Override
    public List<Product> findByLevle(Integer level, Integer levelId){
        QueryWrapper wrapper = new QueryWrapper();
        switch (level){
            case 1:
            wrapper.eq("categorylevelone_id", levelId);
            break;
            case 2:
            wrapper.eq("categoryleveltwo_id", levelId);
            break;
            case 3:
            wrapper.eq("categorylevelthree_id", levelId);
            break;
        }
        List<Product> list = service.list(wrapper);
        return list;

    }

}
