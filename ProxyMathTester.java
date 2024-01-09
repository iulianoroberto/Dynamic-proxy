import java.lang.reflect.*;

public class ProxyMathTester {

	public static void main(String[] args) {
		// Viene creata un'istanza dello handler passandogli il RealSubject su cui l'handler dovrà operare
		InvocationHandler ih = new MathLoggerHandler(new MathImpl());
		// Viene creato il Proxy dell'interfaccia Math con il comportamneto dello handeler ih, il primo parametro recupera il class loader di default
		Math m = (Math)Proxy.newProxyInstance(ProxyMathTester.class.getClassLoader(), new Class[] {Math.class}, ih);
		// m è di tipo Subject che referenzia il Proxy
		System.out.println(m.add(3, 5));
		
		// Questo frammento è identico al precedente ma impiega la factory invece dell'esplicitazione del Proxy.
		// Questo va fatto una volta
		// Sostituendo la factory si può cambiare il comportamento dell'applicazione
		MathFactory mf = new MathLoggerFactory();

		// Posso usare mf quante volte voglio, è come se usassi l'operatore new
		Math ml = mf.create();
		System.out.println(ml.add(5, 6));
	}

}
