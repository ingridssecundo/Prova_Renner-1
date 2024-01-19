import com.github.javafaker.Faker;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

public class UserTests {

    Faker faker = new Faker();
    String name = faker.name().firstName();
    String job = faker.job().title();

    protected Especificacoes response = new Especificacoes();

    @Test
    public void cadastrarUserTest(){
        ResponseSpecification rs = response.setResponseCreatedSpec();
        UsuarioServices.cadastrarUsuario(name, job)
                .spec(rs)
        ;
    }

    @Test
    public void consultarSingleUserTest() {
        ResponseSpecification rs = response.setResponseOkSpec();
        UsuarioServices.consultarUsuario(2)
                .spec(rs)
                .log().all()
        ;
    }

    @Test
    public void consultarListUsersTest() {
        ResponseSpecification rs = response.setResponseOkSpec();
        UsuarioServices.consultarUsuarios()
                .spec(rs)
        ;
    }

    @Test
    public void alterarUserTest() {
        ResponseSpecification rs = response.setResponseOkSpec();
        UsuarioServices.alterarUsuario(name, job,2)
                .spec(rs)
                .log().all()
        ;
    }
}
