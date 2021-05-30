package JensMulder.project.bakerapp.util;

public class ApiResponse {
    private final Object result;
    private final ApiError error;

    public ApiResponse(Object result, ApiError error) {
        this.result = result;
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public ApiError getError() {
        return error;
    }
}
