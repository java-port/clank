private final type$ptr<?> $TrailingObjs = $ITrailingObjectsJavaBase();

@Override 
public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
  return numTrailingObjects((OverloadToken<ASTTemplateKWAndArgsInfo>)null); 
}

@Override
public type$ptr<?> $TrailingObjects() {
  return $TrailingObjs;
}

@Override
public int getTrailingObjects$Offset(Class<?> clazz) {
  assert clazz == ASTTemplateKWAndArgsInfo.class 
          || clazz == TemplateArgumentLoc.class;
  if (clazz == ASTTemplateKWAndArgsInfo.class) {
    return 0;
  }
  return getNumTailingObject_OverloadToken$TrailingTy1();
}
