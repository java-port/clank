public BitCodeAbbrevOp() {
}

public BitCodeAbbrevOp(BitCodeAbbrevOp other) {
  this.Val = other.Val;
  this.IsLiteral = other.IsLiteral;
  this.Enc = $uint2uint_3bits($3bits_uint2uint(other.Enc));
}

@Override
public BitCodeAbbrevOp clone() {
  return new BitCodeAbbrevOp(this);
}
