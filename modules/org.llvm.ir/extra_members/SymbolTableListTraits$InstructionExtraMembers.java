private final Instruction $sentinelField = Instruction.$createSentinel();

@Override
public Instruction $SentinelField() {
  return $sentinelField;
}

@Override
public Class<Instruction> $getValueSubClass() {
  return Instruction.class;
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static class SymbolTableList$Instruction extends SymbolTableList<Instruction, BasicBlock> {

  public SymbolTableList$Instruction(BasicBlock/*P*/ Owner) {
    super(Owner);
  }

  @Override
  public Instruction $SentinelField() {
    return (Instruction)((SymbolTableListTraits)super.$traits()).$SentinelField();
  }

  @Override
  protected SymbolTableListTraits$Instruction $createTraits() {
    return new SymbolTableListTraits$Instruction();
  }

  @Override
  public Class<Instruction> $getValueSubClass() {
    return ((SymbolTableListTraits)super.$traits()).$getValueSubClass();
  }
}
