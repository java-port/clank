public BreakContinue() { 
  BreakBlock = new JumpDest();
  ContinueBlock = new JumpDest();
}

@Override public BreakContinue clone() {
  return new BreakContinue(this.BreakBlock, this.ContinueBlock);
}

@Override 
public BreakContinue $assign(BreakContinue Other) { 
  this.BreakBlock.$assign(Other.BreakBlock); 
  this.ContinueBlock.$assign(Other.ContinueBlock); 
  return this; 
}   

@Override 
public BreakContinue $assignMove(BreakContinue Other) { 
  this.BreakBlock.$assignMove(Other.BreakBlock); 
  this.ContinueBlock.$assignMove(Other.ContinueBlock); 
  return this; 
}  
