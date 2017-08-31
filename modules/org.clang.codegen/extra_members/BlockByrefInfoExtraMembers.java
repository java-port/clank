@Override public BlockByrefInfo clone() {
  return new BlockByrefInfo(this);
}

@Override public BlockByrefInfo move() {
  return new BlockByrefInfo(JD$Move.INSTANCE, this);
}

@Override 
public BlockByrefInfo $assign(BlockByrefInfo $Prm0) { 
  this.Type = $Prm0.Type; 
  this.FieldIndex = $Prm0.FieldIndex; 
  this.ByrefAlignment.$assign($Prm0.ByrefAlignment); 
  this.FieldOffset.$assign($Prm0.FieldOffset); 
  return this; 
} 

@Override 
public BlockByrefInfo $assignMove(BlockByrefInfo $Prm0) { 
  this.Type = $Prm0.Type; 
  this.FieldIndex = $Prm0.FieldIndex; 
  this.ByrefAlignment.$assignMove($Prm0.ByrefAlignment); 
  this.FieldOffset.$assignMove($Prm0.FieldOffset); 
  return this; 
} 
