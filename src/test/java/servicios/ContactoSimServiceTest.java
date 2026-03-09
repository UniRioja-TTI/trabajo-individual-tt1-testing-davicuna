package servicios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;
class ContactoSimServiceTest {
	
	private ContactoSimService css;
	@BeforeEach
    public void setUp() {
       
        ContactoSimService contactoSimService = new ContactoSimService();
    }

    @Test
    public void testGetEntitiesDevuelveListaCorrecta() {
        
        List<Entidad> entidades = css.getEntities();

        assertNotNull(entidades, "La lista de entidades no debe ser nula");
        assertEquals(2, entidades.size(), "Debería haber exactamente 2 entidades en la lista");
        assertEquals("Entidad1", entidades.get(0).getName(), "El primer nombre debería ser Entidad1");
        assertEquals("Entidad2", entidades.get(1).getName(), "El segundo nombre debería ser Entidad2");
    }

    @Test
    public void testIsValidEntityIdDevuelveTrue() {
        
        assertTrue(css.isValidEntityId(), "El método debe devolver true por defecto");
    }
    @Test
    public void testSolicitarSimulationDevuelveTokenValido() {

        DatosSolicitud solicitud = new DatosSolicitud(null);
        
        int token = css.solicitarSimulation(solicitud);
        assertTrue(token >= 0 && token < 1000000, "El token generado debe estar entre 0 y 999999");
    }

}
