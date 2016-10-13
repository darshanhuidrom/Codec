package com.regalix.android.codec;

public class Decoder {

	public static final String CODE_ID="dpt78541";
	private static final int CONSTANT = 32;
	private static final char R = 'A';
	private static final char I = 'B';
	private static final char Z = 'C';
	private static final char Q = 'D';
	private static final char H = 'E';
	private static final char Y = 'F';
	private static final char P = 'G';
	private static final char G = 'H';
	private static final char X = 'I';
	private static final char O = 'J';
	private static final char F = 'K';
	private static final char W = 'L';
	private static final char N = 'M';
	private static final char E = 'N';
	private static final char V = 'O';
	private static final char M = 'P';
	private static final char D = 'Q';
	private static final char U = 'R';
	private static final char L = 'S';
	private static final char C = 'T';
	private static final char T = 'U';
	private static final char K = 'V';
	private static final char B = 'W';
	private static final char S = 'X';
	private static final char J = 'Y';
	private static final char A = 'Z';
	
	
	private static final char r = 'a';
	private static final char i = 'b';
	private static final char z = 'c';
	private static final char q = 'd';
	private static final char h = 'e';
	private static final char y = 'f';
	private static final char p = 'g';
	private static final char g = 'h';
	private static final char x = 'i';
	private static final char o = 'j';
	private static final char f = 'k';
	private static final char w = 'l';
	private static final char n = 'm';
	private static final char e = 'n';
	private static final char v = 'o';
	private static final char m = 'p';
	private static final char d = 'q';
	private static final char u = 'r';
	private static final char l = 's';
	private static final char c = 't';
	private static final char t = 'u';
	private static final char k = 'v';
	private static final char b = 'w';
	private static final char s = 'x';
	private static final char j = 'y';
	private static final char a = 'z';
	
	private static final char SPECIAL_CHARACTER1 = '`';
	private static final char SPECIAL_CHARACTER2 = '~';

	// decode keys for numbers

	private static final char _6 = '1';
	private static final char _4 = '2';
	private static final char _8 = '3';
	private static final char _2 = '4';
	private static final char _0 = '5';
	private static final char _1 = '6';
	private static final char _5 = '7';
	private static final char _3 = '8';
	private static final char _7 = '9';
	private static final char _9 = '0';


	/** @author Developed by Darshan Huidrom*/
	
	public static String decode(String data) {
		data = data.substring(0,data.length()-8);
		StringBuilder encodedData = new StringBuilder();
		char character;
		data =data.replaceAll("[\\`\\~]", "");
		for (int ii = data.length()-1; ii>=0; ii--) {
			character = data.charAt(ii);
			/*if (character > 96 && character < 123) {
				character = (char) (character - CONSTANT);
			}*/
			switch (character) {
			case 'A':
				encodedData.append(A);
				break;
			case 'B':
				encodedData.append(B);
				break;
			case 'C':
				encodedData.append(C);
				break;
			case 'D':
				encodedData.append(D);
				break;
			case 'E':
				encodedData.append(E);
				break;
			case 'F':
				encodedData.append(F);
				break;
			case 'G':
				encodedData.append(G);
				break;
			case 'H':
				encodedData.append(H);
				break;
			case 'I':
				encodedData.append(I);
				break;
			case 'J':
				encodedData.append(J);
				break;
			case 'K':
				encodedData.append(K);
				break;
			case 'L':
				encodedData.append(L);
				break;
			case 'M':
				encodedData.append(M);
				break;
			case 'N':
				encodedData.append(N);
				break;
			case 'O':
				encodedData.append(O);
				break;
			case 'P':
				encodedData.append(P);
				break;
			case 'Q':
				encodedData.append(Q);
				break;
			case 'R':
				encodedData.append(R);
				break;
			case 'S':
				encodedData.append(S);
				break;
			case 'T':
				encodedData.append(T);
				break;
			case 'U':
				encodedData.append(U);
				break;
			case 'V':
				encodedData.append(V);
				break;
			case 'W':
				encodedData.append(W);
				break;
			case 'X':
				encodedData.append(X);
				break;
			case 'Y':
				encodedData.append(Y);
				break;
			case 'Z':
				encodedData.append(Z);
				break;
			case 'a':
				encodedData.append(a);
				break;
			case 'b':
				encodedData.append(b);
				break;
			case 'c':
				encodedData.append(c);
				break;
			case 'd':
				encodedData.append(d);
				break;
			case 'e':
				encodedData.append(e);
				break;
			case 'f':
				encodedData.append(f);
				break;
			case 'g':
				encodedData.append(g);
				break;
			case 'h':
				encodedData.append(h);
				break;
			case 'i':
				encodedData.append(i);
				break;
			case 'j':
				encodedData.append(j);
				break;
			case 'k':
				encodedData.append(k);
				break;
			case 'l':
				encodedData.append(l);
				break;
			case 'm':
				encodedData.append(m);
				break;
			case 'n':
				encodedData.append(n);
				break;
			case 'o':
				encodedData.append(o);
				break;
			case 'p':
				encodedData.append(p);
				break;
			case 'q':
				encodedData.append(q);
				break;
			case 'r':
				encodedData.append(r);
				break;
			case 's':
				encodedData.append(s);
				break;
			case 't':
				encodedData.append(t);
				break;
			case 'u':
				encodedData.append(u);
				break;
			case 'v':
				encodedData.append(v);
				break;
			case 'w':
				encodedData.append(w);
				break;
			case 'x':
				encodedData.append(x);
				break;
			case 'y':
				encodedData.append(y);
				break;
			case 'z':
				encodedData.append(z);
				break;
			//////////////

				case '0':
					encodedData.append(_0);
					break;
				case '1':
					encodedData.append(_1);
					break;
				case '2':
					encodedData.append(_2);
					break;
				case '3':
					encodedData.append(_3);
					break;
				case '4':
					encodedData.append(_4);
					break;
				case '5':
					encodedData.append(_5);
					break;
				case '6':
					encodedData.append(_6);
					break;
				case '7':
					encodedData.append(_7);
					break;
				case '8':
					encodedData.append(_8);
					break;
				case '9':
					encodedData.append(_9);
					break;

			default:
				encodedData.append(character);
				break;

			}

		}
		return encodedData.toString();
	}

}
