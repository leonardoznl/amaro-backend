package br.com.amarobackend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public abstract class AbstractControllerTest<T> {

    @Autowired
    protected MockMvc mockMvc;

    protected MockHttpServletResponse response;

    protected void thenExpectOkStatus() {
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    protected void thenExpectCreatedStatus() {
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    protected void thenExpectAcceptedStatus() {
        assertEquals(HttpStatus.ACCEPTED.value(), response.getStatus());

    }

    protected void thenExpectNoContentStatus() {
        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());

    }

    protected void thenExpectUnprocessableEntityStatus() {
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), response.getStatus());
    }

    protected void thenExpectNotFoundStatus() {
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }

    protected void thenExpectBadRequestStatus() {
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    protected void thenExpectResponseBodyIsNotNull() {
        assertNotNull(response);
    }
}
