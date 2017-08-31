public CastClass_match(CastClass_match<Op_t> other) {
  /*template parameter*/ this.Opcode = other.Opcode;
  this.Op = /*ParenListExpr*/$Clone(other.Op);
}

@Override
public CastClass_match clone() {
  return new CastClass_match(this);
}
