public /*inline*/ DominanceFrontierBase(JavaDifferentiators.JD$Move _dparam, final DominanceFrontierBase /*&&*/$Prm0) {
  this.Frontiers = Native.$tryMove($Prm0.Frontiers);
  this.IsPostDominators = $Prm0.IsPostDominators;
  this.Roots = $Prm0.Roots.move();
}
