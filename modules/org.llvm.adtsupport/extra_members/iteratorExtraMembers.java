@Override
public iterator clone() {
  return new iterator(this);
}

@Override
public iterator const_clone() {
  return clone();
}

@Override
public boolean $eq(Object other) {
  return $eq((iterator)other);
}
