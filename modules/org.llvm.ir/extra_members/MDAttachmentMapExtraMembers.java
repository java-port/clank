@Override
public MDAttachmentMap clone() {
  assert Attachments.empty() : "can clone only empty";
  return new MDAttachmentMap();
}
