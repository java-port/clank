public MemberInfo() { 
  this.Offset = new CharUnits();
  this.Kind = InfoKind.valueOf(0);
  this.Data = null;
  this.Unnamed_field3 = new Unnamed_union1();      
}

public /*inline*/ MemberInfo(final MemberInfo /*&*/$Prm0) {
  // : Offset(static_cast<MemberInfo &&>().Offset), Kind(static_cast<MemberInfo &&>().Kind), Data(static_cast<MemberInfo &&>().Data), Unnamed_field3(static_cast<MemberInfo &&>().) 
  //START JInit
  this.Offset = new CharUnits($Prm0.Offset);
  this.Kind = $Prm0.Kind;
  this.Data = $Prm0.Data;
  this.Unnamed_field3 = new Unnamed_union1($Prm0.Unnamed_field3);
  //END JInit
}

@Override public MemberInfo clone() {
  return new MemberInfo(this);
}

private static int compare(MemberInfo LHS, MemberInfo RHS) {
  if (LHS == RHS) return 0;
  if (LHS.$less(RHS)) return -1;
  if (RHS.$less(LHS)) return 1;
  return 0;
}
