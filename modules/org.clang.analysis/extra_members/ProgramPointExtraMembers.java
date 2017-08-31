@FunctionalInterface
public interface Void2ProgramPoint {
  ProgramPoint $call();
}

@FunctionalInterface
public interface ProgramPoint2Boolean {
  boolean $call(ProgramPoint p);
}

private static final java.util.Map<Class<? extends ProgramPoint>, Void2ProgramPoint> ProgramPointConstuctor = new java.util.HashMap<>(64);
private static final java.util.Map<Class<? extends ProgramPoint>, ProgramPoint2Boolean> ProgramPointToIsKind = new java.util.HashMap<>(64);
static void mapProgramPointToTypeClass(Class<? extends ProgramPoint> ProgramPointClass, ProgramPoint2Boolean isKind, Void2ProgramPoint conctructor) {
  ProgramPointConstuctor.put(ProgramPointClass, conctructor);
  ProgramPointToIsKind.put(ProgramPointClass, isKind);
}

static { ProgramPoint.mapProgramPointToTypeClass(EpsilonPoint.class, EpsilonPoint::isKind, ()->{return new EpsilonPoint();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PreImplicitCall.class, PreImplicitCall::isKind, ()->{return new PreImplicitCall();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PostStmtPurgeDeadSymbols.class, PostStmtPurgeDeadSymbols::isKind, ()->{return new PostStmtPurgeDeadSymbols();}); }
static { ProgramPoint.mapProgramPointToTypeClass(CallExitEnd.class, CallExitEnd::isKind, ()->{return new CallExitEnd();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PreLoad.class, PreLoad::isKind, ()->{return new PreLoad();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PostCondition.class, PostCondition::isKind, ()->{return new PostCondition();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PostStore.class, PostStore::isKind, ()->{return new PostStore();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PostLoad.class, PostLoad::isKind, ()->{return new PostLoad();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PreStore.class, PreStore::isKind, ()->{return new PreStore();}); }
static { ProgramPoint.mapProgramPointToTypeClass(CallEnter.class, CallEnter::isKind, ()->{return new CallEnter();}); }
static { ProgramPoint.mapProgramPointToTypeClass(BlockEntrance.class, BlockEntrance::isKind, ()->{return new BlockEntrance();}); }
static { ProgramPoint.mapProgramPointToTypeClass(BlockEdge.class, BlockEdge::isKind, ()->{return new BlockEdge();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PreStmtPurgeDeadSymbols.class, PreStmtPurgeDeadSymbols::isKind, ()->{return new PreStmtPurgeDeadSymbols();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PostImplicitCall.class, PostImplicitCall::isKind, ()->{return new PostImplicitCall();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PostInitializer.class, PostInitializer::isKind, ()->{return new PostInitializer();}); }
static { ProgramPoint.mapProgramPointToTypeClass(BlockExit.class, BlockExit::isKind, ()->{return new BlockExit();}); }
static { ProgramPoint.mapProgramPointToTypeClass(CallExitBegin.class, CallExitBegin::isKind, ()->{return new CallExitBegin();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PostLValue.class, PostLValue::isKind, ()->{return new PostLValue();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PreStmt.class, PreStmt::isKind, ()->{return new PreStmt();}); }
static { ProgramPoint.mapProgramPointToTypeClass(ImplicitCallPoint.class, ImplicitCallPoint::isKind, ()->{return new ImplicitCallPoint();}); }
static { ProgramPoint.mapProgramPointToTypeClass(PostStmt.class, PostStmt::isKind, ()->{return new PostStmt();}); }
static { ProgramPoint.mapProgramPointToTypeClass(LocationCheck.class, LocationCheck::isKind, ()->{return new LocationCheck();}); }
static { ProgramPoint.mapProgramPointToTypeClass(StmtPoint.class, StmtPoint::isKind, ()->{return new StmtPoint();}); }

private static final ProgramPoint EMPTY_KEY = new ProgramPoint(new BlockEntrance());
public static ProgramPoint getEmptyKey() { return EMPTY_KEY; }

private static final ProgramPoint TOMBSTONE_KEY = new ProgramPoint(new BlockEntrance());
public static ProgramPoint getTombstoneKey() { return TOMBSTONE_KEY; }

@Override public ProgramPoint clone() {
  assert this.getClass() == ProgramPoint.class : "must be overridden in " + this.getClass();
  return new ProgramPoint(this);
}

@Override public ProgramPoint move() {
  assert this.getClass() == ProgramPoint.class : "must be overridden in " + this.getClass();
  return new ProgramPoint(JD$Move.INSTANCE, this);
}
