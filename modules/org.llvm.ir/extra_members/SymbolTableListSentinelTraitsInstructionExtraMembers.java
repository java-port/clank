private final Instruction $sentinelField = Instruction.$createSentinel();

@Override
public Instruction $SentinelField() {
  return $sentinelField;
}

@Override
public Class<Instruction> $getValueSubClass() {
  return Instruction.class;
}