public MDTupleTypedArrayWrapper $assignMove(final /*const*/ MDTupleTypedArrayWrapper<T> /*&*/ Other) {
  throw new UnsupportedOperationException("EmptyBody");
}

public MDTupleTypedArrayWrapper(MDTupleTypedArrayWrapper<T> Other) {
  this.N = new MDTuple(Other.N);
  this.clazz = Other.clazz;
}

public @Override Iterator<T> iterator() {
 return new JavaIterator<T>(begin(), end());
}

private final Class<T> clazz;
