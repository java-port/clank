public match_combine_and(match_combine_and<LTy, RTy> other) {
  this.L = /*ParenListExpr*/$Clone(other.L);
  this.R = /*ParenListExpr*/$Clone(other.R);
}

@Override
public match_combine_and clone() {
  return new match_combine_and(this);
}
