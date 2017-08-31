public ModuleFlagEntry() {
  this.Behavior = ModFlagBehavior.Error;
  this.Key = null;
  this.Val = null;      
}

@Override public ModuleFlagEntry clone() {
  return new ModuleFlagEntry(this.Behavior, this.Key, this.Val);
}
