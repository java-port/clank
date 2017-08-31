@Override public SmallSet clone() { return new SmallSet(this); }

private boolean $areEqual(T o1, T o2) {
  if (C != null) {
    return C.compare(o1, o2) == 0;
  }
  return Native.$eq(o1, o2);
}
