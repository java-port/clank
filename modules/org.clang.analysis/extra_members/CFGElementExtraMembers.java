@Override public void $destroy() { }

@FunctionalInterface
public interface Void2CFGElement {
  CFGElement $call();
}

@FunctionalInterface
public interface CFGElement2Boolean {
  boolean $call(CFGElement p);
}

private static final java.util.Map<Class<? extends CFGElement>, Void2CFGElement> CFGElementConstuctor = new java.util.HashMap<>(64);
private static final java.util.Map<Class<? extends CFGElement>, CFGElement2Boolean> CFGElementToIsKind = new java.util.HashMap<>(64);
static void mapCFGElementToTypeClass(Class<? extends CFGElement> CFGElementClass, CFGElement2Boolean isKind, Void2CFGElement conctructor) {
  CFGElementConstuctor.put(CFGElementClass, conctructor);
  CFGElementToIsKind.put(CFGElementClass, isKind);
}

static { CFGElement.mapCFGElementToTypeClass(CFGBaseDtor.class, CFGBaseDtor::isKind, ()->{return new CFGBaseDtor();}); }
static { CFGElement.mapCFGElementToTypeClass(CFGDeleteDtor.class, CFGDeleteDtor::isKind, ()->{return new CFGDeleteDtor();}); }
static { CFGElement.mapCFGElementToTypeClass(CFGInitializer.class, CFGInitializer::isKind, ()->{return new CFGInitializer();}); }
static { CFGElement.mapCFGElementToTypeClass(CFGStmt.class, CFGStmt::isKind, ()->{return new CFGStmt();}); }
static { CFGElement.mapCFGElementToTypeClass(CFGTemporaryDtor.class, CFGTemporaryDtor::isKind, ()->{return new CFGTemporaryDtor();}); }
static { CFGElement.mapCFGElementToTypeClass(CFGMemberDtor.class, CFGMemberDtor::isKind, ()->{return new CFGMemberDtor();}); }
static { CFGElement.mapCFGElementToTypeClass(CFGAutomaticObjDtor.class, CFGAutomaticObjDtor::isKind, ()->{return new CFGAutomaticObjDtor();}); }
static { CFGElement.mapCFGElementToTypeClass(CFGNewAllocator.class, CFGNewAllocator::isKind, ()->{return new CFGNewAllocator();}); }
static { CFGElement.mapCFGElementToTypeClass(CFGImplicitDtor.class, CFGImplicitDtor::isKind, ()->{return new CFGImplicitDtor();}); }

@Override
public CFGElement clone() {
  assert this.getClass() == CFGElement.class : "why not implemented in " + this.getClass();
  return new CFGElement(this);
}

@Override
public CFGElement move() {
  assert this.getClass() == CFGElement.class : "why not implemented in " + this.getClass();
  return new CFGElement(JD$Move.INSTANCE, this);
}
