import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/*
 * Implemnetazione della Factory.
 * Nel metodo create si nasconde il codiece visto prima nel main e creando un Proxy a partire dallo handler.
 */

public class MathLoggerFactory implements MathFactory {

	public Math create() {
		InvocationHandler ih = new MathLoggerHandler(new MathImpl());
		return (Math)Proxy.newProxyInstance(ProxyMathTester.class.getClassLoader(), new Class[] {Math.class}, ih);
	}

}
