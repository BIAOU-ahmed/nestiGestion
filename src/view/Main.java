/**
 * 
 */
package view;

import com.lambdaworks.crypto.SCryptUtil;

/**
 * @author ahmed
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String generatedSecuredPasswordHash = SCryptUtil.scrypt("SUPPERadmin3!", 16, 16, 16);
		System.out.println(generatedSecuredPasswordHash);

	}

}
