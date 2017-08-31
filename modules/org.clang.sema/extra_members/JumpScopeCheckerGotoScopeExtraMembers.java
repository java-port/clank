@Override
public GotoScope $assign(GotoScope $Prm0) {
  this.ParentScope = $Prm0.ParentScope;
  this.InDiag = $Prm0.InDiag;
  this.OutDiag = $Prm0.OutDiag;
  this.Loc = new SourceLocation($Prm0.Loc);
  return this;      
}

@Override public GotoScope clone() { 
  return new GotoScope(this.ParentScope, this.InDiag, this.OutDiag, this.Loc); 
}