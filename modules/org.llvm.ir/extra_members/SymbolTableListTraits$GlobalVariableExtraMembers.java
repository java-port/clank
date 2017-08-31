private final GlobalVariable $sentinelField = GlobalVariable.$CreateSentinel();

@Override
public GlobalVariable $SentinelField() {
  return $sentinelField;
}

@Override
public Class<GlobalVariable> $getValueSubClass() {
  return GlobalVariable.class;
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public class SymbolTableList$GlobalVariable extends SymbolTableList<GlobalVariable, Module> {

  public SymbolTableList$GlobalVariable( /*P*/ Module Owner) {
    super(Owner);
  } /*P*/

  @Override
  public GlobalVariable $SentinelField() {
    return (GlobalVariable) ((SymbolTableListTraits) super.$traits()).$SentinelField();
  }

  @Override
  protected SymbolTableListTraits$GlobalVariable $createTraits() {
    return new SymbolTableListTraits$GlobalVariable();
  }

  @Override
  public Class<GlobalVariable> $getValueSubClass() {
    return ((SymbolTableListTraits) super.$traits()).$getValueSubClass();
  }

}
