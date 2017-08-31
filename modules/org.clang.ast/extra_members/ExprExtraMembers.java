protected Expr(Expr other) {
  super(other);
  if (other.TR != null) {
    this.TR = other.TR.clone();
  }
}
