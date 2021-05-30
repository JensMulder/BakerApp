package JensMulder.project.bakerapp.dto.pie;

public class UpdatePieDto extends PieDto {
    public UpdatePieDto() {}

    public UpdatePieDto(String name, String description, byte[] img, double price, Long id) {
        super(name, description, img, price, id);
    }
}
