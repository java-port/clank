private type$ref</*const*/ CallExpr /*P*/> visitingCallExpr$ref = new type$ref</*const*/ CallExpr /*P*/>(){
  @Override
  public CallExpr $deref() {
    return visitingCallExpr;
  }

  @Override
  public CallExpr $set(CallExpr value) {
    visitingCallExpr = value;
    return visitingCallExpr;
  }
};
