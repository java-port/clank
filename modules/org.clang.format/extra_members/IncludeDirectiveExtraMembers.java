public IncludeDirective(StringRef Filename, StringRef Text, int Offset, int Category) {
  this.Filename = Filename;
  this.Text = Text;
  this.Offset = Offset;
  this.Category = Category;
}

public IncludeDirective() { 
  Text = new StringRef();
  Filename = new StringRef();
}

@Override
public IncludeDirective $assign(IncludeDirective value) {
  this.Category = value.Category;
  this.Offset = value.Offset;
  this.Filename.$assign(value.Filename);
  this.Text.$assign(value.Text);
  return this;
}

@Override
public IncludeDirective clone() {
  IncludeDirective res = new IncludeDirective();
  res.$assign(this);
  return res;
}
