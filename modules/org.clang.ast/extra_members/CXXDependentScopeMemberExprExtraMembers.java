@Override 
public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
  return numTrailingObjects((OverloadToken<ASTTemplateKWAndArgsInfo>)null); 
}

@Override
public final type$ptr<?> $TrailingObjects() {
  return super.$this$plus1();
}

@Override
public final int getTrailingObjects$Offset(Class<?> clazz) {
  assert clazz == ASTTemplateKWAndArgsInfo.class
          || clazz == TemplateArgumentLoc.class;
  if (clazz == ASTTemplateKWAndArgsInfo.class) {
    return 0;
  }
  return getNumTailingObject_OverloadToken$TrailingTy1();
}
