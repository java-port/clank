public MCCVLoc() {
}

public MCCVLoc(int FunctionId, int FileNum, int Line, char Column, boolean PrologueEnd, boolean IsStmt) {
  this.FunctionId = FunctionId;
  this.FileNum = FileNum;
  this.Line = Line;
  this.Column = Column;
  this.PrologueEnd = PrologueEnd;
  this.IsStmt = IsStmt;
}
