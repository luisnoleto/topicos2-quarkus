package br.unitins.topicos1;

import br.unitins.topicos1.dto.telefone.TelefoneDTO;
import br.unitins.topicos1.dto.usuario.UpdateEmailDTO;
import br.unitins.topicos1.dto.usuario.UpdateNomeDTO;
import br.unitins.topicos1.dto.usuario.UpdateSenhaDTO;
import br.unitins.topicos1.dto.usuario.UpdateTelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class UsuarioLogadoResourceTest {

    @Test
    public void testGetUsuario() {
        given()
            .auth().basic("joao123", "123")
        .when()
            .get("/usuariologado/meusdados")
        .then()
            .statusCode(200)
            .body("nome", equalTo("Joao Silva"))
            .body("login", equalTo("joao123"))
            .body("email", equalTo("joao@email.com"));
    }

    @Test
    public void testUpdateSenha() {
        given()
            .auth().basic("joao123", "123")
            .contentType(ContentType.JSON)
            .body(new UpdateSenhaDTO("123", "321"))
        .when()
            .patch("/usuariologado/alterar/senha")
        .then()
            .statusCode(201)
            .body("nome", equalTo("Joao Silva"))
            .body("login", equalTo("joao123"))
            .body("email", equalTo("joao@email.com"));
    }

    @Test
    public void testUpdateNome() {
        given()
            .auth().basic("joao123", "123")
            .contentType(ContentType.JSON)
            .body(new UpdateNomeDTO("123", "joao321"))
        .when()
            .patch("/usuariologado/alterar/nome")
        .then()
            .statusCode(201)
            .body("nome", equalTo("joao321"))
            .body("login", equalTo("joao123"))
            .body("email", equalTo("joao@email.com"));
    }

    @Test
    public void testUpdateEmail() {
        given()
            .auth().basic("joao123", "123")
            .contentType(ContentType.JSON)
            .body(new UpdateEmailDTO("123", "joao@unitins.br"))
        .when()
            .patch("/usuariologado/alterar/email")
        .then()
            .statusCode(201)
            .body("nome", equalTo("Joao Silva"))
            .body("login", equalTo("joao123"))
            .body("email", equalTo("joao@email.com"));
    }

    @Test
    public void testUpdateTelefone() {
        TelefoneDTO telefone1 = new TelefoneDTO("12", "3456789");
        TelefoneDTO telefone2 = new TelefoneDTO("98", "7654321");

        UpdateTelefoneDTO dto = new UpdateTelefoneDTO("123", Arrays.asList(telefone1, telefone2));
    
        given()
            .auth().basic("joao123", "123")
            .contentType(ContentType.JSON)
            .body(dto)
        .when()
            .patch("/usuariologado/alterar/telefone")
        .then()
            .statusCode(201)
            .body("nome", equalTo("Joao Silva"))
            .body("login", equalTo("joao123"))
            .body("email", equalTo("joao@email.com"));
    }

    @Test
    public void testSalvarImagem() {
        byte[] imagemBytes = "conteudo_da_imagem".getBytes();

        given()
            .auth().basic("joao123", "123")
            .multiPart("nomeImagem", "nomeDaImagem.jpg")
            .multiPart("imagem", "nomeDaImagem.jpg", imagemBytes)
        .when()
            .patch("/usuariologado/upload/imagem")
        .then()
            .statusCode(200)
            .body("login", equalTo("joao123"));
    }

    @Test
    public void testDownload() {
        given()
            .auth().basic("joao123", "123")
        .when()
            .get("/usuariologado/download/imagem/nomeDaImagem.jpg")
        .then()
            .statusCode(200);
    }
}
