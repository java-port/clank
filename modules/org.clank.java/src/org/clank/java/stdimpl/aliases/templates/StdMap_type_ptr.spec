FILE_NAME = StdMapTypePtr
CLASS_SUFFIX = <KeyT, ValueT>
DUAL_CLASS = std.mapTypePtr<KeyT, ValueT>
PAIR_TYPE = std.pairTypePtr<KeyT, ValueT>
ITERATOR = iterator<KeyT, ValueT>
GENERIC_ITERATOR = type$iterator<?, std.pairTypePtr<KeyT, ValueT>>
KEY_TYPE = KeyT
VALUE_TYPE = ValueT
VALUE_REF = type$ref<ValueT>
VALUE_PTR = type$ptr<ValueT>
IS_KEY_POINTER_LIKE = false
IS_DATA_POINTER_LIKE = true
PAIR_FACTORY_METHOD = std.make_pair_T_Ptr
DEFAULT_KEYS_COMPARATOR = Native::$compare_type
ASSERT_DEFAULT_VALUE=(defaultValue == null)