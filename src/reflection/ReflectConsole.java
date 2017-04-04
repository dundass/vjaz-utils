package reflection;

import interfaces.TextField;
import java.lang.reflect.*;
import java.util.ArrayList;

// order: parse -> sort by keyword -> set()/invoke()

public class ReflectConsole extends TextField {
	Object parent = null;
	String parentType;
	//String[] running;	
	ArrayList<String> running = new ArrayList<String>();	//to store the queued methods -> how to access from main program? write a generic method in here to execute named methods to be shared by getRunning() and execute()?
	
	public ReflectConsole(Object parent) {
		super();
		this.parent = parent;
		parentType = parent.getClass().getName();
	}
	
	public void execute() {
		//move this preprocessing to parse()?
		String[] _in = buffer.split(" ");
		String keyword = null;
		if(_in[0].equals("add") || _in[0].equals("kill")) keyword = _in[0];
		String[] in = new String[_in.length - 1];
		for(int i = 0; i < in.length; i++) in[i] = _in[i + 1];
		String[] tokens = identify(in);
		
		if(tokens[1].equals("Field")) {
			try {
				Field pf = Class.forName(parentType).getDeclaredField(in[0]);
				//Field f = Class.forName(tokens[0]).getDeclaredField(in[1]);
				Field[] fields = Class.forName(tokens[0]).getDeclaredFields();
				for(Field f : fields) {
					if(f.getName().equals(in[0])) {
						
					}
				}
				//f.setAccessible(true);
				//f.set(parent, value);
				//f.setAccessible(false);
			} catch (NoSuchFieldException | SecurityException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else if(tokens[1].equals("Method")) {
			if(keyword.equals("add")) add(in);
			else if(keyword.equals("kill")) kill(in);
			//else continue and execute method now ?
		}
		
	}
	
	public void add(String[] in) {
		//add to running
	}
	//	 ^ \/ will have similar code......
	public void kill(String[] in) {
		//remove from running
	}
	
	public String[] identify(String[] in) {
		if(in.length < 3) ;	//error -> ???
		
		String[] o = new String[in.length];
		//is Method / Field? -> cycle thru all classes + check their method + field names against in[], preferably in 1 loop
		//save to o[] as String, eg {"Circle", "Field", "int"} for input {"cir", "size", "1000"}
		String type = null;
		String[] types = {"int", "float", "double", "boolean", "String"};		
		
		//what type is the object at pos in[0]?
		try {
			Field[] objectsOnParent = Class.forName(parentType).getDeclaredFields();
			for(Field f : objectsOnParent) {
				if(f.getName() == in[0]) {
					o[0] = f.getType().getName();
				}
			}
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//is in[1] a Method or Field?
		try {
			Field[] fields = Class.forName(o[0]).getDeclaredFields();
			Method[] methods = Class.forName(o[0]).getDeclaredMethods();
			for(Field f : fields) if(f.getName() == in[1]) o[1] = f.getClass().getName();	//check that f.getClass().getName() returns "Field"
			for(Method m : methods) if(m.getName() == in[1]) o[1] = m.getClass().getName();	//also with this one
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(o[1] == null) ;	//error -> ???
		
		//what type is the final arg? (if method) are there more than 1, and what types are they all?
		if(o[1].equals("Field")) {
			try {
				String fieldType = Class.forName(o[0]).getDeclaredField(in[1]).getType().getName();
				//if()
			} catch (NoSuchFieldException | SecurityException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		else if(o[1].equals("Method")) {
			for(int i = 2; i < in.length; i++) {
				o[i] = tryToGetType(in[i]);
			}
		}
		
		return o;
	}
	
	public static String tryToGetType(String s) {
		if(s.contains(".")) {
			//defaults to float; must specify "0.1d" to force double
			if(s.contains("d")) return "double";
			else return "float";
		}
		try {
			Integer.parseInt(s);
			return "int";
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			Boolean.parseBoolean(s);
			return "boolean";
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public void addNicknames() {
		//add a list of [nickname, classname] pairs, for quicker shorthand lookup
		//or, is this even necessary? since Field.get receives object name as input, can you get the reference to an existing object?
		//		-> & use short object names eg "pxd" for PixelDirectionalGrowth
		//		-> will probs only work if objects are (global) fields
	}
}
