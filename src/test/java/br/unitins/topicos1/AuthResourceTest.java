// package br.unitins.topicos1;

// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.http.ContentType;
// import org.junit.jupiter.api.Test;

// import br.unitins.topicos1.dto.usuario.LoginDTO;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.isA;

// @QuarkusTest
// public class AuthResourceTest {

//     @Test
//     public void testLoginSuccess() {
//         LoginDTO loginDTO = new LoginDTO("joao123", "123");

//         given()
//             .contentType(ContentType.JSON)
//             .body(loginDTO)
//             .when()
//             .post("/auth")
//             .then()
//             .statusCode(200)
//             .header("Authorization", isA(String.class));
//     }

//     @Test
//     public void testLoginFailure() {
//         LoginDTO loginDTO = new LoginDTO("123joao", "321");

//         given()
//         .contentType(ContentType.JSON)
//         .body(loginDTO)
//         .when()
//         .post("/auth")
//         .then()
//         .statusCode(400);
//     }
// }