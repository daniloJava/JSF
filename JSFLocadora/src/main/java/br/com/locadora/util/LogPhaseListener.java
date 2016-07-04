package br.com.locadora.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogPhaseListener implements PhaseListener{

	/**Depois de uma fase
	 * 
	 */
	@Override
	public void afterPhase(PhaseEvent arg0) {
		
	}

	/**Antes de uma fase
	 * 
	 */
	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("Fase " + event.getPhaseId() );
	}

	/**Qual fase
	 * 
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	
	
}
