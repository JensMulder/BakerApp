package JensMulder.project.bakerapp.dto.pie;

import JensMulder.project.bakerapp.dto.pie.base.PieDtoBase;

public class PieDto extends PieDtoBase {
    private Long id;

    public PieDto() {}

    public PieDto(String name, String description, byte[] img, double price, Long id) {
        super(name, description, img, price);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
