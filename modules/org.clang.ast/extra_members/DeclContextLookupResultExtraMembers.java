@Override public java.util.Iterator<NamedDecl /*P*/> iterator() {
  return new JavaIterator(begin(), end());
}

@Override
public DeclContextLookupResult move() {
  return new DeclContextLookupResult(JD$Move.INSTANCE, this);
}
