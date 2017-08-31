@Override public FunctionCallbackVH clone() {
  assert this.getClass() == FunctionCallbackVH.class : "why not overridden in derived " + this.getClass();
  return new FunctionCallbackVH(this);
}

@Override public FunctionCallbackVH move() {
  assert this.getClass() == FunctionCallbackVH.class : "why not overridden in derived " + this.getClass();
  return new FunctionCallbackVH(JD$Move.INSTANCE, this);
}
