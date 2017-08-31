private final GlobalAlias $sentinelField = GlobalAlias.createSentinel();

@Override
public GlobalAlias $SentinelField() {
  return $sentinelField;
}

@Override
public Class<GlobalAlias> $getValueSubClass() {
  return GlobalAlias.class;
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static class SymbolTableList$GlobalAlias extends SymbolTableList<GlobalAlias, Module> {

  public SymbolTableList$GlobalAlias(Module/*P*/ Owner) {
    super(Owner);
  }

  @Override
  public GlobalAlias $SentinelField() {
    return (GlobalAlias)((SymbolTableListTraits)super.$traits()).$SentinelField();
  }

  @Override
  protected SymbolTableListTraits$GlobalAlias $createTraits() {
    return new SymbolTableListTraits$GlobalAlias();
  }

  @Override
  public Class<GlobalAlias> $getValueSubClass() {
    return ((SymbolTableListTraits)super.$traits()).$getValueSubClass();
  }
}
