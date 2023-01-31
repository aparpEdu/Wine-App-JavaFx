package enums;

import java.util.HashMap;
import java.util.Map;

public enum BottleSize {
	 TINY(187),
	 SMALL(200),
	 MEDIUM(350),
	 LARGE(750);

	    private int value;
	    private static Map<Object, Object> map = new HashMap<>();

	    private BottleSize(int value) {
	        this.value = value;
	    }

	    static {
	        for (BottleSize pageType : BottleSize.values()) {
	            map.put(pageType.value, pageType);
	        }
	    }

	    public static BottleSize valueOf(int BottleSize) {
	        return (BottleSize) map.get(BottleSize);
	    }

	    public int getValue() {
	        return value;
	    }
	    public String getSize() {
	    	return " (" + value + "ml)";
	    }
}
