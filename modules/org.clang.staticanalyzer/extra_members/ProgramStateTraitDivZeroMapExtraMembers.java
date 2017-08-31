private ProgramStateTraitDivZeroMap() {}

public static ProgramStateTraitDivZeroMap $Instance = new ProgramStateTraitDivZeroMap();

@Override
public ZeroState $tryCloneKey(ZeroState K) {
  return Native.$Clone(K);
}
