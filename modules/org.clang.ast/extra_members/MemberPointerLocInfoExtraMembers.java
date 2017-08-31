public MemberPointerLocInfo() {
  ClassTInfo = null;
}

public MemberPointerLocInfo(MemberPointerLocInfo $Prm0) {
  super($Prm0);
  this.ClassTInfo = $Prm0.ClassTInfo;
}

@Override
public MemberPointerLocInfo clone() {
  assert this.getClass() == MemberPointerLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new MemberPointerLocInfo(this);
}  
