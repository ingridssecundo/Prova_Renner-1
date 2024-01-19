import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class Especificacoes {

    ResponseSpecification responseSpec;

    public ResponseSpecification setResponseCreatedSpec() {
        return responseSpec = new ResponseSpecBuilder().expectStatusCode(SC_CREATED).expectContentType("application/Json").build();
    }

    public ResponseSpecification setResponseOkSpec() {
        return responseSpec = new ResponseSpecBuilder().expectStatusCode(SC_OK).expectContentType("application/Json").build();
    }

}
