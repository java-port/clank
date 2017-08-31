private ELFSectionKey(string SectionName, StringRef GroupName, int UniqueID) {
  this.SectionName = SectionName;
  this.GroupName = GroupName;
  this.UniqueID = UniqueID;
}

@Override
public ELFSectionKey clone() {
  return new ELFSectionKey(SectionName, GroupName, UniqueID);
}

@Override
public ELFSectionKey move() {
  return new ELFSectionKey(JD$Move.INSTANCE, this);
}
