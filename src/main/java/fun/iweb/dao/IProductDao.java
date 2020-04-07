package fun.iweb.dao;

import fun.iweb.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductDao {
//    查询产品的所有信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
//插入产品的信息
    @Insert("insert into product(productnumber,productname,depaturetime,productprice,productdesc,productstatus,city)" +
            " values(#{productNumber},#{productName},#{depatureTime},#{productPrice},#{productDesc},#{productStatus},#{city})")
    public void save(Product product) throws Exception;

    @Select("select * from product where id=#{id}")
    public Product findById(@Param("id") Integer id) throws Exception;
}
