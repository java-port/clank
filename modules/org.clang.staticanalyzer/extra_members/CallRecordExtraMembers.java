private CallRecord() {
  this.CastedExprParent = new PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ >(/*const*/ Stmt /*P*/.class);
}

public /*inline*/ CallRecord(final CallRecord /*&&*/$Prm0) {
  // : CastedExprParent(static_cast<CallRecord &&>().CastedExprParent), CastedExpr(static_cast<CallRecord &&>().CastedExpr), ExplicitCastType(static_cast<CallRecord &&>().ExplicitCastType), AllocCall(static_cast<CallRecord &&>().AllocCall) 
  //START JInit
  this.CastedExprParent = new PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ >($Prm0.CastedExprParent);
  this.CastedExpr = $Prm0.CastedExpr;
  this.ExplicitCastType = $Prm0.ExplicitCastType;
  this.AllocCall = $Prm0.AllocCall;
  //END JInit
}

@Override public CallRecord clone() {
  return new CallRecord(this);
}
