FILE_NAME = StdMapPtrPtr
CLASS_SUFFIX = <KeyT, ValueT>
DUAL_CLASS = std.mapPtrPtr<KeyT, ValueT>
PAIR_TYPE = std.pairPtrPtr<KeyT, ValueT>
ITERATOR = iterator<KeyT, ValueT>
GENERIC_ITERATOR = type$iterator<?, std.pairPtrPtr<KeyT, ValueT>>
KEY_TYPE = KeyT
VALUE_TYPE = ValueT
VALUE_REF = type$ref<ValueT>
VALUE_PTR = type$ptr<ValueT>
IS_KEY_POINTER_LIKE = true
IS_DATA_POINTER_LIKE = true
PAIR_FACTORY_METHOD = std.make_pair_Ptr_Ptr
DEFAULT_KEYS_COMPARATOR = Native::$compare_ptr
ASSERT_DEFAULT_VALUE=(defaultValue == null)