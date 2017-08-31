FILE_NAME = ImutAVLValueIterator
CLASS_SUFFIX = <ValT>
ADAPTOR_BASE = iterator_adaptor_base<ImutAVLValueIterator<ValT>, ImutAVLTreeInOrderIterator<?, ?, ValT>, std.bidirectional_iterator_tag, /*const*/ ValT/*P*/, /*const*/ ValT/*&*/>
CLASS_TYPE = ImutAVLValueIterator<ValT>
AVL_TREE_TYPE = ImutAVLTree<?, ?, ValT>
AVL_ORDERED_ITER_NAME = ImutAVLTreeInOrderIterator
VALUE_TYPE = ValT