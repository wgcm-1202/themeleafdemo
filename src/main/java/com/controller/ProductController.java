package com.controller;

import com.dao.ProductDao;
import com.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author yyh
 * @date 2019/8/15-9:14
 */
@Controller
public class ProductController {


    @RequestMapping("/")
    public String index(Model model) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Product product = new Product("花生油", 129, sdf.parse("2019-08-15"), "");
        model.addAttribute("product", product);
        return "index";
    }

    @RequestMapping("/escape")
    public String escape(Model model){
        String html="Welcome to our <b>fantastic</b> grocery store!";
        model.addAttribute("html",html);
        return "escaped";
    }


    @RequestMapping("/list")
    public String productlists(Model model){
        List<Product> products = ProductDao.loadAllProducts();
        model.addAttribute("productList", products);
        return "list";
    }
}
