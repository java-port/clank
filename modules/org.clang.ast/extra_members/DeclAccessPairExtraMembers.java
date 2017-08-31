@Override
public DeclAccessPair clone() {
  return new DeclAccessPair(this);
}

/*friend*/ Integer /*P*/ getDecl$ID() /*const*/ {
  assert Ptr != null : "must be used only by lazy decls";
  return (Integer)Ptr;
}

private void set(Object /*P*/ D, AccessSpecifier AS) {
  assert this != DEFAULT;
  Ptr = D;//((Object/*uintptr_t*/)(AS.getValue())) | reinterpret_cast_Object/*uintptr_t*/(D);
  Specifier = AS;
}

public static DeclAccessPair make(int /*NamedDecl P*/ D, AccessSpecifier AS) {
  DeclAccessPair p/*J*/ = new DeclAccessPair();
  p.set(Integer.valueOf(D), AS);
  return p;
}

@Override public DeclAccessPair move() {
  return new DeclAccessPair(JD$Move.INSTANCE, this);
}

public static final DeclAccessPair DEFAULT = new DeclAccessPair();
