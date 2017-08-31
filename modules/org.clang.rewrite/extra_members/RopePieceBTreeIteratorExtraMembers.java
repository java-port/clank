@Override public RopePieceBTreeIterator clone() {
  return new RopePieceBTreeIterator(this);
}

@Override
public boolean $eq(Object other) {
  return $eq((RopePieceBTreeIterator)other);
}

@Override
public boolean $noteq(Object other) {
  return $noteq((RopePieceBTreeIterator)other);
}

@Override
public int $sub(RopePieceBTreeIterator iter) {
  return std.distance(iter, this, JD$FAKE.TRAILING);
}

@Override
public RopePieceBTreeIterator $add(int amount) {
  RopePieceBTreeIterator tmp = new RopePieceBTreeIterator(/*Deref*/this);    
  return tmp.$inc(amount);
}

@Override
public RopePieceBTreeIterator $inc(int amount) {
  for (int i = 0; i < amount; ++i) {
    $preInc();
  }
  return this;
}

private void $iterator() { }
private void $iterator(Object dummy) { }
private void $iterator(JD$Move _dparm, Object dummy) { }
