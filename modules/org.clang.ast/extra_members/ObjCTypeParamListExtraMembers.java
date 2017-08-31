@Override public java.util.Iterator<ObjCTypeParamDecl> iterator() { 
  return new JavaIterator<ObjCTypeParamDecl>(begin(), end()); 
}

@Override
public int getTrailingObjects$Offset(Class<?> clazz) {
  assert clazz == ObjCTypeParamDecl.class;
  return 0;
}

private final type$ptr<?> $TrailingObjects;

@Override
public final type$ptr<?> $TrailingObjects() {
  return $TrailingObjects;
}
