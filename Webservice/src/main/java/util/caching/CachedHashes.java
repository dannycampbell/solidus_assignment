package util.caching;

import java.util.HashMap;

public class CachedHashes {

	private static HashMap<String, String> hashes;
	private static CachedHashes ch = new CachedHashes();

	private CachedHashes() {
		hashes = new HashMap<String, String>();
	}

	public static CachedHashes getInstance() {
		if (ch == null) {
			ch = new CachedHashes();
		}
		return ch;
	}

	public void addToHashes(String key, String value) {
		hashes.put(key, value);
	}

	public String getHash(String key) {
		return hashes.get(key) == null ? null : hashes.get(key);
	}
}
