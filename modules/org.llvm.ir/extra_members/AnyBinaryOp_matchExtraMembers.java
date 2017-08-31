public AnyBinaryOp_match(AnyBinaryOp_match<LHS_t, RHS_t> other) {
  this.L = /*ParenListExpr*/$Clone(other.L);
  this.R = /*ParenListExpr*/$Clone(other.R);
}

@Override
public AnyBinaryOp_match clone() {
  return new AnyBinaryOp_match(this);
}
