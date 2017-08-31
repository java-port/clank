FILE_NAME = StdMapUIntPtr
CLASS_SUFFIX = <ValueT>
DUAL_CLASS = std.mapUIntPtr<ValueT>
PAIR_TYPE = std.pairUIntPtr<ValueT>
ITERATOR = iterator<ValueT>
GENERIC_ITERATOR = type$iterator<?, std.pairUIntPtr<ValueT>>
KEY_TYPE = Integer
VALUE_TYPE = ValueT
VALUE_REF = type$ref<ValueT>
VALUE_PTR = type$ptr<ValueT>
IS_KEY_POINTER_LIKE = false
IS_DATA_POINTER_LIKE = true
PAIR_FACTORY_METHOD = std.make_pair_uint_Ptr
DEFAULT_KEYS_COMPARATOR = Native::$compare_type_uint
ASSERT_DEFAULT_VALUE=(defaultValue == null)