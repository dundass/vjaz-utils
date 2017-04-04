package reflection;

import java.lang.reflect.*;
import interfaces.TextField;

// a performative console for accessing class fields and methods on the fly via a text box

// decouple buffer functionality by extending the interfaces.TextInput class!

// process: 	determine what each String in s[] represents -> check classes, then methods, then fields, if none then val
//  			(val must be preceded by method or field else quit)
//				get types for val, do they match args/field, else quit
//				invoke method / set field

// fundamental flaw - how to add a method to constantly be called inside another method eg Shape.render() inside draw()??
// solution - have a method in here called 'addToRegular' or sutin, that adds to a list of methods to be called in draw as Strings
// ...then just call console.runRegular() inside the running method eg draw() and reflection covers invoke()

// there is also the problem of how to link pattern gen classes to visual or audio classes...

// also essential to performativity is 'nicknames' k/v JSON lookup, eg {"star": "StarryLines", "log": "Logistic", "clk": "ClockFace"}

public class ClassConsole extends TextField {
	private int num = 0;
	private Class[] typeClasses =  {Integer.class, Float.class, Double.class, String.class};
	
	public ClassConsole() {
		super();
	}
	
	public void execute(Object tar) {
		String[] s = buffer.split(" ");
		
		int methodFieldIdx = 0;	//index for method/field name in s[]
		int argIdx = 1;	//index for (first!!) argument in s[]
		boolean isField = false;
		
		Object o = null;	//new val container
		String type = null;
		String[] types = {"int", "float", "double", "String"};		

		Package[] packs = Package.getPackages();
		String className = tar.getClass().getName();
		if(s.length == 3) {
			methodFieldIdx = 1;
			argIdx = 2;
			
			//className = Class.forName(s[0]).getCanonicalName();
			className = s[0];
			String path = null;
			for(Package p : packs) {
				path = p.getName() + '.' + className;
				try {
					Class.forName(path);
				} catch(ClassNotFoundException e) {
					continue;
				}
				break;
			}
			className = path;
		}
		System.out.println("Class = " + className);
		
		try {
			
			Field field = Class.forName(className).getDeclaredField(s[methodFieldIdx]);
			for(int t = 0; t < types.length; t++) {
				if(field.getType().getName().equals(types[t])) {
					System.out.println("field is of type " + types[t]);
					type = types[t];
					isField = true;
				}
			}
			switch(type) {
			case "int":
				o = Integer.parseInt(s[argIdx]);
				break;
			case "float":
				o = Float.parseFloat(s[argIdx]);
				break;
			case "double":
				o = Double.parseDouble(s[argIdx]);
				break;
			case "String":
				o = s[argIdx];
				break;
			default:
				return;
			}
			field.setAccessible(true);
			if(isField) field.set(tar, o);		//or (this, o)?????
			System.out.println(field.get(tar));
			field.setAccessible(false);
			//clear();
		} catch(ClassNotFoundException e) {
			System.out.println("class not found m8");
		} catch(NoSuchFieldException e) {
			System.out.println("no such field m8");
		} catch(IllegalArgumentException e) {
			System.out.println("can't do that m8");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(!isField) {
			//is it a method?
			
			try {
				Method m = Class.forName(className).getDeclaredMethod(s[methodFieldIdx], Object.class);
				Class<?>[] c = m.getParameterTypes();
				if(c.length != s.length - 2) return;
				//for(all the arguments in s)
				for(int t = 0; t < types.length; t++) {
					if(c[0].getName().equals(types[t])) {
						System.out.println("method parameter is of type " + types[t]);
						type = types[t];
					}
				}
				switch(type) {	//repeated code.......
				case "int":
					o = Integer.parseInt(s[argIdx]);
					break;
				case "float":
					o = Float.parseFloat(s[argIdx]);
					break;
				case "double":
					o = Double.parseDouble(s[argIdx]);
					break;
				case "String":
					o = s[argIdx];
					break;
				default:
					return;
				}
				m.setAccessible(true);
				m.invoke(tar, o);
				m.setAccessible(false);
			} catch(NoSuchMethodException e) {
				System.out.println("no such method m8");
			} catch(IllegalArgumentException e) {
				System.out.println("can't do that m8");
			}  catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getTypeForString(String s) {
		String type = null;
		String[] types = {"int", "float", "double", "String"};
		//placeholders
		int i = 0;
		float f = 0;
		double d = 0;
		String str = "";
		
		return type;
	}
}
