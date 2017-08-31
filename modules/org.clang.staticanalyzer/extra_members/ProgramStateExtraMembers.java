@FunctionalInterface
private static interface $SymbolVisitorFactory<T extends SymbolVisitor> {
  T $call(IntrusiveRefCntPtr<ProgramState> p);
}

private static <T extends SymbolVisitor> T $construct(Class<T> clazz, ProgramState ps) {
  assert ps.checkAlive();
  $SymbolVisitorFactory factory = ctors.get(clazz);
  assert factory != null : "No factory for " + clazz;
  IntrusiveRefCntPtr<ProgramState> state = new IntrusiveRefCntPtr</*const*/ ProgramState>(ps);
  try {
    return (T) factory.$call(state);
  } finally {
    state.$destroy();
  }
}

private static <T extends SymbolVisitor> void $registerFactory(Class<T> clazz, $SymbolVisitorFactory<T> factory) {
  ctors.put(clazz, factory);
}

private static final java.util.Map<Class<? extends SymbolVisitor>, $SymbolVisitorFactory> ctors = new java.util.HashMap<>(64);

static {
  $registerFactory(RetainCountCheckerStatics.StopTrackingCallback.class, (IntrusiveRefCntPtr<ProgramState> p) -> { return new RetainCountCheckerStatics.StopTrackingCallback(p); });
  $registerFactory(MallocCheckerStatics.StopTrackingCallback.class, (IntrusiveRefCntPtr<ProgramState> p) -> { return new MallocCheckerStatics.StopTrackingCallback(p); });
  $registerFactory(SimpleStreamCheckerStatics.StopTrackingCallback.class, (IntrusiveRefCntPtr<ProgramState> p) -> { return new SimpleStreamCheckerStatics.StopTrackingCallback(p); });
  $registerFactory(CollectReachableSymbolsCallback.class, (IntrusiveRefCntPtr<ProgramState> p) -> { return new CollectReachableSymbolsCallback(p); });
}

@Override
public void Retain() {
  assert checkAlive();
  ProgramStateRetain(this);
}

@Override
public void Release() {
  assert checkAlive();
  ProgramStateRelease(this);
}
