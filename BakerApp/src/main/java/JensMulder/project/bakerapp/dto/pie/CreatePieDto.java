package JensMulder.project.bakerapp.dto.pie;

import JensMulder.project.bakerapp.dto.pie.base.PieDtoBase;

public class CreatePieDto extends PieDtoBase {
    public CreatePieDto() {}

    public CreatePieDto(String name, String description, byte[] img, double price) {
        super(name, description, img, price);
    }
}
