public /*inline*/ StandaloneFixIt(StandaloneFixIt /*&&*/$Prm0) {
  // : RemoveRange(static_cast<StandaloneFixIt &&>().RemoveRange), InsertFromRange(static_cast<StandaloneFixIt &&>().InsertFromRange), CodeToInsert(static_cast<StandaloneFixIt &&>().CodeToInsert), BeforePreviousInsertions(static_cast<StandaloneFixIt &&>().BeforePreviousInsertions) 
  //START JInit
  this.RemoveRange = new std.pairUIntUInt($Prm0.RemoveRange);
  this.InsertFromRange = new std.pairUIntUInt($Prm0.InsertFromRange);
  this.CodeToInsert = new std.string($Prm0.CodeToInsert);
  this.BeforePreviousInsertions = $Prm0.BeforePreviousInsertions;
  //END JInit
}

@Override public StandaloneFixIt clone() {
  return new StandaloneFixIt(this);
}

@Override public StandaloneFixIt move() {
  return new StandaloneFixIt(JD$Move.INSTANCE, this);
}
