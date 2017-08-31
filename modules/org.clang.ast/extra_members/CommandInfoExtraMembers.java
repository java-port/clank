public CommandInfo() {
  //=zero-initialize
}
public CommandInfo(char$ptr Name, char$ptr EndCommandName, int ID, int NumArgs, int IsInlineCommand, int IsBlockCommand, int IsBriefCommand, int IsReturnsCommand, int IsParamCommand, int IsTParamCommand, int IsThrowsCommand, int IsDeprecatedCommand, int IsHeaderfileCommand, int IsEmptyParagraphAllowed, int IsVerbatimBlockCommand, int IsVerbatimBlockEndCommand, int IsVerbatimLineCommand, int IsDeclarationCommand, int IsFunctionDeclarationCommand, int IsRecordLikeDetailCommand, int IsRecordLikeDeclarationCommand, int IsUnknownCommand) {
  this.Name = Name;
  this.EndCommandName = EndCommandName;
  this.ID = ID;
  this.NumArgs = (byte) NumArgs;
  this.IsInlineCommand = IsInlineCommand != 0;
  this.IsBlockCommand = IsBlockCommand != 0;
  this.IsBriefCommand = IsBriefCommand != 0;
  this.IsReturnsCommand = IsReturnsCommand != 0;
  this.IsParamCommand = IsParamCommand != 0;
  this.IsTParamCommand = IsTParamCommand != 0;
  this.IsThrowsCommand = IsThrowsCommand != 0;
  this.IsDeprecatedCommand = IsDeprecatedCommand != 0;
  this.IsHeaderfileCommand = IsHeaderfileCommand != 0;
  this.IsEmptyParagraphAllowed = IsEmptyParagraphAllowed != 0;
  this.IsVerbatimBlockCommand = IsVerbatimBlockCommand != 0;
  this.IsVerbatimBlockEndCommand = IsVerbatimBlockEndCommand != 0;
  this.IsVerbatimLineCommand = IsVerbatimLineCommand != 0;
  this.IsDeclarationCommand = IsDeclarationCommand != 0;
  this.IsFunctionDeclarationCommand = IsFunctionDeclarationCommand != 0;
  this.IsRecordLikeDetailCommand = IsRecordLikeDetailCommand != 0;
  this.IsRecordLikeDeclarationCommand = IsRecordLikeDeclarationCommand != 0;
  this.IsUnknownCommand = IsUnknownCommand != 0;
}