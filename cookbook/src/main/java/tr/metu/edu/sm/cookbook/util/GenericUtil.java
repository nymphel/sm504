package tr.metu.edu.sm.cookbook.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GenericUtil {

	public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
		Set<T> keys = new HashSet<T>();
		for (Entry<T, E> entry : map.entrySet()) {
			if (value.equals(entry.getValue())) {
				keys.add(entry.getKey());
			}
		}
		return keys;
	}

	public static String encode(String str) {
		
		String decoded = null;
		if (str != null) {
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			md.update(str.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}

			decoded = sb.toString();
		}

		return decoded;
	}

}
