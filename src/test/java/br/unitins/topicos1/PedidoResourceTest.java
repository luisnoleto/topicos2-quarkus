// package br.unitins.topicos1;

// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.http.ContentType;
// import org.junit.jupiter.api.Test;

// import br.unitins.topicos1.dto.endereco.EnderecoDTO;
// import br.unitins.topicos1.dto.pedido.PedidoDTO;
// import br.unitins.topicos1.model.StatusPedido;

// import java.time.LocalDate;
// import java.util.List;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.Matchers.equalTo;

// @QuarkusTest
// public class PedidoResourceTest {

//     @Test
//     public void testInsertPedido() {
//         PedidoDTO pedidoDTO = new PedidoDTO(
//                 1L,
//                 1L,
//                 List.of(
//                         new EnderecoDTO("77000000", "Quadra 107 Norte", "1", "Apartamento", "Plano Diretor Norte"),
//                         new EnderecoDTO("77999999", "Quadra 107 Sul", "2", "Apartamento", "Plano Diretor Sul")
//                 ),
//                 LocalDate.now(),
//                 StatusPedido.PROCESSANDO
//         );

//         given()
//             .contentType(ContentType.JSON)
//             .body(pedidoDTO)
//         .when()
//             .post("/pedidos")
//         .then()
//             .statusCode(201)
//             .body("statusPedido", equalTo("PROCESSANDO"));
//     }

//     @Test
//     public void testUpdatePedido() {
//         PedidoDTO pedidoDTO = new PedidoDTO(
//                 1L,
//                 1L,
//                 List.of(
//                         new EnderecoDTO("77000000", "Quadra 107 Norte", "1", "Apartamento", "Plano Diretor Norte"),
//                         new EnderecoDTO("77999999", "Quadra 107 Sul", "2", "Apartamento", "Plano Diretor Sul")
//                 ),
//                 LocalDate.now(),
//                 StatusPedido.PROCESSANDO
//         );

//         // Inserir um pedido para obter um ID para o teste de atualização
//         Long idPedido = given()
//             .contentType(ContentType.JSON)
//             .body(pedidoDTO)
//         .when()
//             .post("/pedidos")
//             .then()
//             .statusCode(201)
//             .extract().jsonPath().getLong("id");

//         // Atualizar o pedido
//         given()
//             .contentType(ContentType.JSON)
//             .body(pedidoDTO)
//         .when()
//             .put("/pedidos/{id}", idPedido)
//         .then()
//             .statusCode(200)
//             .body("statusPedido", equalTo("PROCESSANDO"));
//     }

//     @Test
//     public void testDeletePedido() {
//         given()
//         .when()
//             .delete("/pedidos/1")
//         .then()
//             .statusCode(204);
//     }

//     @Test
//     public void testFindAllPedidos() {
//         given()
//         .when()
//             .get("/pedidos")
//         .then()
//             .statusCode(200);    
//         }

//     @Test
//     public void testFindByIdPedido() {
//         given()
//         .when()
//             .get("/pedidos/1")
//         .then()
//             .statusCode(200);
//     }
// }