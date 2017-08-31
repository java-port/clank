@Override
public Change $assign(Change $Prm0) {
  this.CreateReplacement = $Prm0.CreateReplacement;
  this.OriginalWhitespaceRange.$assign($Prm0.OriginalWhitespaceRange);
  this.StartOfTokenColumn = $Prm0.StartOfTokenColumn;
  this.NewlinesBefore = $Prm0.NewlinesBefore;
  this.PreviousLinePostfix.$assign($Prm0.PreviousLinePostfix);
  this.CurrentLinePrefix.$assign($Prm0.CurrentLinePrefix);
  this.Kind = $Prm0.Kind;
  this.ContinuesPPDirective = $Prm0.ContinuesPPDirective;
  this.IsStartOfDeclName = $Prm0.IsStartOfDeclName;
  this.IndentLevel = $Prm0.IndentLevel;
  this.Spaces = $Prm0.Spaces;
  this.IsInsideToken = $Prm0.IsInsideToken;
  this.IsTrailingComment = $Prm0.IsTrailingComment;
  this.TokenLength = $Prm0.TokenLength;
  this.PreviousEndOfTokenColumn = $Prm0.PreviousEndOfTokenColumn;
  this.EscapedNewlineColumn = $Prm0.EscapedNewlineColumn;
  this.StartOfBlockComment = $Prm0.StartOfBlockComment;
  this.IndentationOffset = $Prm0.IndentationOffset;
  return /*Deref*/this;
}

@Override
public Change clone() {
  Change res = new Change();
  res.$assign(this);
  return res;
}

@Override
public boolean $eq(Change other) {
  if (this == other) {
    return true;
  }
  if (other == null) {
    return false;
  }
  if (getClass() != other.getClass()) {
    return false;
  }
  if (this.CreateReplacement != other.CreateReplacement) {
    return false;
  }
  if (this.StartOfTokenColumn != other.StartOfTokenColumn) {
    return false;
  }
  if (this.NewlinesBefore != other.NewlinesBefore) {
    return false;
  }
  if (this.Kind != other.Kind) {
    return false;
  }
  if (this.ContinuesPPDirective != other.ContinuesPPDirective) {
    return false;
  }
  if (this.IsStartOfDeclName != other.IsStartOfDeclName) {
    return false;
  }
  if (this.IndentLevel != other.IndentLevel) {
    return false;
  }
  if (this.Spaces != other.Spaces) {
    return false;
  }
  if (this.IsInsideToken != other.IsInsideToken) {
    return false;
  }
  if (this.IsTrailingComment != other.IsTrailingComment) {
    return false;
  }
  if (this.TokenLength != other.TokenLength) {
    return false;
  }
  if (this.PreviousEndOfTokenColumn != other.PreviousEndOfTokenColumn) {
    return false;
  }
  if (this.EscapedNewlineColumn != other.EscapedNewlineColumn) {
    return false;
  }
  if (this.IndentationOffset != other.IndentationOffset) {
    return false;
  }
  if (!Objects.equals(this.OriginalWhitespaceRange, other.OriginalWhitespaceRange)) {
    return false;
  }
  if (!Objects.equals(this.PreviousLinePostfix, other.PreviousLinePostfix)) {
    return false;
  }
  if (!Objects.equals(this.CurrentLinePrefix, other.CurrentLinePrefix)) {
    return false;
  }
  if (!Objects.equals(this.StartOfBlockComment, other.StartOfBlockComment)) {
    return false;
  }
  return true;
}
