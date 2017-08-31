@Override 
public java.util.Iterator<pairUIntType<SmallVector<UniqueVirtualMethod>>> iterator() {
  return new JavaIterator(begin(), end());
}

@Override
public OverridingMethods clone() {
  return new OverridingMethods(this);
}
