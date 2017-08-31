private ProgramStateTraitInitializedTemporariesSet() {
  super(new DefaultFoldingSetPairPtrPtr</*const*/ CXXBindTemporaryExpr /*P*/ , /*const*/ StackFrameContext /*P*/ >());
}

public static ProgramStateTraitInitializedTemporariesSet $Instance = new ProgramStateTraitInitializedTemporariesSet();

@Override
public std_pair.pair<CXXBindTemporaryExpr/*P*/, StackFrameContext/*P*/> $tryCloneKey(std_pair.pair<CXXBindTemporaryExpr/*P*/, StackFrameContext/*P*/> K) {
  assert K instanceof std.pairPtrPtr : "unexpected class " + NativeTrace.getIdentityStr(K);
  return Native.$Clone(K);
}
