Block() {
  this.PrevAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(new IntrusiveRefCntPtr<BitCodeAbbrev>());
  this.PrevCodeSize = 0;
}

public Block(Block other) {
  this.PrevCodeSize = other.PrevCodeSize;
  this.StartSizeWord = other.StartSizeWord;
  this.PrevAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(other.PrevAbbrevs);
}

@Override public Block clone() {
  return new Block(this);
}

@Override
public Block $assign(Block $Prm0) {
  this.PrevCodeSize = $Prm0.PrevCodeSize;
  this.StartSizeWord = $Prm0.StartSizeWord;
  this.PrevAbbrevs.$assign($Prm0.PrevAbbrevs);
  return this;
}

@Override
public Block $assignMove(Block $Prm0) {
  this.PrevCodeSize = $Prm0.PrevCodeSize;
  this.StartSizeWord = $Prm0.StartSizeWord;
  this.PrevAbbrevs.$assignMove($Prm0.PrevAbbrevs);
  return this;
}

@Override
public Block move() {
  return new Block(JD$Move.INSTANCE, this);
}
