private static final MapInfo $INFO = new MapInfo();

public static MapInfo $Info() { return $INFO; }

@Override public boolean isKeyPointerLike() { return true; }

@Override
public int getHashValueAlt(Object AltKey) {
  assert AltKey != null;
  if (AltKey instanceof std.pairUIntType) {
    return getHashValue_pair$int$C$P((std.pairUIntType<std.pair<Type /*P*/ , ConstantExprKeyType >>) AltKey);
  } else {
    return getHashValue_pair$TypeClass$ValType$C$P((std.pair<Type /*P*/ , ConstantExprKeyType >)AltKey);
  }
}

@Override
public boolean isEqualAlt(Object AltKey, /*const*/ ConstantExpr /*P*/ RHS) {
  assert AltKey != null;
  if (AltKey instanceof std.pairUIntType) {
    return isEqual_pair$int$C$P_T$C$P((std.pairUIntType<std.pair<Type /*P*/ , ConstantExprKeyType >>) AltKey, RHS);
  } else {
    return isEqual_pair$TypeClass$ValType$C$P_T$C$P((std.pair<Type /*P*/ , ConstantExprKeyType >)AltKey, RHS);
  }
}
