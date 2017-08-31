private final Class<ClassInst> cls;

public CmpClass_match(CmpClass_match<LHS_t, RHS_t, ClassInst, PredicateTy> other) {
  this.cls = other.cls;
  this./*&*/Predicate=/*&*//*ParenListExpr*/other.Predicate;
  this.L = /*ParenListExpr*/$Clone(other.L);
  this.R = /*ParenListExpr*/$Clone(other.R);
}

@Override
public CmpClass_match clone() {
  return new CmpClass_match(this);
}
