public br_match(br_match other) {
  this.Succ = other.Succ;
}

@Override
public br_match clone() {
  return new br_match(this);
}
