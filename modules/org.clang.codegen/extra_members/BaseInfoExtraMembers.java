public @Override
boolean $less(Object obj) {
  return $less((BaseInfo) obj);
}

public BaseInfo() {
  this.Offset = new CharUnits();
}

public /*inline*/ BaseInfo /*&*/ $assign(final BaseInfo /*&&*/ $Prm0) {
  this.Decl = $Prm0.Decl;
  this.Offset.$assign($Prm0.Offset);
  this.Index = $Prm0.Index;
  return /*Deref*/ this;
}

public /*inline*/ BaseInfo(final BaseInfo /*&&*/ $Prm0) {
  // : Decl(static_cast<BaseInfo &&>().Decl), Offset(static_cast<BaseInfo &&>().Offset), Index(static_cast<BaseInfo &&>().Index) 
  //START JInit
  this.Decl = $Prm0.Decl;
  this.Offset = new CharUnits($Prm0.Offset);
  this.Index = $Prm0.Index;
  //END JInit
}

@Override
public BaseInfo clone() {
  return new BaseInfo(this);
}

@Override
public BaseInfo move() {
  return new BaseInfo(JD$Move.INSTANCE, this);
}
