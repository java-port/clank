public ModifySubobjectHandler(EvalInfo Info, APValue NewVal, Expr E) {
  this.Info = Info;
  this.NewVal = NewVal;
  this.E = E;
}
@Override public AccessKinds AccessKind() {
  return AccessKind;
}
