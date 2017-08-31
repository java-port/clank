@Override
public java.util.Iterator<Attribute> iterator() {
  return new JavaIterator<Attribute>(begin(), end());
}

private final type$ptr<?> $This$TrailingObjects = $ITrailingObjectsJavaBase();

@Override
public final type$ptr<?> $TrailingObjects() {
  assert $This$TrailingObjects != null;
  return $This$TrailingObjects;
}

@Override
public int getTrailingObjects$Offset(Class<?> clazz) {
  assert clazz == Attribute.class;
  return 0;
}
