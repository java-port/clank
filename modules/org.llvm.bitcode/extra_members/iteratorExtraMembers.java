protected /*inline*/ iterator(iterator /*&&*/$Prm0) {
  super();
  throw new UnsupportedOperationException("EmptyBody");
}

@Override public boolean $eq(Object RHS) { return this.$eq((iterator)RHS); }
@Override public iterator clone() { return new iterator(this); }
