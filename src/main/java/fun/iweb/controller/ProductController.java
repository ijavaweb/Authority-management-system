package fun.iweb.controller;

import fun.iweb.domain.Product;
import fun.iweb.service.IProductService;
import fun.iweb.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList",products);
//        指定视图的 名字
        mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping("/add")
    public String add(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll";
    }
}
