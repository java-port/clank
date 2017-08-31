public TypeOfTypeLocInfo() {
  UnderlyingTInfo = null;
}

public TypeOfTypeLocInfo(TypeOfTypeLocInfo $Prm0) {
  super($Prm0);
  this.UnderlyingTInfo = $Prm0.UnderlyingTInfo;
}

@Override
public TypeOfTypeLocInfo clone() {
  assert this.getClass() == TypeOfTypeLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new TypeOfTypeLocInfo(this);
}  
