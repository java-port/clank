public OverflowingBinaryOp_match(OverflowingBinaryOp_match<LHS_t, RHS_t> other) {
  /*template parameter*/ this.Opcode = other.Opcode;
  /*template parameter*/ this.WrapFlags = other.WrapFlags;
  this.L = /*ParenListExpr*/$Clone(other.L);
  this.R = /*ParenListExpr*/$Clone(other.R);
}

@Override
public OverflowingBinaryOp_match clone() {
  return new OverflowingBinaryOp_match(this);
}
