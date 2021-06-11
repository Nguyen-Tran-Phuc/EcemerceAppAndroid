package hcmute.edu.vn.id18110339.DTO;

public class OrderDTO {
    int OderId;
    int Status;
    int UserId;
    int ProductId;
    int Quantity;
    int ProductImage;
    int Cost;

    public OrderDTO() {
    }

    public OrderDTO(int status, int userId, int productId, int quantity, int productImage, int cost) {
        Status = status;
        UserId = userId;
        ProductId = productId;
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

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
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
