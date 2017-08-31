private static final IdentifierIndexReaderTrait $Trait = new IdentifierIndexReaderTrait();
public static IdentifierIndexReaderTrait $Trait() {
  return $Trait;
}

private IdentifierIndexReaderTrait() {
}

@Override public final /*std.pair<uint, uint>*/long ReadKeyDataLength(final char$ptr/*const uchar P&*/ Buf, int OffsetInBuf) {
  //JAVA: using namespace llvm::support;
  /*uint*/int KeyLen = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInBuf));
                      OffsetInBuf += NativeType.sizeof$uint16();
  /*uint*/int DataLen = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInBuf));
  return wrap_uint_uint_pair(KeyLen, DataLen);
}
@Override public final /*uint*/int getReadKeyDataLengthBytes() {
  return NativeType.sizeof$uint16() + NativeType.sizeof$uint16();
}

@Override public final StringRef ReadKey(/*const*/char$ptr/*uchar P*/ Buf, int OffsetInBuf, /*uint*/int KeyLength) {
  // copied from ReadKey and adjusted with OffsetInBuf
  return new StringRef(Buf.$add(OffsetInBuf), KeyLength);
}
