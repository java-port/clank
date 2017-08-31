public void update(long Data) { 
  // we ignore endian since for MD5 this does not matter, just process all bytes
  byte[] a = new byte[8];
  for (int i = 0; i < 8; i++) {
    a[i] = (byte) (Data & 0xFF); // low byte
    Data <<= 8;
  }
  update(new ArrayRefChar(a));
}

public void __final(final /*uint8*/byte Result[]) {
  __final(create_char$ptr(Result));
}

public static void stringifyResult(final /*uint8*/byte Result[], final SmallString/*32*/ /*&*/ Str) {
  stringifyResult(create_char$ptr(Result), Str);
}
