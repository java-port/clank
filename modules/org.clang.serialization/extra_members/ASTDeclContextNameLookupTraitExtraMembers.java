public ASTDeclContextNameLookupTrait() {
  this.Reader = null;
  this.F = null;
}

@Override public data_type_builder new$data_type_builder(SmallVectorUInt data) {
  return new data_type_builder(data);
}

@Override public SmallVectorUInt new$data_type() {
  return new SmallVectorUInt(0);
}

@Override public /*uint*/int $MaxTables() {
  return MaxTables;
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
