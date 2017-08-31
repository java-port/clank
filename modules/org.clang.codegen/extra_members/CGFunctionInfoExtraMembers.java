private final type$ptr<?> $This$TrailingObjects = $ITrailingObjectsJavaBase();

@Override
public final type$ptr<?> $TrailingObjects() {
  assert $This$TrailingObjects != null;
  return $This$TrailingObjects;
}

@Override
public final int getTrailingObjects$Offset(Class<?> clazz) {
  if (clazz == CGFunctionInfoArgInfo.class) {
    return 0;
  } else {
    assert clazz == FunctionProtoType.ExtParameterInfo.class;
    return numTrailingObjects_OverloadToken$CGFunctionInfoArgInfo(null);
  }
}
