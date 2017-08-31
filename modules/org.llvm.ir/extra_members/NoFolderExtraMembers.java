public /*explicit*/ NoFolder(NoFolder other) {
  throw new UnsupportedOperationException("EmptyBody");
}
@Override
public NoFolder clone() {
  return new NoFolder(this);
}
@Override
public Instruction CreatePointerBitCastOrAddrSpaceCast(Constant C, Type DestTy) {
  throw new UnsupportedOperationException("NoFolder does not support CreatePointerBitCastOrAddrSpaceCast");
}