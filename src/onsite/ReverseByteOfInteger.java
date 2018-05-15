package onsite;

/*
 * Write a function to reverse the byte order of a 32-bit unsigned integer.
ex: input = 0x12345678, output = 0x78563412
 */
public class ReverseByteOfInteger {
	public int reverseByte(int num) {
		int res = 0;
		for (int movePos = 0; movePos < 4; movePos++) {
			int temp = 0;
			for (int i = movePos * 8; i < (movePos + 1) * 8; i++) {
				temp = temp | (1 << i);
			}
			temp = temp & num;
			temp = temp >> (movePos * 8);
			res = res | (temp << (24 - movePos * 8));
		}
		return res;
	}

	public int reverseByteChecker(int input) {
		int output = ((input & 0x000000FF) << 24) | ((input & 0x0000FF00) << 8) | ((input & 0x00FF0000) >> 8)
				| ((input & 0xFF000000) >> 24);
		return output;
	}
}
