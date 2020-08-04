package pers.jamie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pers.jamie.entity.ProductCategory;
import pers.jamie.mapper.ProductCategoryMapper;
import pers.jamie.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.jamie.service.ProductService;
import pers.jamie.vo.ProductVoCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jamie
 * @since 2020-07-25
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper mapper;
    @Autowired
    private ProductService productService;

    @Override
    public List<ProductVoCategory> getall() {
//        完成逻辑操作查询所有类型分类并进行封装
//        1.获取一级标题
        QueryWrapper wrapper  = new QueryWrapper();
        wrapper.eq("type",1);
        List<ProductCategory> list1 = mapper.selectList(wrapper);
//        创建一级Vo
        List<ProductVoCategory> volist1 = new ArrayList<>();
        int i = 0;
        for (ProductCategory productCategory :list1) {
            ProductVoCategory p = new ProductVoCategory();
            p.setId(productCategory.getId());
            p.setName(productCategory.getName());
            p.setBannerImg("banner"+i+".png");
            p.setTopImg("top"+i+".png");
            i++;
            QueryWrapper wrapper1  = new QueryWrapper();
            wrapper1.eq("parent_id",productCategory.getId());
            wrapper1.eq("type",2);
            List<ProductCategory> list2 = mapper.selectList(wrapper1);
//            创建二级Vo
            List<ProductVoCategory> volist2 = new ArrayList<>();

            for (ProductCategory productCategory2 : list2) {
                ProductVoCategory p2 = new ProductVoCategory();
                p2.setId(productCategory2.getId());
                p2.setName(productCategory2.getName());
//                创建三级Vo
                List<ProductVoCategory> volist3 = new ArrayList<>();

                QueryWrapper wrapper2  = new QueryWrapper();
                wrapper2.eq("parent_id",productCategory2.getId());
                wrapper2.eq("type",3);
                List<ProductCategory> list3 = mapper.selectList(wrapper2);
                for (ProductCategory productCategory3 : list3) {
                    ProductVoCategory p3 = new ProductVoCategory();
                    p3.setId(productCategory3.getId());
                    p3.setName(productCategory3.getName());
                    volist3.add(p3);
                }
                p2.setChild(volist3);
                volist2.add(p2);
            }
            p.setChild(volist2);
            p.setProducts(productService.findByLevle(1,productCategory.getId()));
            volist1.add(p);
        }
        return volist1;
    }
}
