public DeclOffset(int Loc, int BitOffset) {
  this.Loc = Loc;
  this.BitOffset = BitOffset;
}

public static final int $sizeof_DeclOffset(){
  return 8;
}

@Override
public int $sizeof() {
  return $sizeof_DeclOffset();
}

@Override
public byte[] toByteArray() {
  return new byte[]{
    ToByteArray.get0(Loc),
    ToByteArray.get1(Loc),
    ToByteArray.get2(Loc),
    ToByteArray.get3(Loc),
    ToByteArray.get0(BitOffset),
    ToByteArray.get1(BitOffset),
    ToByteArray.get2(BitOffset),
    ToByteArray.get3(BitOffset)
  };
}

@Override
public DeclOffset $assign(DeclOffset value) {
  this.BitOffset = value.BitOffset;
  this.Loc = value.Loc;
  return this;
}

@Override
public DeclOffset clone() {
  return new DeclOffset(Loc, BitOffset);
}
