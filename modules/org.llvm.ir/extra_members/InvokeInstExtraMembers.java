public void addAttribute(/*uint*/int i, StringRef Kind, StringRef Value) {
  AttributeSet PAL = new AttributeSet(getAttributes());
  PAL.$assignMove(PAL.addAttribute(getContext(), i, Kind));
  setAttributes(PAL);
}