FILE_NAME = StdMapULongPtr
CLASS_SUFFIX = <ValueT>
DUAL_CLASS = std.mapULongPtr<ValueT>
PAIR_TYPE = std.pairULongPtr<ValueT>
ITERATOR = iterator<ValueT>
GENERIC_ITERATOR = type$iterator<?, std.pairULongPtr<ValueT>>
KEY_TYPE = Long
VALUE_TYPE = ValueT
VALUE_REF = type$ref<ValueT>
VALUE_PTR = type$ptr<ValueT>
IS_KEY_POINTER_LIKE = false
IS_DATA_POINTER_LIKE = true
PAIR_FACTORY_METHOD = std.make_pair_ulong_Ptr
DEFAULT_KEYS_COMPARATOR = Native::$compare_type_ulong
ASSERT_DEFAULT_VALUE=(defaultValue == null)