package Model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private String pName;
    @Column(length = 2000)
    private String pDesc;
    private String pPrice;
    private String pDiscount;
    private String pPic;
    private String pQunatity;
    @ManyToOne
private Category category;

    public Product() {
    }

    public Product(String pName, String pDesc, String pPrice, String pDiscount, String pPic, String pQunatity, Category category) {
        this.pName = pName;
        this.pDesc = pDesc;
        this.pPrice = pPrice;
        this.pDiscount = pDiscount;
        this.pPic = pPic;
        this.pQunatity = pQunatity;
        this.category = category;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getpDiscount() {
        return pDiscount;
    }

    public void setpDiscount(String pDiscount) {
        this.pDiscount = pDiscount;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public String getpQunatity() {
        return pQunatity;
    }

    public void setpQunatity(String pQunatity) {
        this.pQunatity = pQunatity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
