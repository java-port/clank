private final Function $sentinelField = Function.CreateSentinel();

@Override
public Function $SentinelField() {
  return $sentinelField;
}

@Override
public Class<Function> $getValueSubClass() {
  return Function.class;
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static class SymbolTableList$Function extends SymbolTableList<Function, Module> {

  public SymbolTableList$Function(Module/*P*/ Owner) {
    super(Owner);
  }

  @Override
  public Function $SentinelField() {
    return (Function)((SymbolTableListTraits)super.$traits()).$SentinelField();
  }

  @Override
  protected SymbolTableListTraits$Function $createTraits() {
    return new SymbolTableListTraits$Function();
  }

  @Override
  public Class<Function> $getValueSubClass() {
    return ((SymbolTableListTraits)super.$traits()).$getValueSubClass();
  }
}
