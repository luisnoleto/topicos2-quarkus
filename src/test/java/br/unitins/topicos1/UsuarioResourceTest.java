// package br.unitins.topicos1;

// import br.unitins.topicos1.dto.telefone.TelefoneDTO;
// import br.unitins.topicos1.dto.usuario.UsuarioDTO;
// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.http.ContentType;
// import org.junit.jupiter.api.Test;

// import java.util.Arrays;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.Matchers.equalTo;

// @QuarkusTest
// public class UsuarioResourceTest {

//     @Test
//     public void testInsert() {
//         UsuarioDTO dto = new UsuarioDTO("Roberta Maria", "roberta", "123",
//                 "roberta@email.com", "123.456.789-09", Arrays.asList(new TelefoneDTO("63", "987654321")));

//         given()
//             .contentType(ContentType.JSON)
//             .body(dto)
//         .when()
//             .post("/usuarios")
//         .then()
//             .statusCode(201)
//             .body("nome", equalTo("Roberta Maria"))
//             .body("login", equalTo("roberta"))
//             .body("email", equalTo("roberta@email.com"));
//     }

//     @Test
//     public void testUpdate() {
//         UsuarioDTO dto = new UsuarioDTO("Joao Silva", "joao123", "123",
//                 "joao@email.com", "123.456.789-00", Arrays.asList(new TelefoneDTO("62", "888888888")));

//         given()
//             .contentType(ContentType.JSON)
//             .body(dto)
//         .when()
//             .put("/usuarios/1")
//         .then()
//             .statusCode(204);
//     }

//     @Test
//     public void testDelete() {
//         given()
//         .when()
//             .delete("/usuarios/1")
//         .then()
//             .statusCode(204);
//     }

//     @Test
//     public void testFindAll() {
//         given()
//         .when()
//             .get("/usuarios")
//         .then()
//             .statusCode(200);
//     }

//     @Test
//     public void testFindById() {
//         given()
//         .when()
//             .get("/usuarios/1")
//         .then()
//             .statusCode(200);
//     }

//     @Test
//     public void testFindByNome() {
//         given()
//             .pathParam("nome", "Joao Silva")
//         .when()
//             .get("/usuarios/search/nome/{nome}")
//         .then()
//             .statusCode(200);
//     }
// }
