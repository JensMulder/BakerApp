package JensMulder.project.bakerapp.util;

public class ValidationError {
    private final String field;
    private final String description;

    public ValidationError(String field, String description) {
        this.field = field;
        this.description = description;
    }

    public String getField() {
        return field;
    }

    public String getProblem() {
        return description;
    }
}
