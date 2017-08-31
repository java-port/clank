private key_iterator(key_iterator other) {
  super(other);
  this.InfoObj = other.InfoObj;
}

@Override public key_iterator clone() {
  return new key_iterator(this);
}

@Override
public boolean $eq(Object other) {
  return iterator_base.$eq_iterator_base$C(this, (key_iterator) other);
}

public key_iterator<external_key_type, internal_key_type> $assignMove(key_iterator<external_key_type, internal_key_type> other) {
  super.$assignMove(other);
  assert this.InfoObj == other.InfoObj;
  return this;
}
