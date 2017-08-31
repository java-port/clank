@Override public type$ptr<?> $TrailingObjects() {
  return super.$this$plus1();
}

@Override public int getTrailingObjects$Offset(Class<?> clazz) {
  assert NestedNameSpecifierLoc.class == clazz
          || NamedDecl.class == clazz
          || ASTTemplateKWAndArgsInfo.class == clazz
          || TemplateArgumentLoc.class == clazz : "Unexpected class: " + clazz;
  int index = 0;
  if (NestedNameSpecifierLoc.class == clazz) {
    return index;
  }
  index += getNumTailingObject_OverloadToken$TrailingTy1();
  if (NamedDecl.class == clazz) {
    return index;
  }
  index += getNumTailingObject_OverloadToken$TrailingTy2();
  if (ASTTemplateKWAndArgsInfo.class == clazz) {
    return index;
  }
  return index + getNumTailingObject_OverloadToken$TrailingTy3();
}

@Override public /*size_t*/ int getNumTailingObject_OverloadToken$TrailingTy1() {
  return numTrailingObjects_OverloadToken$NestedNameSpecifierLoc((OverloadToken<NestedNameSpecifierLoc>) null);
}

@Override public /*size_t*/ int getNumTailingObject_OverloadToken$TrailingTy2() {
  return numTrailingObjects_OverloadToken$NamedDecl$P((OverloadToken<NamedDecl /*P*/>) null);
}

@Override public /*size_t*/ int getNumTailingObject_OverloadToken$TrailingTy3() {
  return numTrailingObjects_OverloadToken$ASTTemplateKWAndArgsInfo((OverloadToken<ASTTemplateKWAndArgsInfo>) null);
}
