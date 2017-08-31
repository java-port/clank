FILE_NAME = StdVectorULong
CLASS_SUFFIX =
MAIN_CLASS = std.vectorULong
TYPE = long
BOXED_TYPE = Long
ARRAY_TYPE = long
NEW_ZERO_ARRAY = new$ulong(0)
COPY_OF_ARRAY = copyOf$ulong
POINTER_TYPE = ulong$ptr
POINTER_FACTORY_MTD = create_ulong$ptr
REFERENCE_TYPE = ulong$ref
REFERENCE_FACTORY_MTD = create_ulong$ref
ITERATOR_NAME = iterator
ITERATOR_TYPE = iterator
ITERATOR_INTERFACE = ulong$iterator<iterator>
GENERIC_ITERATOR = ulong$iterator<?>
JAVA_ITERATOR = JavaIteratorULong
NATIVE_CONTAINER = NativeContainerULong
REV_ITERATOR_TYPE = std.reverse_iteratorULong
SET_IMPL = array[(int) idx] = value; return value;
SET_MOVE_IMPL = array[(int) idx] = value; return value;
REF_SET_IMPL = array[index] = value; return value;
DESTROY_RANGE_IMPL = /*Do not need to destroy primitive types*/
DEFAULT_VALUE = 0
SB_APPEND_ELEMENT_I=out.append(element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return false;
ASSERT_DEFAULT_VALUE=true
SUPPLIER = long
RESIZE_WITH_SUPPLIER = // No supplier => no version of resize with supplier
DEFVAL_WITH_SUPPLIER = return defaultValue
USE_OF_SUPPLIER = Supplier
ELEMENT_BOOL_PREDICATE=NativeCallback.ULongBoolPredicate
