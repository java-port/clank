@Override public TypoCorrection clone() { 
  return new TypoCorrection(this); 
}

@Override public TypoCorrection move() { 
  return new TypoCorrection(JD$Move.INSTANCE, this); 
}
