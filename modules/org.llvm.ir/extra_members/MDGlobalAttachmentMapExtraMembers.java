@Override
public MDGlobalAttachmentMap clone() {
  assert this.Attachments.empty() : "only empty can be cloned";
  return new MDGlobalAttachmentMap();
}
