package JensMulder.project.bakerapp.dto.pie.base;

public class PieDtoBase {
    private String name;
    private String description;
    private byte[] img;
    private double price;

    public PieDtoBase() {}

    public PieDtoBase(String name, String description, byte[] img, double price) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
