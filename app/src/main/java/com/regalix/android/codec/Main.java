package com.regalix.android.codec;

public class Main {

	/*public static void main(String[] args) {
		String data = "f~m`r.~nq`v~n/~`n`qvn~/`lf~ex`w~_qx`v~`uq~e`r/~ax`i~.ww`hzw~w`rv~xc`z~h~`ux`q.b~b`b~`/~/:`m~ccg`";
		Decoder decoder = new Decoder();
		Encoder encoder = new Encoder();
		String encodedData = encoder.encode(data);
		String decodedData = decoder.decode(data);
		System.out.println(data);
		System.out.println(decodedData);
		String phoneNo = "+11119856176986";
		String sss = getPhoneNoWithoutCountryCode(phoneNo);
		System.out.println(phoneNo);
		System.out.println(sss);

	}*/


	static public String getPhoneNoWithoutCountryCode(String phone) {

		int USA = 1;
		int BAHRAIN = 973;
		int PAKISTAN = 92;
		int SRILANKA = 94;
		int CHINA = 86;
		int NEPAL = 977;
		int SAUDI = 966;
		int SOUTH_AFRICA = 27;

		if (phone.startsWith("+")) {
			phone = phone.replace("+", "").trim();
		}
		if (phone.startsWith(USA + "")) {
			return phone = phone.replaceFirst(USA + "", "").trim();

		} else if (phone.startsWith(BAHRAIN + "")) {
			return phone = phone.replaceFirst(BAHRAIN + "", "").trim();

		}

		else if (phone.startsWith(SAUDI + "")) {
			return phone = phone.replaceFirst(SAUDI + "", "").trim();

		}

		else if (phone.startsWith(PAKISTAN + "")) {
			return phone = phone.replaceFirst(PAKISTAN + "", "").trim();

		} else if (phone.startsWith(SRILANKA + "")) {
			return phone = phone.replaceFirst(SRILANKA + "", "").trim();

		} else if (phone.startsWith(CHINA + "")) {
			return phone = phone.replaceFirst(CHINA + "", "").trim();

		}

		else if (phone.startsWith(NEPAL + "")) {
			return phone = phone.replaceFirst(NEPAL + "", "").trim();

		}
		else if (phone.startsWith(SOUTH_AFRICA + "")) {
			return phone = phone.replaceFirst(SOUTH_AFRICA + "", "").trim();

		}

		else {
			String phoneNo;
			if (phone.contains("+")) {
				phone = phone.replace("+", "");
				StringBuilder reversePhoneNo = new StringBuilder(phone)
						.reverse();
				String phnWCId = reversePhoneNo.substring(0, 10);
				String original = new StringBuilder(phnWCId).reverse()
						.toString();
				return phoneNo = original;

			} else {
				StringBuilder reversePhoneNo = new StringBuilder(phone)
						.reverse();
				String phnWCId = reversePhoneNo.substring(0, 10);
				String original = new StringBuilder(phnWCId).reverse()
						.toString();
				phoneNo = original;
			}
			return phoneNo;
		}

	}
}
