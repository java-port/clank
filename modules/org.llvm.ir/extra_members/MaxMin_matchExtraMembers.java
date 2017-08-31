private final Class<CmpInst_t> cls;
private final Pred_t pred;

public MaxMin_match(MaxMin_match<CmpInst_t, LHS_t, RHS_t, Pred_t> other) {
  this.cls = other.cls;
  this.L = /*ParenListExpr*/$Clone(other.L);
  this.R = /*ParenListExpr*/$Clone(other.R);
  this.pred = other.pred;
}

@Override
public MaxMin_match clone() {
  return new MaxMin_match(this);
}
