package br.unitins.topicos1;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.jogo.JogoDTO;
import br.unitins.topicos1.dto.jogo.JogoResponseDTO;
import br.unitins.topicos1.service.JogoService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class JogoResourceTest {

    @Inject
    JogoService service;

    @Test
    public void getAllTest() {
        given().when().get("/jogos").then().statusCode(200);
    }

    @Test
    public void testInsert() {
        JogoDTO dto = new JogoDTO("Super Mario", "Um jogo de plataforma", 59.99, 4, 1);
        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .post("/jogos")
            .then()
            .statusCode(201)
            .body(
                "id", notNullValue(),
                "nome", is("Super Mario"),
                "descricao", is("Um jogo de plataforma"),
                "preco", is(59.99f),
                "estoque", is(4),
                "idGenero", is(1)
            );
    }

    @Test
    public void testUpdate() {
        JogoDTO dto = new JogoDTO("Super Mario", "Um jogo de plataforma", 59.99, 4, 1);

        JogoResponseDTO response = service.insert(dto);
        Long id = response.id();

        dto = new JogoDTO("Super Mario", "Um jogo de plataforma", 69.99, 4, 1);

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
            .put("/jogos/" + id)
            .then()
            .statusCode(200)
            .body(
                "id", is(id.intValue()),
                "nome", is("Nome Atualizado"),
                "descricao", is("Descrição Atualizada"),
                "preco", is(69.99f),
                "estoque", is(4),
                "idGenero", is(1)
            );
    }

    @Test
    public void testDelete() {
        JogoDTO dto = new JogoDTO("Super Mario", "Um jogo de plataforma", 59.99, 4, 1);

        JogoResponseDTO response = service.insert(dto);
        Long id = response.id();

        given()
            .when().delete("/jogos/" + id)
            .then()
            .statusCode(200);
    }

    @Test
    public void testFindAll() {
        given()
            .when()
            .get("/jogos")
            .then()
            .statusCode(200);
    }

    @Test
    public void testFindById() {
        JogoDTO dto = new JogoDTO("Super Mario", "Um jogo de plataforma", 59.99, 4, 1);

        JogoResponseDTO response = service.insert(dto);
        Long id = response.id();

        given()
            .when()
            .get("/jogos/" + id)
            .then()
            .statusCode(200)
            .body(
                "id", is(id.intValue()),
                "nome", is("Super Mario"),
                "descricao", is("Um jogo de plataforma"),
                "preco", is(59.99f),
                "estoque", is(4),
                "idGenero", is(1)
            );
    }

    @Test
    public void testFindByNome() {
        JogoDTO dto = new JogoDTO("Super Mario", "Um jogo de plataforma", 59.99, 4, 1);

        JogoResponseDTO response = service.insert(dto);
        Long id = response.id();

        given()
            .when()
            .get("/jogos/nome/" + "Super Mario")
            .then()
            .statusCode(200)
            .body(
                "id", is(id.intValue()),
                "nome", is("Super Mario"),
                "descricao", is("Um jogo de plataforma"),
                "preco", is(59.99f),
                "estoque", is(4),
                "idGenero", is(1)
            );
    }
}