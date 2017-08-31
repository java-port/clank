@Override public iterator clone() { return new iterator(this); }

@Override
public iterator $assign(iterator $Prm0) {
  this.Ptr = $Prm0.Ptr instanceof type$ptr ? $tryConstClone($Prm0.Ptr) : $Prm0.Ptr;
  this.$lower$bits = $Prm0.$lower$bits;     
  return this;
}

@Override
public boolean $eq(Object other) {
  return $eq((iterator)other);
}

@Override
public int $sub(iterator iter) {
  return std.distance(iter, this, JD$FAKE.TRAILING);
}
