@Override
public final long ReadKeyDataLength(char$ptr Buf, int OffsetInBuf) {
  // copied from ReadKeyDataLength and replaced readNext by read
  /*uint*/int DataLen = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInBuf));
  /*uint*/int KeyLen = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInBuf));
  return wrap_uint_uint_pair(KeyLen, DataLen);
}

@Override
public final int getReadKeyDataLengthBytes() {
  return sizeof$uint16()*2;
}

@Override
public data_type ReadData(StringRef key, char$ptr Buf, int OffsetInBuf, int DataLength) {
  throw new UnsupportedOperationException("Why not overridden non-shifting readData in " + this.getClass());
}

public static /*uint*/int $ComputeHash(final /*const*/ StringRef /*&*/ a) {
  return llvm.HashString(a);
}
