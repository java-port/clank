private final BasicBlock $sentinelField = new BasicBlock();

@Override
public BasicBlock $SentinelField() {
  return $sentinelField;
}

@Override
public Class<BasicBlock> $getValueSubClass() {
  return BasicBlock.class;
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static class SymbolTableList$BasicBlock extends SymbolTableList<BasicBlock, Function> {

  public SymbolTableList$BasicBlock(Function/*P*/ Owner) {
    super(Owner);
  }

  @Override
  public BasicBlock $SentinelField() {
    return (BasicBlock)((SymbolTableListTraits)super.$traits()).$SentinelField();
  }

  @Override
  protected SymbolTableListTraits$BasicBlock $createTraits() {
    return new SymbolTableListTraits$BasicBlock();
  }

  @Override
  public Class<BasicBlock> $getValueSubClass() {
    return ((SymbolTableListTraits)super.$traits()).$getValueSubClass();
  }
}
