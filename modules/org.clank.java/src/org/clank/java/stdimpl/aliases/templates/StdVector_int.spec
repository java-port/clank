FILE_NAME = StdVectorInt
CLASS_SUFFIX =
MAIN_CLASS = std.vectorInt
TYPE = int
BOXED_TYPE = Integer
ARRAY_TYPE = int
NEW_ZERO_ARRAY = new$int(0);
COPY_OF_ARRAY = copyOf$int
POINTER_TYPE = int$ptr
POINTER_FACTORY_MTD = create_int$ptr
REFERENCE_TYPE = int$ref
REFERENCE_FACTORY_MTD = create_int$ref
ITERATOR_NAME = iterator
ITERATOR_TYPE = iterator
ITERATOR_INTERFACE = int$iterator<iterator>
GENERIC_ITERATOR = int$iterator<?>
JAVA_ITERATOR = JavaIteratorInt
NATIVE_CONTAINER = NativeContainerInt
REV_ITERATOR_TYPE = std.reverse_iteratorInt
SET_IMPL = array[(int) idx] = value; return value;
SET_MOVE_IMPL = array[(int) idx] = value; return value;
REF_SET_IMPL = array[index] = value; return value;
DESTROY_RANGE_IMPL = /*Do not need to destroy primitive types*/
DEFAULT_VALUE = 0
SB_APPEND_ELEMENT_I=out.append(element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return false;
ASSERT_DEFAULT_VALUE=true
SUPPLIER = int
RESIZE_WITH_SUPPLIER = // No supplier => no version of resize with supplier
DEFVAL_WITH_SUPPLIER = return defaultValue
USE_OF_SUPPLIER = Supplier
ELEMENT_BOOL_PREDICATE=NativeCallback.IntBoolPredicate
