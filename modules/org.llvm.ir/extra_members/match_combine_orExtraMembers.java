public match_combine_or(match_combine_or<LTy, RTy> other) {
  this.L = /*ParenListExpr*/$Clone(other.L);
  this.R = /*ParenListExpr*/$Clone(other.R);
}

@Override
public match_combine_or clone() {
  return new match_combine_or(this);
}
