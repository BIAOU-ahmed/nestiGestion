package tools;

import java.util.HashMap;
import java.util.Map;

public class AppSettings {
private static Map<String,String> settings= new HashMap<>();

	public static void set(String key,String value) {
		settings.put(key, value);
	}
	
	public static String get(String key) {
		return settings.get(key);
		
	}
	
}
