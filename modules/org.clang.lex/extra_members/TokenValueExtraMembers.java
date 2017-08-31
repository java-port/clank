public TokenValue() {
  /*for collections*/
  this('\0');
}

public /*inline*/ TokenValue(TokenValue /*&&*/$Prm0) {
  /* : Kind(static_cast<TokenValue &&>().Kind), II(static_cast<TokenValue &&>().II)*/ 
  //START JInit
  this.Kind = $Prm0.Kind;
  this.II = $Prm0.II;
  //END JInit
}

@Override
public TokenValue $assign(TokenValue $Prm0) {
  this.Kind = $Prm0.Kind;
  this.II = $Prm0.II;
  return this;
}

@Override
public TokenValue clone() {
  return new TokenValue(this);
}

@Override
public TokenValue move() {
  return new TokenValue(JD$Move.INSTANCE, this);
}
