FILE_NAME = ImutAVLTreeTypeUIntType
CLASS_SUFFIX = </*typename ImutInfo*/ KeyT, ValT>
AVL_TREE_TYPE = ImutAVLTreeTypeUIntType<KeyT, ValT>
AVL_FACTORY_TYPE = ImutAVLFactoryTypeUIntType<KeyT, ValT>
AVL_GENERIC_ITER_TYPE = ImutAVLTreeGenericIteratorTypeUIntType<KeyT, ValT>
AVL_ORDERED_ITER_TYPE = ImutAVLTreeInOrderIteratorTypeUIntType<KeyT, ValT>
INFO_TYPE = ImutAVLTreeInfoTypeUIntType<KeyT, ValT>
CALLBACL_FUNC_TYPE = Type2Void<ValT>
KEY_TYPE = KeyT
DATA_TYPE = /*uint*/int
VALUE_TYPE = ValT
CLONE_VALUE_IMPL = Native.$tryClone(V)