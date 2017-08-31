public CallArg() {
  this.RV = new RValue();
  this.Ty = new QualType();
  this.NeedsCopy = false;
}

@Override
public CallArg clone() {
  return new CallArg(RV, Ty, NeedsCopy);
}
