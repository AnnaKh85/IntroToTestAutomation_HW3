import io.restassured.http.Method;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class accuweathertest {
    String baseUrl = "http://dataservice.accuweather.com";
    String apiKey = "pM8OATxNHIhGF4snEoAsFLoHORN4U2VJ";
    @Test
    void getRegionList() {
        given()
                .param("apikey", apiKey)
                .when().get(baseUrl+ "/locations/v1/regions")
                .then().assertThat().statusCode(200);
        given().log().body();

        given()
                .param("apikey", apiKey)
                .when()
                .request(Method.GET,  baseUrl+ "/locations/v1/regions")
                .then()
                .assertThat().statusCode(200);
    }
    @Test
    void checkRegionListHasArctica() {
        given()
                .param("apikey", apiKey)
                .when().get(baseUrl+ "/locations/v1/regions")
                .then()
                .assertThat()
                .body("[0].LocalizedName", equalTo("Africa"));
    }

    @Test
    void checkContentTypeIsJson() {
        given()
                .param("apikey", apiKey)
                .when().get(baseUrl+ "/locations/v1/regions")
                .then()
                .assertThat()
                .contentType(equalTo("application/json; charset=utf-8"));
        given().log().body();

        given()
                .param("apikey", apiKey)
                .when()
                .request(Method.GET,  baseUrl+ "/locations/v1/regions")
                .then()
                .assertThat().contentType(equalTo("application/json; charset=utf-8"));
        given().log().body();

        given()
                .param("apikey", apiKey)
                .when().get(baseUrl+ "/locations/v1/regions")
                .then()
                .assertThat()
                .contentType(Matchers.containsString("json"));
        given().log().body();

        given()
                .param("apikey", apiKey)
                .when()
                .request(Method.GET,  baseUrl+ "/locations/v1/regions")
                .then()
                .assertThat().contentType(Matchers.containsString("json"));
    }

    @Test
    void logBody() {
        given()
                .param("apikey", apiKey)
                .when().get(baseUrl+ "/locations/v1/regions")
                .then().log().body();

        given()
                .param("apikey", apiKey)
                .when()
                .request(Method.GET,  baseUrl+ "/locations/v1/regions")
                .then().log().body();

        given()
                .param("apikey", apiKey)
                .when().get(baseUrl+ "/locations/v1/regions")
                .then().log().body(true);

        given()
                .param("apikey", apiKey)
                .when()
                .request(Method.GET,  baseUrl+ "/locations/v1/regions")
                .then().log().body(true);

        given()
                .param("apikey", apiKey)
                .when().get(baseUrl+ "/locations/v1/regions")
                .then().log().all();

        given()
                .param("apikey", apiKey)
                .when()
                .request(Method.GET,  baseUrl+ "/locations/v1/regions");
    }
}
