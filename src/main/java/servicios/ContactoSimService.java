package servicios;
import interfaces.InterfazContactoSim;
import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class ContactoSimService implements InterfazContactoSim{
	
	private Map<Integer, DatosSolicitud> s=new HashMap<>();
	private SecureRandom r = new SecureRandom();
	
	
	@Override
	public int solicitarSimulation(DatosSolicitud sol) {
		int tok=r.nextInt(1000000);
		s.put(tok, sol);
		
		return tok;
	}

	@Override
	public DatosSimulation descargarDatos(int ticket) {
		
		//si contiene la clave, creamos una simulaciín de datos
		if(s.containsKey(ticket)) {
			return new DatosSimulation();
		}
		
		return null;
	}

	@Override
	public List<Entidad> getEntities() {
		
		List<Entidad> lista = new ArrayList<>();
        
        Entidad e1 = new Entidad();
        e1.setName("Entidad1");
        
        Entidad e2 = new Entidad();
        e2.setName("Entidad2");
        
        lista.add(e1);
        lista.add(e2);
        return lista;
	}

	@Override
	public boolean isValidEntityId() {
		return true;
	}

}
