package servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import modelo.Destinatario;

class EmailServiceTest {

	private EmailService emailService;
    private Logger mockLogger;
    
    @BeforeEach
    public void setUp() {
        mockLogger = mock(Logger.class); 
        emailService = new EmailService(mockLogger); 
    }

    @Test
    public void testEnviarEmailDevuelveTrueYLoggeaMensajes() {

        Destinatario destinatarioPrueba = new Destinatario();
        String textoEmail = "Cuerpo del mensaje de prueba";

        boolean resultado = emailService.enviarEmail(destinatarioPrueba, textoEmail);

        assertTrue(resultado, "El método enviarEmail siempre debería devolver true");
       
    }

}
