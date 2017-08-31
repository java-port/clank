public SelectClass_match(SelectClass_match<Cond_t, LHS_t, RHS_t> other) {
  this.C = /*ParenListExpr*/$Clone(other.C);
  this.L = /*ParenListExpr*/$Clone(other.L);
  this.R = /*ParenListExpr*/$Clone(other.R);
}

@Override
public SelectClass_match clone() {
  return new SelectClass_match(this);
}
