public static int $sizeof_ObjCCategoriesInfo(){
  return 2*sizeof$uint32();
}

@Override
public int $sizeof() {
  return $sizeof_ObjCCategoriesInfo();
}

@Override
public byte[] toByteArray() {
  byte[] bytes = new byte[$sizeof_ObjCCategoriesInfo()];
  for (int i = 0; i < bytes.length; i++) {
    bytes[i] = get$Char$At$Index(i, this);
  }
  return bytes;
}

public ObjCCategoriesInfo() {
}

public ObjCCategoriesInfo(int DefinitionID, int Offset) {
  this.DefinitionID = DefinitionID;
  this.Offset = Offset;
}

private ObjCCategoriesInfo(char$ptr Buf) {
  this.DefinitionID = endian.readNext_uint32(endianness.little, support.unaligned, Buf);
  this.Offset = endian.readNext_uint32(endianness.little, support.unaligned, Buf);
}

public static type$ptr<ObjCCategoriesInfo /*P*/> fromBytes(char$ptr Buf, int Num) {
  char$ptr ptr = $Clone(Buf);
  final ObjCCategoriesInfo[] array = new$T(new ObjCCategoriesInfo[Num],()->new ObjCCategoriesInfo(ptr));
  return create_type$ptr(array);
}

@Override
public ObjCCategoriesInfo $assign(ObjCCategoriesInfo $Prm0) {
  this.DefinitionID = $Prm0.DefinitionID;
  this.Offset = $Prm0.Offset;
  return this;
}

@Override
public ObjCCategoriesInfo clone() {
  return new ObjCCategoriesInfo(this.DefinitionID, this.Offset);
}

/**
 * little endian presentation of object as stream of chars
 * @param index
 * @param Obj
 * @return 
 */
public static /*char*/byte get$Char$At$Index(int index, ObjCCategoriesInfo Obj) {
  assert index >= 0 : "index=" + index;
  assert index < $sizeof_ObjCCategoriesInfo() : "" + index + " vs. " + $sizeof_ObjCCategoriesInfo();
  switch (index) {
    case 0:
      return NativeType.ToByteArray.get0(Obj.DefinitionID);
    case 1:
      return NativeType.ToByteArray.get1(Obj.DefinitionID);
    case 2:
      return NativeType.ToByteArray.get2(Obj.DefinitionID);
    case 3:
      return NativeType.ToByteArray.get3(Obj.DefinitionID);
    case 4:
      return NativeType.ToByteArray.get0(Obj.Offset);
    case 5:
      return NativeType.ToByteArray.get1(Obj.Offset);
    case 6:
      return NativeType.ToByteArray.get2(Obj.Offset);
    case 7:
      return NativeType.ToByteArray.get3(Obj.Offset);
    default:
      throw new IllegalArgumentException("Invalid index " + index);
  }
}

@Override
public boolean $less(Object obj) {
  return $less_ObjCCategoriesInfo$C(this, ((ObjCCategoriesInfo)obj));
}

@Override
public boolean $lesseq(Object obj) {
  return $lesseq_ObjCCategoriesInfo$C(this, ((ObjCCategoriesInfo)obj));
}
