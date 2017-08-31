public constantint_match(long/*int64_t*/ Val) {
  this.Val = Val;
}

public constantint_match(constantint_match other) {
  this.Val = other.Val;
}

@Override
public constantint_match clone() {
  return new constantint_match(this);
}
