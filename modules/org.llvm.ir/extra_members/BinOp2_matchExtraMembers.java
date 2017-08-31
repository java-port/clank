public BinOp2_match(BinOp2_match<LHS_t, RHS_t> other) {
  /*template parameter*/ this.Opc1 = other.Opc1;
  /*template parameter*/ this.Opc2 = other.Opc2;
  this.L = /*ParenListExpr*/$Clone(other.L);
  this.R = /*ParenListExpr*/$Clone(other.R);
}

@Override
public BinOp2_match clone() {
  return new BinOp2_match(this);
}
