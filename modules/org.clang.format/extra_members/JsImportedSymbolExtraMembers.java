public JsImportedSymbol(JsImportedSymbol other) {
  this.Symbol = new StringRef(other.Symbol);
  this.Alias = new StringRef(other.Alias);
  this.Range = new SourceRange(other.Range);
}

@Override
public JsImportedSymbol clone() {
  return new JsImportedSymbol(this);
}