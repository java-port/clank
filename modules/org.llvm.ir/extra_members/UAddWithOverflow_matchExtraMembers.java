public UAddWithOverflow_match(UAddWithOverflow_match<LHS_t, RHS_t, Sum_t> other) {
  this.L = /*ParenListExpr*/$Clone(other.L);
  this.R = /*ParenListExpr*/$Clone(other.R);
  this.S = /*ParenListExpr*/$Clone(other.S);
}

@Override
public UAddWithOverflow_match clone() {
  return new UAddWithOverflow_match(this);
}
