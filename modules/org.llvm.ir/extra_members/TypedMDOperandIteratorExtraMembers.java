public TypedMDOperandIterator<T> clone() {
  return new TypedMDOperandIterator<T>(clazz, I.clone());
}

public TypedMDOperandIterator(TypedMDOperandIterator<T> Other) {
  I = Other.I.clone();
  clazz = Other.clazz;
}

private final Class<T> clazz;