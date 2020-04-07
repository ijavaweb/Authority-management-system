package fun.iweb.domain;

import fun.iweb.utils.DateUtils;

import java.util.Date;

/*产品的实体类*/
    public class Product {
        private Integer id;
        private String productNumber;
        private String productName;
        private String city;
        private Date depatureTime;
        private String depatureTimeStr;
        private double productPrice;
        private String productDesc;
        private Integer productStatus;
        private String productStatusStr;

        public int getId() {
        return id;
        }

        public void setId(int id) {
        this.id = id;
        }

        public String getProductNumber() {
            return productNumber;
        }

        public void setProductNumber(String productNumber) {
            this.productNumber = productNumber;
        }

        public String getProductName() {
            return productName;
     }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Date getDepatureTime() {
            return depatureTime;
        }

        public void setDepatureTime(Date depatureTime) {
            this.depatureTime = depatureTime;
        }

        public String getDepatureTimeStr() {
            if(depatureTime != null){
                depatureTimeStr = DateUtils.DateToString(depatureTime,"yyyy-MM-dd HH:MM:ss");
            }
            return depatureTimeStr;
        }

        public void setDepatureTimeStr(String depatureTimeStr) {
            this.depatureTimeStr = depatureTimeStr;
        }

        public double getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(double productPrice) {
            this.productPrice = productPrice;
        }

        public String getProductDesc() {
            return productDesc;
        }

        public void setProductDesc(String productDesc) {
            this.productDesc = productDesc;
        }

        public Integer getProductStatus() {
            return productStatus;
        }

        public void setProductStatus(Integer productStatus) {
            this.productStatus = productStatus;
        }

        public String getProductStatusStr() {
            if(productStatus!=null){
                if(productStatus==0){
                    productStatusStr="关闭";
                }
                if(productStatus==1){
                    productStatusStr="开启";
                }
            }
            return productStatusStr;
        }

        public void setProductStatusStr(String productStatusStr) {
            this.productStatusStr = productStatusStr;
        }
}


