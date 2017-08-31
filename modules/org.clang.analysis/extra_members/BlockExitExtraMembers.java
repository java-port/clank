protected BlockExit(BlockExit $Prm0) {
  super($Prm0);
}

protected BlockExit(JD$Move _dparam, BlockExit $Prm0) {
  super(_dparam, $Prm0);
}

@Override public BlockExit clone() {
  assert this.getClass() == BlockExit.class : "must be overridden in " + this.getClass();
  return new BlockExit(this);
}

@Override public BlockExit move() {
  assert this.getClass() == BlockExit.class : "must be overridden in " + this.getClass();
  return new BlockExit(JD$Move.INSTANCE, this);
}
