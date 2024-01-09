import java.lang.reflect.*;

/*
 * Questa è l'interfaccia InvocationHandler che definisce il comportamento del proxy.
 */

public class MathLoggerHandler implements InvocationHandler{

	// Riferimento al RealSubject, pocihé alla fine comunque si va ad invocare un metodo sul RealSubject
	private Object realSubject;
	
	// Costruttore
	public MathLoggerHandler(Object s) {
		realSubject = s;
	}
	
	// Metodo dell'interfaccia InvocationHandler che è invocato dal Proxy
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		// Qui si fa logging, scrivendo sull stdout (logging file)
		System.out.println("Debug: hai invocato il metodo " + m);
		try {
			// Invocazione sul RealSubject (PARTE IMPORTANTE)
			// m è il metodo materializzato
			return m.invoke(realSubject, args);
		} catch (InvocationTargetException e) {
			throw e.getCause();
		}
	}

}
