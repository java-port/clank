@Override 
public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
  return numTrailingObjects_OverloadToken$MemberExprNameQualifier((OverloadToken<MemberExprNameQualifier>)null); 
}

@Override 
public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy2() { 
  return numTrailingObjects_OverloadToken$ASTTemplateKWAndArgsInfo((OverloadToken<ASTTemplateKWAndArgsInfo>)null); 
}

@Override
public final type$ptr<?> $TrailingObjects() {
  return super.$this$plus1();
}

@Override
public final int getTrailingObjects$Offset(Class<?> clazz) {
  assert clazz == MemberExprNameQualifier.class
          || clazz == ASTTemplateKWAndArgsInfo.class
          || clazz == TemplateArgumentLoc.class;
  if (clazz == MemberExprNameQualifier.class) {
    return 0;
  } else if (clazz == ASTTemplateKWAndArgsInfo.class) {
    return getNumTailingObject_OverloadToken$TrailingTy1();
  }
  return getNumTailingObject_OverloadToken$TrailingTy1() + getNumTailingObject_OverloadToken$TrailingTy2();
}
