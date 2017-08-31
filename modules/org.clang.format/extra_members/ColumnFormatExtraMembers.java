@Override
public ColumnFormat $assign(ColumnFormat other) {
  this.ColumnSizes.$assign(other.ColumnSizes);
  this.Columns = other.Columns;
  this.LineCount = other.LineCount;
  this.TotalWidth = other.TotalWidth;
  return this;
}

@Override
public ColumnFormat clone() {
  return new ColumnFormat(this);
}