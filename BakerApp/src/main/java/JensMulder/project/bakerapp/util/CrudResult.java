package JensMulder.project.bakerapp.util;

import JensMulder.project.bakerapp.core.contracts.IDbModel;

public final class CrudResult<T extends IDbModel> {
    private final String message;
    private final T result;

    public CrudResult(String message, T result) {
        this.result = result;
        this.message = message == null ? "Request is succesful" : message;
    }

    public String getMessage() {
        return message;
    }

    public T getResult() {
        return result;
    }
}
