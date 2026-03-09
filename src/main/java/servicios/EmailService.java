package servicios;




import modelo.Destinatario;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import interfaces.InterfazEnviarEmails;


@Service
public class EmailService implements InterfazEnviarEmails {
	private Logger l;
	
	public EmailService(Logger lo) {
		this.l=lo;
	}
	
	@Override
	public boolean enviarEmail(Destinatario dest, String email) {
		
		l.info("Email enviado a : " + dest);
		l.info("email: "+email);
		
		return true;
	}
}
