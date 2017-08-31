@Override
public type$ptr<?> $TrailingObjects() {
  return $This$Ptr().$add(1); // skip this class
}

@Override
public int getTrailingObjects$Offset(Class<?> clazz) {
  assert clazz == SourceLocation.class;
  return 0;
}
