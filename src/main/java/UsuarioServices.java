import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class UsuarioServices {

    private static Especificacoes request = new Especificacoes();

    public static ValidatableResponse cadastrarUsuario(String name, String job) {
        return given()
                .body("{ \"name\": \"" + name + "\",\n" +
                        "  \"job\": \"" + job + "\"\n" +
                        "}")
                .when()
                .log().all()
                .post("https://reqres.in/api/users")
                .then()
                ;
    }

    public static ValidatableResponse consultarUsuario(Integer id) {
        return given()
                .contentType(ContentType.JSON)
                .param("id", id)
                .when()
                .get("https://reqres.in/api/users")
                .then();
    }

    public static ValidatableResponse consultarUsuarios() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then();
    }

    public static ValidatableResponse alterarUsuario(String name, String job, Integer id) {
        return given()
                .pathParam("id", id)
                .body("{ \"name\": \"" + name + "\",\n" +
                        "  \"job\": \"" + job + "\"\n" +
                        "}")
                .when()
                .put("https://reqres.in/api/users/{id}")
                .then()
                ;
    }

}
