public BinaryOp_match(BinaryOp_match</*typename*/ LHS_t, /*typename*/ RHS_t> other) {
  /*template parameter*/ this.Opcode = other.Opcode;
  this.L = /*ParenListExpr*/$Clone(other.L);
  this.R = /*ParenListExpr*/$Clone(other.R);
}

@Override
public BinaryOp_match clone() {
  return new BinaryOp_match(this);
}
