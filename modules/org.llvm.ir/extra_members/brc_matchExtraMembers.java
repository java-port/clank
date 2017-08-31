public brc_match(brc_match<Cond_t> other) {
  this.Cond = /*ParenListExpr*/$Clone(other.Cond);
  this./*&*/T=/*&*/other.T;
  this./*&*/F=/*&*/other.T;
}

@Override
public brc_match clone() {
  return new brc_match(this);
}
