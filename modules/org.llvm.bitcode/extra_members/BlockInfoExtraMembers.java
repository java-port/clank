public /*inline*/ BlockInfo(final BlockInfo /*&&*/$Prm0) {
  // : BlockID(static_cast<BlockInfo &&>().BlockID), Abbrevs(static_cast<BlockInfo &&>().Abbrevs) 
  //START JInit
  this.BlockID = $Prm0.BlockID;
  this.Abbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>($Prm0.Abbrevs);
  //END JInit
}

@Override public BlockInfo clone() {
  return new BlockInfo(this);
}
