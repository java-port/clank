private final Predicate predicate;

public cst_pred_ty(Predicate predicate) {
  this.predicate = predicate;
}

public boolean isValue(APInt C) {
  return predicate.isValue(C);
}

@Override
public cst_pred_ty clone() {
  return new cst_pred_ty(this);
}
