public void $destroy() { }

@FunctionalInterface
public interface Void2SVal {
  SVal $call();
}

@FunctionalInterface
public interface SVal2Boolean {
  boolean $call(SVal p);
}

private static final java.util.Map<Class<? extends SVal>, Void2SVal> SValConstuctor = new java.util.HashMap<>(64);
private static final java.util.Map<Class<? extends SVal>, SVal2Boolean> SValToIsKind = new java.util.HashMap<>(64);
static void mapSValToTypeClass(Class<? extends SVal> SValClass, SVal2Boolean isKind, Void2SVal conctructor) {
  SValConstuctor.put(SValClass, conctructor);
  SValToIsKind.put(SValClass, isKind);
}

static { SVal.mapSValToTypeClass(UnknownVal.class, UnknownVal::isKind, ()->{return new UnknownVal();}); }
static { SVal.mapSValToTypeClass(KnownSVal.class, KnownSVal::isKind, ()->{return new KnownSVal();}); }
static { SVal.mapSValToTypeClass(NonLoc.class, NonLoc::isKind, ()->{return new NonLoc();}); }
static { SVal.mapSValToTypeClass(Loc.class, Loc::isKind, ()->{return new Loc();}); }
static { SVal.mapSValToTypeClass(DefinedOrUnknownSVal.class, DefinedOrUnknownSVal::isKind, ()->{return new DefinedOrUnknownSVal();}); }
static { SVal.mapSValToTypeClass(NsLoc.GotoLabel.class, NsLoc.GotoLabel::isKind, ()->{return new NsLoc.GotoLabel();}); }
static { SVal.mapSValToTypeClass(NsLoc.MemRegionVal.class, NsLoc.MemRegionVal::isKind, ()->{return new NsLoc.MemRegionVal();}); }
static { SVal.mapSValToTypeClass(NsLoc.ConcreteInt.class, NsLoc.ConcreteInt::isKind, ()->{return new NsLoc.ConcreteInt();}); }
static { SVal.mapSValToTypeClass(NsNonloc.SymbolVal.class, NsNonloc.SymbolVal::isKind, ()->{return new NsNonloc.SymbolVal();}); }
static { SVal.mapSValToTypeClass(NsNonloc.ConcreteInt.class, NsNonloc.ConcreteInt::isKind, ()->{return new NsNonloc.ConcreteInt();}); }
static { SVal.mapSValToTypeClass(NsNonloc.LocAsInteger.class, NsNonloc.LocAsInteger::isKind, ()->{return new NsNonloc.LocAsInteger();}); }
static { SVal.mapSValToTypeClass(NsNonloc.CompoundVal.class, NsNonloc.CompoundVal::isKind, ()->{return new NsNonloc.CompoundVal();}); }
static { SVal.mapSValToTypeClass(NsNonloc.LazyCompoundVal.class, NsNonloc.LazyCompoundVal::isKind, ()->{return new NsNonloc.LazyCompoundVal();}); }
static { SVal.mapSValToTypeClass(UndefinedVal.class, UndefinedVal::isKind, ()->{return new UndefinedVal();}); }
static { SVal.mapSValToTypeClass(DefinedSVal.class, DefinedSVal::isKind, ()->{return new DefinedSVal();}); }

@Override public SVal clone() { 
  assert this.getClass() == SVal.class : "Why not overridden in " + this.getClass();
  return new SVal(this); 
}

@Override public SVal move() {
  assert this.getClass() == SVal.class : "Why not overridden in " + this.getClass();
  return new SVal(JD$Move.INSTANCE, this);
}

@Override public void swap(NativeSwappable Other) {
  assert this.getClass() == Other.getClass();
  SVal RHS = (SVal) Other;
  Object tmp = this.Data; 
  this.Data = RHS.Data; 
  RHS.Data = tmp; 
  int t = this._Kind; 
  this._Kind = RHS._Kind; 
  RHS._Kind = t; 
}
