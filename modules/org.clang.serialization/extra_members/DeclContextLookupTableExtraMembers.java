public static final DeclContextLookupTable EMPTY_VALUE = new DeclContextLookupTable();
@Override
public DeclContextLookupTable clone() {
  assert this == EMPTY_VALUE : "only empty tables can be cloned from collections. Forgot to use DeclContextLookupTable.EMPTY vs new DeclContextLookupTable()?";
  return new DeclContextLookupTable();
}

@Override
public DeclContextLookupTable move() {
  return new DeclContextLookupTable(JD$Move.INSTANCE, this);
}
