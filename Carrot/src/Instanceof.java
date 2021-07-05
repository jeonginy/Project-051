
public class Instanceof {

	public static void main(String[] args) {
	@SuppressWarnings("deprecation")
	Integer i = new Integer(10);
	String s = new String("a");
	
	Object obj = new Integer(10);
	Object obj2 = new String("a");
	
	System.out.println(i.intValue());
	
	System.out.println(((String) obj).isEmpty());		
//					Exception in thread "main" 10
//					java.lang.ClassCastException: class java.lang.Integer cannot be cast to 
//					class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
//					at Instanceof.main(Instanceof.java:13)
	if( obj instanceof String) {
		Integer a = (Integer)obj;
		System.out.println(a.intValue());
	} else if ( obj instanceof String ) {
		String a = (String) obj;
		System.out.println(((String)obj).isEmpty());
	}
	
	}
}
