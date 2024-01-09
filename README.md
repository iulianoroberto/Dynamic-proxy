# Dynamic-proxy
Dynamic proxy in Java.

By using dynamic Java proxies, instantiate proxies of the Math abstract type. The proxies should log the call on the standard output and propagate it to the Subject (MathImpl) in order to implement the requested operation. Hide the details of the creation of the proxy in a factory of Math (MathLoggerFactory), which depending on the constructor parameter is able to create instances of MathImpl or of the proxy to assign to variables of type Math. Assume one or more of the following methods for Math:
double add(float a, float b);
double sub(float a, float b);
double mul(float a, float b);
double div(float a, float b);
