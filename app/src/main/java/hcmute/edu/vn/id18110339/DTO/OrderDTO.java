package hcmute.edu.vn.id18110339.DTO;

public class OrderDTO {
    int OderId;
    int Status;
    int UserId;
    String ProductName;
    int Quantity;
    int ProductImage;
    int Cost;

    public OrderDTO() {
    }

    public OrderDTO(int status, int userId, String productName, int quantity, int productImage, int cost) {
        Status = status;
        UserId = userId;
        ProductName = productName;
        Quantity = quantity;
        ProductImage = productImage;
        Cost = cost;
    }

    public int getOderId() {
        return OderId;
    }

    public void setOderId(int oderId) {
        OderId = oderId;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getProductId() {
        return ProductName;
    }

    public void setProductId(String productName) {
        ProductName = productName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getProductImage() {
        return ProductImage;
    }

    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }
}
