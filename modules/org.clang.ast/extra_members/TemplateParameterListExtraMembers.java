@Override
public java.util.Iterator<NamedDecl> iterator() {
  return new JavaIterator<NamedDecl>(begin(), end());
}

@Override
public </*typename*/ T> type$ptr<T> getTrailingObjects(Class<T> clazz) {
  assert clazz == NamedDecl.class : "unexpected class " + clazz; 
  return (type$ptr<T>)$Trailing$Params;
}

private final type$ptr<NamedDecl /*P*/> $Trailing$Params;