public SMFixIt() {
  this.Range = new SMRange();
  this.Text = new string();
}

@Override
public boolean $less(Object Other) {
  return this.$less((SMFixIt)Other);
}

@Override
public SMFixIt $assign(SMFixIt value) {
  this.Range = value.Range;
  this.Text = value.Text;
  return this;
}

@Override
public SMFixIt clone() {
  SMFixIt res = new SMFixIt();
  res.$assign(this);
  return res;
}
