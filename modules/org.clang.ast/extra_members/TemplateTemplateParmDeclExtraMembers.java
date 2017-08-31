private final TemplateParmPosition$Fields TemplateParmPosition$Flds;// use return value of $TemplateParmPosition();
@Override public final TemplateParmPosition$Fields $TemplateParmPosition$Fields() { return TemplateParmPosition$Flds; }

@Override
public type$ptr<?> $TrailingObjects() {
  return $This$Ptr().$add(1); // skip this class
}

@Override
public int getTrailingObjects$Offset(Class<?> clazz) {
  assert clazz == TemplateParameterList.class : "unexpected class " + clazz;
  return 0;
}

@Override
public int getIndex() {
  return TemplateParmPosition.super.getIndex();
}
