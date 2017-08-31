public BranchFixup() {
}

@Override
public BranchFixup $assign(BranchFixup $Prm0) {
  this.OptimisticBranchBlock = $Prm0.OptimisticBranchBlock;
  this.Destination = $Prm0.Destination;
  this.DestinationIndex = $Prm0.DestinationIndex;
  this.InitialBranch = $Prm0.InitialBranch;
  return this;
}

public BranchFixup(BranchFixup $Prm0) {
  this.OptimisticBranchBlock = $Prm0.OptimisticBranchBlock;
  this.Destination = $Prm0.Destination;
  this.DestinationIndex = $Prm0.DestinationIndex;
  this.InitialBranch = $Prm0.InitialBranch;
}

@Override
public BranchFixup clone() {
  return new BranchFixup(this);
}
