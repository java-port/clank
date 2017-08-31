public Argument_match(Argument_match</*typename*/ Opnd_t> other) {
  this.OpI = other.OpI;
  this.Val = other.Val;
}

@Override
public Argument_match</*typename*/ Opnd_t> clone() {
  return new Argument_match(this);
}
