private final GlobalIFunc $sentinelField = GlobalIFunc.createSentinel();

@Override
public GlobalIFunc $SentinelField() {
  return $sentinelField;
}

@Override
public Class<GlobalIFunc> $getValueSubClass() {
  return GlobalIFunc.class;
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static class SymbolTableList$GlobalIFunc extends SymbolTableList<GlobalIFunc, Module> {

  public SymbolTableList$GlobalIFunc(Module/*P*/ Owner) {
    super(Owner);
  }

  @Override
  public GlobalIFunc $SentinelField() {
    return (GlobalIFunc)((SymbolTableListTraits)super.$traits()).$SentinelField();
  }

  @Override
  protected SymbolTableListTraits$GlobalIFunc $createTraits() {
    return new SymbolTableListTraits$GlobalIFunc();
  }

  @Override
  public Class<GlobalIFunc> $getValueSubClass() {
    return ((SymbolTableListTraits)super.$traits()).$getValueSubClass();
  }
}
