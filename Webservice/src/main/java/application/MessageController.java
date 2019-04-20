package application;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.exceptions.MessageNotFoundException;
import rest.dto.CallbackForMessageInjest;
import rest.dto.CallbackForMessageRetrieval;
import util.caching.CachedHashes;

@RestController
public class MessageController {

	@GetMapping("/messages/{hash}")
	public CallbackForMessageRetrieval checkForExisitingHash(@PathVariable String hash) throws MessageNotFoundException {
		String message = CachedHashes.getInstance().getHash(hash);
		if (message == null) {
			throw new MessageNotFoundException();
		}
		return new CallbackForMessageRetrieval(message);
	}

	@PostMapping("/messages")
	public CallbackForMessageInjest greeting(@RequestParam(value = "message") String name)
			throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] messageSHA = md.digest(name.getBytes());

		BigInteger no = new BigInteger(1, messageSHA);

		String hashtext = no.toString(16);

		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		CachedHashes.getInstance().addToHashes(hashtext, name);
		return new CallbackForMessageInjest(hashtext);
	}
}