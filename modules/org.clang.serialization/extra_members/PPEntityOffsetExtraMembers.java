public static final int $sizeof_PPEntityOffset(){
  return sizeof$uint32() * 3/* 3 uint fields*/;
}

public PPEntityOffset(int Begin, int End, int BitOffset) {
  this.Begin = Begin;
  this.End = End;
  this.BitOffset = BitOffset;
}

public PPEntityOffset() {
}

@Override
public int $sizeof() {
  return $sizeof_PPEntityOffset();
}

@Override
public byte[] toByteArray() {
  return new byte[]{
    ToByteArray.get0(Begin),
    ToByteArray.get1(Begin),
    ToByteArray.get2(Begin),
    ToByteArray.get3(Begin),
    ToByteArray.get0(End),
    ToByteArray.get1(End),
    ToByteArray.get2(End),
    ToByteArray.get3(End),
    ToByteArray.get0(BitOffset),
    ToByteArray.get1(BitOffset),
    ToByteArray.get2(BitOffset),
    ToByteArray.get3(BitOffset)
  };
}

@Override
public PPEntityOffset clone() {
  return new PPEntityOffset(this.Begin, this.End, this.BitOffset);
}
