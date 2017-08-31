@Override 
public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
  return numTrailingObjects_OverloadToken$TemplateArgumentLoc((OverloadToken<TemplateArgumentLoc>)null); 
}

public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy2() { 
  return numTrailingObjects_OverloadToken$FunctionTemplateDecl$P((OverloadToken<FunctionTemplateDecl /*P*/ >)null); 
}

private final type$ptr<?> $TrailingObjects;
  
@Override
public final type$ptr<?> $TrailingObjects() {
  return $TrailingObjects;
}

@Override
public final int getTrailingObjects$Offset(Class<?> clazz) {
  assert clazz == TemplateArgumentLoc.class
          || clazz == FunctionTemplateDecl.class;
  if (clazz == TemplateArgumentLoc.class) {
    return 0;
  }
  return getNumTailingObject_OverloadToken$TrailingTy1();
}
